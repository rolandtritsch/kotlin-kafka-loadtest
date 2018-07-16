package loadtest.consumer

import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.kstream.KStream

import loadtest.util.ApplicationConfig

fun main(args: Array<String>) {
  val props = ApplicationConfig("consumer.properties").getProperties()

  val builder = StreamsBuilder()
  val nodeStreams: KStream<String, String> = builder.stream("test")
  nodeStreams.foreach { _, value -> println(value!!) }

  val streams = KafkaStreams(builder.build(), props)
  streams.cleanUp()
  streams.start()

  streams.localThreadsMetadata().forEach { data -> println(data) }
  Runtime.getRuntime().addShutdownHook(Thread(streams::close))
}