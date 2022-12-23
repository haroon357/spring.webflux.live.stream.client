this is a simple demo project that get Customer data over http live stream as  MediaType.TEXT_EVENT_STREAM_VALUE , 
it get this data using non-blocking webclient and process the Flux to insert Customer data into Customer_copy table in 
postgreSQL DB

you can test his app using following curl 
curl http://localhost:8081/demo-live-stream-client



**How To Run**
* run postgres docker image loacally form https://hub.docker.com/_/postgres
* connect to postgreSQL and create tables as per ...resources/sql/schema.sql
* ensure the database port and user/password are correct in .../resources/application.yaml
* Get Server side application from https://github.com/haroon357/spring.webflux.live.stream.server and run it locally
  as per https://github.com/haroon357/spring.webflux.live.stream.client/blob/main/README.md
* run your application and it will start at  port 8081
* you check this client side application is working by running curl curl http://localhost:8081/demo-live-stream-client

