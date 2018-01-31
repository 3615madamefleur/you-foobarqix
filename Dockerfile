FROM java:9
WORKDIR /
ADD target/foobarqix-1.0-spring-boot.jar foobarqix-1.0-spring-boot.jar
EXPOSE 8080
CMD java -jar foobarqix-1.0-spring-boot.jar