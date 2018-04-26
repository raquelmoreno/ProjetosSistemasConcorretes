package com.mqtt.client.main;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;



public class Publisher {

	/*** BROKER ***/
	
	String broker = "tcp://localhost:1883";
    String clientId = "JavaPubSupSampleCefetRJ";
    
    public static void main(String[] args) {

    	/*** PUBLICAÇÕES ***/
    	
    	String topic1 = "Temperatura";
        String content1 = "Temperatura = 45°C";
        int qos1 = 2;
        new Publisher().publish(topic1, content1, qos1);
        
        String topic2 = "Umidade";
        String content2 = "Umidade = 75%";
        int qos2 = 2;
        new Publisher().publish(topic2, content2, qos2);
        
        String topic3 = "NotaTrabalho";
        String content3 = "Nota do Trabalho = 10";
        int qos3 = 2;
        new Publisher().publish(topic3, content3, qos3);
        
        String topic4 = "NotaProva";
        String content4 = "Nota da Prova = 10";
        int qos4 = 2;
        new Publisher().publish(topic4, content4, qos4);
        
        String topic5 = "Temperatura";
        String content5 = "Temperatura = 60°C";
        int qos5 = 2;
        new Publisher().publish(topic5, content5, qos5);
        
        String topic6 = "Umidade";
        String content6 = "Umidade = 70%";
        int qos6 = 2;
        new Publisher().publish(topic6, content6, qos6);
        
        String topic7 = "NotaTrabalho";
        String content7 = "Nota do Trabalho = 9.8";
        int qos7 = 2;
        new Publisher().publish(topic7, content7, qos7);
        
        String topic8 = "NotaProva";
        String content8 = "Nota da Prova = 9.9";
        int qos8 = 2;
        new Publisher().publish(topic8, content8, qos8);
        
        
        
    }
        
        public void publish(String topic, String content, int qos) 
        {
        	MemoryPersistence persistence = new MemoryPersistence();

            try {
                
                MqttClient sampleClient = new MqttClient(this.broker, this.clientId, persistence);
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setCleanSession(true);
                
                System.out.println("Publisher se conectando com o broker: " + broker);
                
                sampleClient.connect(connOpts);
                
                System.out.println("Publisher conectado com sucesso!");
                System.out.println("Publicando a mensagem: " + content);
                
                MqttMessage message = new MqttMessage(content.getBytes());
                message.setQos(qos);
                sampleClient.publish(topic, message);
                System.out.println("Mensagem Publicada");
                
                sampleClient.disconnect();
                System.out.println("Publisher desconectado com sucesso!");
                            
            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("causa " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
                
            }
        	
        }
}