package me.libme.module.kafka;

import java.io.Serializable;

public interface KafkaHashKey extends Serializable{

	/**
	 * the record is partitioned according to the hash value;
	 * hash value% partition number
	 * @return
	 */
	public String hashKey();
	
}