package ua.com.lavi

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.LoggerFactory

/**
 * Created by Oleksandr Loushkin on 05.01.2017.
 */
class SimpleProducer {

    private val log = loggerFor(javaClass)

    fun run() {
        val properties = ApplicationConfig().getProperties()
        val producer = KafkaProducer<String, String>(properties, StringSerializer(), StringSerializer())
        producer.send(ProducerRecord(properties.getProperty("topic"), "exampleKey", "exampleValue"))
        producer.close()
        log.info("Message sent successfully")
    }

    fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)
}