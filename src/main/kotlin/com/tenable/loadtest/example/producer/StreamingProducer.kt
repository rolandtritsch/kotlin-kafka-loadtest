package com.tenable.loadtest.example.producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

import com.tenable.loadtest.example.util.ApplicationConfig

fun main(args: Array<String>) {

  val props = ApplicationConfig("application.properties")

  val producer = KafkaProducer<String, String>(props, StringSerializer(), StringSerializer())
  producer.send(ProducerRecord(props.getProperty("topic"), "exampleKey", "exampleValue"))
  producer.close()

}