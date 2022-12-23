this is a simple demo project that get Customer data over http live stream as  MediaType.TEXT_EVENT_STREAM_VALUE , 
it get this data using non-blocking webclient and process the Flux to insert Customer data into Customer_copy table in 
postgreSQL DB

you can test his app using following curl 
curl http://localhost:8081/demo-live-stream-client


 Note: you will need to have a PostgreSQL database running locally and create customer_copy table as per schema present in /resources folder
This service consume other service that is present at https://github.com/haroon357/spring.webflux.live.stream.server so you will need to run
this spring.webflux.live.stream.server micro-service locally
* check application.yaml so the database connection details point to your local db 