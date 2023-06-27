FROM khipu/openjdk17-alpine
MAINTAINER <malteshbk>
EXPOSE 9001
COPY ./target/*.jar UM_Api.jar
ENTRYPOINT [ "java","-jar","UM_Api.jar" ]