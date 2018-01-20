package test.me.libme.module.kafka

import me.libme.module.kafka.KafkaProducerConfig
import me.libme.module.kafka.fn.logger.{KafkaLoggerFactory, KafkaLoggerTopicMatch, LoggerType}

/**
  * Created by J on 2018/1/10.
  */
object TestKafkaLoggerProducer {


  def main(args: Array[String]): Unit = {

    val conf=KafkaProducerConfig.`def`();

    conf.put("bootstrap.servers","one.3cgg.rec:9092")
    conf.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")

    val kafkaConfig=KafkaProducerConfig.build(conf)

    val topicMatch=new KafkaLoggerTopicMatch
    topicMatch.addTopicMapping(LoggerType.DEBUG,"__debug__")
    topicMatch.addTopicMapping(LoggerType.INFO,"__info__")
    topicMatch.addTopicMapping(LoggerType.ERROR,"__error__")
    topicMatch.addTopicMapping(LoggerType.WARNING,"__warning__")

    val kafkaLoggerFactory=KafkaLoggerFactory
      .builder()
      .kafkaLoggerTopicMatch(topicMatch)
      .kafkaProducerConfig(kafkaConfig)
      .getOrCreate()


    val logger=kafkaLoggerFactory.factory(classOf[TestLogger].getName)

    val testLogger=new TestLogger(logger)


    while(true){
      testLogger.logData()

      Thread.sleep(3*1000)
    }




  }



}
