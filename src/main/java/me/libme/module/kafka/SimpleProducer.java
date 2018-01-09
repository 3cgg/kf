package me.libme.module.kafka;


import java.io.Serializable;

@SuppressWarnings("serial")
public class SimpleProducer implements Serializable {

	private ProducerConnector.ProducerExecutor<String, Object> executor;
	
	public SimpleProducer(ProducerConnector.ProducerExecutor<String, Object> executor) {
		this.executor = executor;
	}

	public void send(Object object,String topic){
		send(object, topic, null);
	}

	public void send(Object object,String topic,Integer partition){
		Object val=object;
		String key=null;
		if(object instanceof KafkaFetchObj){
			key=((KafkaFetchObj) object).hashKey();
		}
		if(partition==null){
			executor.send(topic,key,val);
		}
		else{
			executor.send(topic, partition, key, val);
		}
	}
	

	
}
