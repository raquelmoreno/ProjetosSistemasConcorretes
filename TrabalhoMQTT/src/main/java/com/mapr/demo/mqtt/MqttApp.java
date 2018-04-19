package com.mapr.demo.mqtt;

import com.mapr.demo.mqtt.simple.Publisher;
import com.mapr.demo.mqtt.simple.Subscriber;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Basic launcher for Publisher and Subscriber
 */
public class MqttApp {

  public static void main(String[] args) throws MqttException {

    if (args.length < 1) {
      throw new IllegalArgumentException("Deve haver 'publisher' ou 'subscriber' como argumento");
    }
    switch (args[0]) {
      case "publisher":
        Publisher.main(args);
        break;
      case "subscriber":
        Subscriber.main(args);
        break;
      default:
        throw new IllegalArgumentException("Não foi possível realizar " + args[0]);
    }
  }
}

