package me.libme.module.kafka;

public interface KafkaOffset {

	/**
	 * according to the offset in the kafka partition
	 * @return
	 */
	long offset();

}