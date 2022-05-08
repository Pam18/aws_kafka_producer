package br.com.aws_kafka_producer;

import java.util.concurrent.ExecutionException;
import br.com.aws_kafka_producer.service.KafkaProducerService;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        System.out.println( "Enviando mensagem..." );
        KafkaProducerService.sendMessage("Frango frito", "10");
    }
}
