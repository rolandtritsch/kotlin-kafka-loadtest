package loadtest.producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

import loadtest.util.ApplicationConfig

fun main(args: Array<String>) {

  val props = ApplicationConfig("producer.properties").getProperties()

  val producer = KafkaProducer<String, String>(props, StringSerializer(), StringSerializer())
  producer.send(ProducerRecord(props!!.getProperty("topic"), "exampleKey", "exampleValue"))
  producer.close()

}