var amqp = require('amqplib/callback_api');

var rabbitSettings = {
    protocol: "amqp",
    hostname: "localhost",
    port: 5672,
    username: "guest",
    password: "guest",
    vhost: "/",
    authMechanism: ['PLAIN', 'AMQPLAIN', 'EXTERNAL']
};

amqp.connect(rabbitSettings, function(error0, connection) {
    if (error0) {
        throw error0;
    }
    connection.createChannel(function(error1, channel) {
        if (error1) {
            throw error1;
        }

        var queue = 'messages';

        channel.assertQueue(queue, {
            durable: false
        });

        console.log("Waiting for messages");

        channel.consume(queue, function(msg) {
            console.log("Received: %s", msg.content.toString());
        }, {
            noAck: true
        });
    });
});