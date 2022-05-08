package br.com.aws_kafka_producer.service;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerService {

    public static void sendMessage(String key, String value) throws InterruptedException, ExecutionException {
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(PropertiesConfig.properties());
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(System.getenv("KAFKA_TOPIC"), key,
                value);

        Callback callback = (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("Mensagem enviada com sucesso para: " + data.topic() + " | partition " + data.partition()
                    + "| offset " + data.offset() + "| tempo " + data.timestamp());
        };

        producer.send(record, callback).get();
        producer.close();
    }
}
