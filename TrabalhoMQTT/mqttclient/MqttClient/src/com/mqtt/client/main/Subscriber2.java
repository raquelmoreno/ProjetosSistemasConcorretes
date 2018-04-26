package com.mqtt.client.main;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class Subscriber2 implements MqttCallback {

    /** endereço Url do broker */
    private static final String brokerUrl = "tcp://localhost:1883";

    /**  client id. */
    private static final String clientId = "JavaPubSupSampleCefetRJ";

    /** Tópico que você passa na mensagem. */
    private static final String topic = "Umidade";

   
    public static void main(String[] args) {
    	/**
           Se inscreve no broker para receber as mensagens cujo tópico é temperatura
         */
        new Subscriber2().subscribe(topic);
    }

    /**
     * Subscribe.
     *
     * @param topic
     *            the topic
     */
    public void subscribe(String topic) {
     /* Aqui começa o mecanismo para se inscrição, basicamente você aloca um espaço na memória que persiste para realizar a concexão.*/
    	
        MemoryPersistence persistence = new MemoryPersistence();

        try {

            MqttClient sampleClient = new MqttClient(brokerUrl, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            System.out.println("Iniciando a conexão...");

            System.out.println("Subscriber se conectando com o broker: " + brokerUrl);
            sampleClient.connect(connOpts);
            System.out.println("Subscriber conectado com sucesso!");

            sampleClient.setCallback(this);
            sampleClient.subscribe(topic);

            System.out.println("Incrição no tópico " + topic + " realizada com sucesso!");
            System.out.println("Ouvindo o Broker...");

        } catch (MqttException me) {

            System.out.println("Mqtt reason " + me.getReasonCode());
            System.out.println("Mqtt msg " + me.getMessage());
            System.out.println("Mqtt loc " + me.getLocalizedMessage());
            System.out.println("Mqtt causa " + me.getCause());
            System.out.println("Mqtt excep " + me);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.paho.client.mqttv3.MqttCallback#connectionLost(java.lang.
     * Throwable)
     */
    public void connectionLost(Throwable arg0) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.paho.client.mqttv3.MqttCallback#deliveryComplete(org.eclipse.
     * paho.client.mqttv3.IMqttDeliveryToken)
     */
    public void deliveryComplete(IMqttDeliveryToken arg0) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.paho.client.mqttv3.MqttCallback#messageArrived(java.lang.
     * String, org.eclipse.paho.client.mqttv3.MqttMessage)
     */
    public void messageArrived(String topic, MqttMessage message) throws Exception {

        System.out.println("Mqtt topic : " + topic);
        System.out.println("Mqtt msg : " + message.toString());
    }

}
