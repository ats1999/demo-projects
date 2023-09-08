FROM ubuntu:20.04

WORKDIR /usr/src/app
RUN apt-get update
RUN apt-get install -y wget
RUN apt-get install curl -y
RUN wget https://nodejs.org/dist/v18.17.1/node-v18.17.1-linux-x64.tar.gz
RUN tar -xvf node-v18.17.1-linux-x64.tar.gz
ENV PATH=$PATH:/usr/src/app/node-v18.17.1-linux-x64/bin
COPY package.json ./
RUN npm i
COPY . .

EXPOSE 5000
CMD [ "node", "index.js" ]