package com.mycom.pa.spm.api.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;

public class KafkaMessageProducer {
	
	private String kafkaTopic;
	private String kafkaMessage;
	private KafkaProducer<String, String> kafkaProducer;
	
	@Autowired
	public KafkaMessageProducer(KafkaProducer<String, String> kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	public String getKafkaTopic() {
		return kafkaTopic;
	}
	public KafkaMessageProducer setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
		return this;
	}
	public String getKafkaMessage() {
		return kafkaMessage;
	}
	public KafkaMessageProducer setKafkaMessage(String kafkaMessage) {
		this.kafkaMessage = kafkaMessage;
		return this;
	}
	
	public void postDataToKafkaTopic(String topic, String message){
	      kafkaProducer.send(new ProducerRecord<String, String>(topic, message));
	      kafkaProducer.close();
	}
}
