package me.libme.module.kafka.fn.logger;

import me.libme.kernel._c.util.CliParams;
import me.libme.kernel._c.util.JStringUtils;
import me.libme.module.kafka.ConsumerConnector;
import me.libme.module.kafka.KafkaConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import scalalg.me.libme.module.kafka.TopicPartitionParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Optional;

/**
 * Created by J on 2018/1/9.
 */
public class ReadLogger2File {

    private static final String TOPIC_PARTITION="--topicPartition";

    private static final String FILE="--file";

    private String filePath;

    private KafkaConsumerConfig kafkaConsumerConfig;

    private String[] args;

    public ReadLogger2File args(String[] args) {
        this.args = args;
        return this;
    }

    public ReadLogger2File kafkaConsumerConfig(KafkaConsumerConfig kafkaConsumerConfig) {
        this.kafkaConsumerConfig = kafkaConsumerConfig;
        return this;
    }

    public ReadLogger2File filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public void start() throws Exception{

        CliParams cliParams=new CliParams(args);

        if(JStringUtils.isNullOrEmpty(filePath)){
            filePath=Optional.of(cliParams.getString(FILE)).orElse("log-file.log");
        }

        String topicPartition=cliParams.getString(TOPIC_PARTITION);

        String topic=TopicPartitionParser.topic(topicPartition);

        List<Integer> partitions=TopicPartitionParser.partition(topicPartition);

        int[] pts=new int[partitions.size()];
        for(int i=0;i<partitions.size();i++){
            pts[i]=partitions.get(i);
        }
        ConsumerConnector.ConsumerExecutor<String, Object> consumer=
                new ConsumerConnector(kafkaConsumerConfig)
                .manualPartitionAssign()
                        .addPartition(topic,pts).connect();

        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filePath,true))){
            ConsumerRecords<String, Object> consumerRecords = consumer.poll(3*1000);
            for (ConsumerRecord<String, Object> consumerRecord : consumerRecords) {
                String record =String.valueOf(consumerRecord.value());
                bufferedWriter.write(record);
            }
            bufferedWriter.flush();
        }

    }



}
