package test.me.libme.module.kafka

import me.libme.kernel._c.util.CliParams
import me.libme.module.kafka.KafkaConsumerConfig
import me.libme.module.kafka.fn.logger.ReadLogger2File
;;

/**
 * Created by J on 2018/1/9.
 */
object TestReadLogger2File {

    def main(args: Array[String]): Unit = {

        val conf=KafkaConsumerConfig.`def`();

        conf.put("bootstrap.servers","192.168.1.109:9092")
        conf.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")

        val kafkaConfig=KafkaConsumerConfig.build(conf)

        val cliParams=new CliParams(args)
          .append(ReadLogger2File.TOPIC_PARTITION,"__debug__::0")
          .append(ReadLogger2File.FILE,"D:\\java_\\rec_system\\data\\log.log")


        new ReadLogger2File()
            .cliParams(cliParams)
            .kafkaConsumerConfig(kafkaConfig)
            .start()


    }


}
