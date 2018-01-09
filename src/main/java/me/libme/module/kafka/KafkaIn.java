package me.libme.module.kafka;

public interface KafkaIn {

	/**
	 * according to the offset in the kafka partition
	 * @return
	 */
	long offset();

}