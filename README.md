# Rest_hw1
Step 1: run command "docker-compose up" to start mysql,
Step 2: run command "mvn clean install" to build,
and go to target repository run command "java -jar Running-information-analysis-service-0.0.1-SNAPSHOT.jar"
to start application.
step 3: go to postman to post data on url: "localhost:8080/runningInfo"
step 4: check the GET request result on url :"localhost:8080/runningInfo/0?page=0"
step 5: check the Delete request on url:"localhost:8080/delete/runningId"

ps: 
1. Test data in file "Jsondata"
2. In the Get request, each page contains 2 data, start from page=0.
3. In the DELETE request, need to input the runningId in url position "runningId"