package com.mycom.pa.spm.api.common;

import java.time.Duration;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.springframework.beans.factory.annotation.Autowired;

public class KafkaMessageConsumer {
	
	private KafkaConsumer<String, String> kafkaConsumer;
	
	@Autowired
	public KafkaMessageConsumer(KafkaConsumer<String, String> kafkaConsumer) {
		this.kafkaConsumer = kafkaConsumer;
	}
	
	public String consumeMessage(List<String> topics){
	      kafkaConsumer.subscribe(topics);
	      String message = null;
	      ConsumerRecords<String, String> records = this.consumeAllMessages();
	      for (ConsumerRecord<String, String> record : records){
	         if (record.value() != null)
	            message = record.value();
	      }
	      return message;
   }
	
	public ConsumerRecords<String, String> consumeAllMessages(){
		try{
			return kafkaConsumer.poll(Duration.ofSeconds(10));
		}
		catch (WakeupException ex){
	         throw new RuntimeException(ex);
		}
		
	}
}
