import pika
import logging
import sys

queue_name = 'messages'


def main():
    try:
        print('Trying to connect to RabbitMQ...')
        credentials = pika.PlainCredentials('guest', 'guest')
        parameters = pika.ConnectionParameters(host='host.docker.internal', port=5672, virtual_host='/',
                                               credentials=credentials, socket_timeout=2)
        connection = pika.BlockingConnection(parameters)
        print('Connection successful...')
        channel = connection.channel()

        def callback(ch, method, properties, body):
            logging.info("Received: " + str(body))
            print("Received: " + str(body))

        channel.queue_declare(queue=queue_name)
        channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)
        print('Waiting for messages: ')
        channel.start_consuming()

    except:
        e = sys.exc_info()
        print(e)


if __name__ == '__main__':
    main()
