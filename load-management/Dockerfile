FROM azul/zulu-openjdk:11
EXPOSE 9595
ADD target/load-management-service.jar load-management-service.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${ENV}", "/load-management-service.jar"]