# Dynamic Proxy based on Apache Zuul & Apache Zookeeper

## Prerequsties:

Read official guide
https://cloud.spring.io/spring-cloud-zookeeper/

Download Apache Zookeeper. The latest copy can be downloaded from http://apache.forsale.plus/zookeeper/current/

Unzip tar file into ${app_dir}

cd ${app_dir}
mv zookeeper-${version} zookeeper
cd zookeeper/conf
cp zoo_sample.cfg zoo.cfg

For demo configuration file is good enough

cd ../bin
./zkServer.sh

Run Zookeeper command line and add shared configuration parameters for all web clients

./zkCli.sh -server 127.0.0.1:2181

create /config data
create /config/web_client data
create /config/web_client/test.bool_var true
create /config/web_client/test.int_var 42
create /config/web_client/test.dbl_var 5.9
create /config/web_client/test.str_var qwerty
create /config/web_client/test.list_var Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec

## Build

mvn clean install

## Demo

### No Web Clients

Start dynamic proxy

java -jar DynamicProxy/target/dynamic_proxy.jar

Navigate to http://localhost:8080/zuul_demo/
Without any web_client running it will be 500 error.

### Single Web Client

Start first web-client

java -jar WebClient/target/web_client.jar –server.port=8081

Connect it directly via http://localhost:8081/info

Navigate on http://localhost:8080/zuul_demo/info
Check it redirecting request on web_client on port 8081

### Multiple Web Clients

Start second web-client

java -jar WebClient/target/web_client.jar –server.port=8082

Connect it directly via http://localhost:8082/info

Navigate on http://localhost:8080/zuul_demo/info
Check it redirecting requests sequentially on web_client on ports 8081 & 8082

### Back to Single Web Client

Stop web_client on port 8081

Navigate on http://localhost:8080/zuul_demo/info
Check it redirecting requests only on web_client on ports 8082

