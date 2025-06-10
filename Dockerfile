FROM maven:3.8.8-eclipse-temurin-8

WORKDIR /app

# Copy source and script
COPY . .

RUN ls -la

RUN chmod +x entrypoint.sh

# Use shell script as entrypoint
ENTRYPOINT ["./entrypoint.sh"]

