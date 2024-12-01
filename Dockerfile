FROM openjdk:24-oraclelinux8
COPY target/Security-config.jar Security-config.jar
ENTRYPOINT ["java", "-jar", "Security-config.jar"]
