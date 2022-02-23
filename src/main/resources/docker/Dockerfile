FROM openjdk:11

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

RUN mkdir -p /opt
ADD maven/opt/foodanddrinks-2.6.3.jar /opt/foodanddrinks-2.6.3.jar


EXPOSE 8080

ENTRYPOINT java -jar /opt/foodanddrinks-2.6.3.jar -Djava.net.preferIPv4Stack=true