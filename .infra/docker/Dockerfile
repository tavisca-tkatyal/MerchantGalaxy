#TODO
FROM java:8  
COPY src/ /var/www/java  
WORKDIR /var/www/java  
RUN gradlew build
CMD ["gradlew", "test"]  
