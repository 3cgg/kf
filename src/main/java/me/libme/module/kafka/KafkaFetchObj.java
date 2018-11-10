package me.libme.module.kafka;

import java.io.Serializable;

/**
 * the abstract high level interface for all records recorded in the kafka
 * @author J
 *
 */
public interface KafkaFetchObj<T> extends Serializable, KafkaHashKey, KafkaOffset {

	/**
	 * the record time , generally the record is create at the time.
	 * @return
	 */
	public long recordTime();
	
	/**
	 * the unique id
	 * @return
	 */
	public String id();


	/**
	 * the record value
	 * @return
	 */
	T val();
	
}
