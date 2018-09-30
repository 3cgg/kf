package me.libme.module.kafka.config.yaml;

import me.libme.kernel._c.yaml.YamlMapConfig;
import me.libme.module.kafka.KafkaConsumerConfig;
import me.libme.module.kafka.KafkaProducerConfig;
import me.libme.module.kafka.config.KafkaConsumerConfigFinder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by J on 2018/9/29.
 */
public class YamlConsumerConfig implements KafkaConsumerConfigFinder {

    private YamlMapConfig yamlMapConfig;

    public YamlConsumerConfig(InputStream inputStream) {
        this.yamlMapConfig = new YamlMapConfig(inputStream);
    }



    @Override
    public KafkaConsumerConfig find() {
        Map<String,Object> config= KafkaProducerConfig.def();

        Map map= (Map) yamlMapConfig.getObject("cpp.zk.kafka.properties",new HashMap<>());
        config.putAll(map);

        Map consumerMap= (Map) yamlMapConfig.getObject("cpp.zk.kafka.consumer",new HashMap<>());
        config.putAll(consumerMap);
        return KafkaConsumerConfig.build(config);
    }



























}
