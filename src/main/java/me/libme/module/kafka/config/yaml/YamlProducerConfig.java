package me.libme.module.kafka.config.yaml;

import me.libme.kernel._c.yaml.YamlMapConfig;
import me.libme.module.kafka.KafkaProducerConfig;
import me.libme.module.kafka.config.KafkaProducerConfigFinder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by J on 2018/9/29.
 */
public class YamlProducerConfig implements KafkaProducerConfigFinder {

    private YamlMapConfig yamlMapConfig;

    public YamlProducerConfig(InputStream inputStream) {
        this.yamlMapConfig = new YamlMapConfig(inputStream);
    }



    @Override
    public KafkaProducerConfig find() {
        Map<String,Object> config= KafkaProducerConfig.def();

        Map map= (Map) yamlMapConfig.getObject("cpp.zk.kafka.properties",new HashMap<>());
        config.putAll(map);

        Map producerMap= (Map) yamlMapConfig.getObject("cpp.zk.kafka.producer",new HashMap<>());
        config.putAll(producerMap);
        return KafkaProducerConfig.build(config);
    }



























}
