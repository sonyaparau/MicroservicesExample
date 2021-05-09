package com.example.microservice.utils;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Utility class containing the creation
 * of the connection and channels which are
 * needed for producing and consuming messages.
 *
 * @author Sonya
 * @since 06.05.2021
 */
@Slf4j
@UtilityClass
public class MessagingUtils {

    public static final String QUEUE = "messages";

    /**
     * Creates a new Rabbit MQ connection.
     *
     * @return connection of type {@link Connection} or null
     * if an exception occurred
     */
    public static Connection createConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("host.docker.internal");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        try {
            return factory.newConnection();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates a new Channel for the given Rabbit MQ Connection.
     *
     * @param connection the current {@link Connection}
     * @return channel of type {@link Channel} or null
     * if an exception occurred
     */
    public static Channel createChannel(@NonNull Connection connection) {
        try {
            return connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(@NonNull Connection connection) {
        try {
            connection.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
