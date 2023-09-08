FROM ubuntu:20.04

WORKDIR /usr/src/app
COPY package.json ./

# install nodejs 
COPY . .

EXPOSE 5000
CMD [ "node", "index.js" ]