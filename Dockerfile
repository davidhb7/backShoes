FROM openjdk:14
VOLUME /tmp
EXPOSE 9090
COPY Shoesweb-1.0.0.jar /Shoesweb-1.0.0.jar
ENTRYPOINT ["java","-jar","Shoesweb-1.0.0.jar"]