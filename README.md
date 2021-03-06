## Project requirements:
1. Develop 3 web services A, B, C, each in a different technology (python, php, .net core or java).
2. Service A pushes data into RabbitMQ whenever it receives a request, which broadcasts data to B and C in parallel. B and C only display a log when data was fetched from the queue
3. Run 3 instances of Service A
4. Add a loadbalancer based on nginx in front of the 3 instances
5. All services should be containerized via Docker

## Solution
### Service A
Technology: Java Spring Boot Application
It receives a request (e.g. via Postman) from the client, returns the response and puts a message in the queue
Implementation details: see directory src/main/java/com/example/microservice...
    
### Service B
Technology: Python
Waits for a new message in the queue (put by service A) and logs it
Implementation details: see directory consumer_1/..

### Service C
Technology: JavaScript (Node JS)
Waits for a new message in the queue (put by service A) and logs it
Implementation details: see directory consumer_2/..

### Instances of service A
   localhost:2220/...
   localhost:2221/...
   localhost:2222/...
Locally created instances: see directory instances
Docker images: see docker-compose file

### Loadbalancer 
Implementation details: see directory nginx_configuration
Bibliography: https://blog.devgenius.io/load-balancing-a-spring-boot-application-with-nginx-and-docker-e701f74c011d

### Containerization
See Dockerfiles created for each service and docker-compose.yaml file.