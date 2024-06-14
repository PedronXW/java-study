FROM maven:3.9.6-eclipse-temurin-22-alpine

WORKDIR /app

COPY . .

EXPOSE 8080