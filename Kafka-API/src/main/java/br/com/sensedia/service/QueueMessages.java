package br.com.sensedia.service;

import br.com.sensedia.model.KafkaMessage;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class QueueMessages {

    private List<KafkaMessage> queue = new LinkedList<>();

    public synchronized void enqueue(KafkaMessage kafkaMessage){
        this.queue.add(kafkaMessage);
    }

    public synchronized List<KafkaMessage> getQueue(){
        if(!queue.isEmpty()){
            List<KafkaMessage> queueAux = new LinkedList<>(queue);
            this.queue.clear();
            return queueAux;
        }
        return null;
    }

}
