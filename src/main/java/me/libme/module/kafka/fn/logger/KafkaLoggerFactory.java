package me.libme.module.kafka.fn.logger;

import me.libme.module.kafka.KafkaProducerConfig;
import me.libme.module.kafka.ProducerConnector;
import me.libme.module.kafka.SimpleProducer;

/**
 * Created by J on 2018/1/9.
 */
public class KafkaLoggerFactory {

    private static KafkaLoggerFactory __DEFAULT__;

    private KafkaLoggerBuilder kafkaLoggerBuilder;

    public static class KafkaLoggerBuilder{

        private KafkaProducerConfig kafkaProducerConfig;

        private ProducerConnector.ProducerExecutor<String,Object> producerExecutor;

        private KafkaLoggerTopicMatch kafkaLoggerTopicMatch;


        public KafkaLoggerBuilder kafkaLoggerTopicMatch(KafkaLoggerTopicMatch kafkaLoggerTopicMatch) {
            this.kafkaLoggerTopicMatch = kafkaLoggerTopicMatch;
            return this;
        }

        public KafkaLoggerBuilder kafkaProducerConfig(KafkaProducerConfig kafkaProducerConfig) {
            this.kafkaProducerConfig = kafkaProducerConfig;
            return this;
        }

        public KafkaLoggerFactory getOrCreate(){
            if(KafkaLoggerFactory.__DEFAULT__==null){
                ProducerConnector producerConnecter=new ProducerConnector(kafkaProducerConfig);
                producerExecutor=  producerConnecter.connect();

                KafkaLoggerFactory kafkaLoggerFactory=new KafkaLoggerFactory();
                kafkaLoggerFactory.kafkaLoggerBuilder=this;
                KafkaLoggerFactory.__DEFAULT__=kafkaLoggerFactory;
            }
            return KafkaLoggerFactory.__DEFAULT__;
        }


    }

    public static KafkaLoggerBuilder builder(){
        return new KafkaLoggerBuilder();
    }

    public KafkaLogger factory(Class<?> clazz){

        KafkaLogger kafkaLogger=new KafkaLogger();
        kafkaLogger.clazz=clazz;
        kafkaLogger.className=clazz.getName();
        kafkaLogger.producer=new SimpleProducer(kafkaLoggerBuilder.producerExecutor);

        return kafkaLogger;
    }

    public KafkaLogger factory(String clazzName){

        KafkaLogger kafkaLogger=new KafkaLogger();
        kafkaLogger.className=clazzName;
        kafkaLogger.producer=new SimpleProducer(kafkaLoggerBuilder.producerExecutor);
        return kafkaLogger;
    }




}
