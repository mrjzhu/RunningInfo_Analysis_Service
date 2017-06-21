# Running-information-analysis-service

In this service , we can upload RunningInfo, delete RunningInfo by runningId,
sort the runningInfo By HealthLevel.

## Requirement 
1. JDK 8
2. Docker
3. Maven
4. Spring-boot

## Installation

### 1. Download project file
```
git clone https://github.com/mrjzhu/Rest_hw1.git
cd Rest_hw1/Running-information-analysis-service
```
### 2. Configure Mysql image in Docker-container
```
docker-compose up
```

### 3. Login Mysql Database to Create your database
```
mysql -u root -p
```

## Run

### Step 1 start mysql
```
docker-compose up
```
### Step 2 build
```
mvn clean install
```
### Step 3 start application
```
cd target
java -jar Running-information-analysis-service-0.0.1-SNAPSHOT.jar
```

## Post data for test
### go to postman to post data on url: "localhost:8080/runningInfo"
### check the GET request result on url :"localhost:8080/runningInfo"
### check the Delete request on url:"localhost:8080/runningId/{runningId}"


## Data Sample
```
[
 {
 "runningId": "7c08973d-bed4-4cbd-9c28-9282a02a6032",
 "latitude": "38.9093216",
 "longitude": "-77.0036435",
 "runningDistance": "39492",
 "totalRunningTime": "2139.25",
 "heartRate": 0,
 "timestamp": "2017-04-01T18:50:35Z",
 "userInfo": {
 "username": "ross0",
 "address": "504 CS Street, Mountain View, CA 88888"
 }
 },
 {
 "runningId": "07e8db69-99f2-4fe2-b65a-52fbbdf8c32c",
 "latitude": "39.927434",
 "longitude": "-76.635816",
 "runningDistance": "1235",
 "totalRunningTime": "3011.23",
 "heartRate": 0,
 "timestamp": "2017-04-01T18:50:35Z",
 "userInfo": {
 "username": "ross1",
 "address": "504 CS Street, Mountain View, CA 88888"
 }
 }
]
```

## Response Sample (sort by HelathWarningLevel)
```
{
 "runningId": "7c08973d-bed4-4cbd-9c28-9282a02a6032",
 "totalRunningTime": 2000,
 “heartRate”: 75,
 “userId”: 1,
 "userName": "Ross",
 "userAddress": "504 CS Street, Mountain View, CA 88888",
 "healthWarningLevel": HIGH
 }
```
## PS
```
1. Test data in file "Jsondata"
2. In the Get request, each page contains 2 data(default page = 0)
3. In the DELETE request, need to input the runningId in bracket{runningId}
```

