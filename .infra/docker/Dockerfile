FROM java:8
COPY build/libs/ /var/www/merchantgalaxy/
WORKDIR /var/www/java
EXPOSE 8080
RUN chmod 777 MerchantGalaxy.jar
CMD ["java", "-jar", "MerchantGalaxy.jar"]
