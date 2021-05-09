import pika
import logging

queue_name = 'messages'


def main():
    credentials = pika.PlainCredentials('guest', 'guest')
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
    channel = connection.channel()

    channel.queue_declare(queue=queue_name)

    def callback(ch, method, properties, body):
        logging.info("Received: " + str(body))
        print("Received: " + str(body))

    channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

    print('Waiting for messages: ')
    channel.start_consuming()

if __name__ == '__main__':
    main()
