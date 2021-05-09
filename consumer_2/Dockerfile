FROM node:14
WORKDIR /consumer_2
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 8181
CMD [ "node", "consumer.js" ]