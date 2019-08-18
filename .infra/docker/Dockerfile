FROM java:8
COPY build/libs/ /var/www/merchantgalaxy/
WORKDIR /var/www/merchantgalaxy/
EXPOSE 8080
RUN chmod 777 MerchantGalaxy-1.0-SNAPSHOT.jar
CMD ["java", "-jar", "MerchantGalaxy-1.0-SNAPSHOT.jar"]
