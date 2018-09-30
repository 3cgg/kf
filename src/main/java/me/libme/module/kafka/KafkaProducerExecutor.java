package me.libme.module.kafka;

import me.libme.module.kafka.config.yaml.YamlProducerConfig;

/**
 * Created by J on 2018/9/29.
 */
public class KafkaProducerExecutor {

    private static ProducerConnector.ProducerExecutor<String,Object> executor;


    public static ProducerConnector.ProducerExecutor<String,Object> defaultExecutor(){

        if(executor==null){
            synchronized (KafkaProducerExecutor.class){
                if(executor==null){
                    KafkaProducerConfig kafkaProducerConfig=new YamlProducerConfig(Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream("application-cpp-kafka.yml")).find();
                    KafkaProducerExecutor.executor=executor(kafkaProducerConfig);
                }
            }
        }
        return executor;
    }


    public static ProducerConnector.ProducerExecutor<String,Object> executor(KafkaProducerConfig kafkaProducerConfig){
        return new ProducerConnector(kafkaProducerConfig)
                .connect();
    }


}
