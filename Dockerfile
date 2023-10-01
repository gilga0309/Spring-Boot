# docker 생성 이미지 openjdk 17 버전
FROM openjdk:17-jdk

# 이미지 지정 port 8080
EXPOSE 8080

# JAR_FILE 변수 정의 -> 기본적으로 jar file이 2개이기 때문에 이름을 특정한다.
ARG JAR_FILE=target/*.jar

# JAR 파일 메인 디렉토리에 복사
COPY ${JAR_FILE} app.jar

# 시스템 진입점 정의
ENTRYPOINT ["java","-jar","/app.jar"]