package me.libme.module.kafka.fn.logger;

import me.libme.kernel._c.util.CliParams;
import me.libme.module.kafka.KafkaConsumerConfig;

/**
 * Created by J on 2018/1/9.
 */
public class ReadLogger2File {

    private static final String topic_Partition="--topicPartition";


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

    public void start(){

        CliParams cliParams=new CliParams(args);

        String  cliParams.getString(topicPartition);










    }



}
