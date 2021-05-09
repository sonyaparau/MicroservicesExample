package com.example.microservice.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * TODO
 * */
@Slf4j
@UtilityClass
public class MessageSender {

    private static final String MESSAGE_SUCCESSFULLY_SENT = "Message has been successfully sent!";
    private static final String MESSAGE_NOT_SENT = "No message has been sent due to an error!";

    /**
     * Produces the messages that are put in the queue.
     *
     * @param message to send
     * */
    public static void sendMessage(@NonNull final String message) {
        Connection connection = MessagingUtils.createConnection();
        if (connection != null) {
            Channel channel = MessagingUtils.createChannel(connection);
            if (channel != null) {
                try {
                    channel.queueDeclare(MessagingUtils.QUEUE, false, false, false, null);
                    channel.basicPublish("", MessagingUtils.QUEUE, false, null, message.getBytes());
                    log.info(MESSAGE_SUCCESSFULLY_SENT);
                } catch (IOException e) {
                    log.error(MESSAGE_NOT_SENT);
                    log.error(e.getMessage());
                } finally {
                    MessagingUtils.closeConnection(connection);
                }
            }
        }
    }

}
