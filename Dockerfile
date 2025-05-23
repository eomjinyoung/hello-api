# Java 17 경량 이미지 사용
FROM eclipse-temurin:17-jdk-alpine

# 작업 디렉토리 생성
WORKDIR /app

# JAR 파일 복사
COPY ./app/build/libs/hello-api.jar app.jar

# 실행 명령 (환경변수 사용)
ENTRYPOINT ["sh", "-c", "java -jar app.jar --spring.profiles.active=prod"]
