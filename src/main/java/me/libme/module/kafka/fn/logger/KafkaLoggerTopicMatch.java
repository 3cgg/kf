package me.libme.module.kafka.fn.logger;

import java.util.*;

public class KafkaLoggerTopicMatch {

	private final Map<String,List<String>> topics=new HashMap<>();

	private static final List<String> __DEFAULT__=new ArrayList<>();
	static {
		__DEFAULT__.add("logger-default");
	}

	public KafkaLoggerTopicMatch addTopicMapping(LoggerType loggerType,String topic){
		String name=loggerType.name();
		if(topics.containsKey(name)){
			topics.get(name).add(topic);
		}else {
			List<String> topics=new ArrayList<>();
			topics.add(topic);
			KafkaLoggerTopicMatch.this.topics.put(name,topics);
		}
		return this;
	}

	public List<String> matches(LoggerType loggerType){

		return Optional.of(topics.get(loggerType.name())).orElse(__DEFAULT__ );
	}
	
}
