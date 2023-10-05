#!/usr/bin/env bash

#도커 이미지 및 컨테이너 이름
APP_NAME=<product-docker>
#빌드 파일의 경로
REPOSITORY=/home/ubuntu/

echo "> Check the currently running container"
CONTAINER_ID=$(docker ps -aqf "name=$APP_NAME")

#현재 같은 이름으로 실행중인(사전에 배포된) 컨테이너가 있다면 중지, 컨테이너 삭제
if [ -z "$CONTAINER_ID" ];
then
  echo "> No such container is running."
else
  echo "> Stop and remove container: $CONTAINER_ID"
  docker stop "$CONTAINER_ID"
  docker rm "$CONTAINER_ID"
fi

#같은 이름으로 빌드된 도커 이미지(사전에 빌드된)를 삭제
echo "> Remove previous Docker image"
docker rmi "$APP_NAME"

#도커 이미지를 빌드
echo "> Build Docker image"
docker build -t "$APP_NAME" "$REPOSITORY"

#도커 컨테이너 생성
echo "> Run the Docker container"
docker run -d -p 3000:8080 --name "$APP_NAME" "$APP_NAME"