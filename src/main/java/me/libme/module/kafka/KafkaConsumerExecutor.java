package me.libme.module.kafka;

import me.libme.module.kafka.config.yaml.YamlConsumerConfig;

/**
 * Created by J on 2018/9/29.
 */
public class KafkaConsumerExecutor {

    public static ConsumerConnector.ConsumerExecutor<String, Object> executor(String topic,int[] pts){

        KafkaConsumerConfig kafkaConsumerConfig=new YamlConsumerConfig(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("application-cpp-kafka.yml")).find();
        return new ConsumerConnector(kafkaConsumerConfig)
                        .manualPartitionAssign()
                        .addPartition(topic,pts).connect();

    }


}
