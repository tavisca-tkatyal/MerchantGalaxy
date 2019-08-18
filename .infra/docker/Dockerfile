FROM java:8
COPY src /var/www/java/
WORKDIR /var/www/java
EXPOSE 8080
RUN chmod 777 MerchantGalaxy-1.0-SNAPSHOT.jar
CMD ["java", "-jar", "MerchantGalaxy-1.0-SNAPSHOT.jar"]
