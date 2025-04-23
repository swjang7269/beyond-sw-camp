# FROM node:lts-alpine

# WORKDIR /app

# COPY . .

# RUN npm install

# npm run dev --host 0.0.0.0
# --host 0.0.0.0은 네트워크 인터페이스에서 접속을 허용하도록 설정(모든 ip 허용, Docker 컨테이너 외부에서 접속 가능)
# "--": 구분자 역할(npm 명령어와 구분하기 위함)
# 각 요소는 ""(쌍따옴표)로 작성할 것
# CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]

# --------------------------------------------------------------------------------
# nginx 설정 이후 수정된 Dockerfile (nginx의 root디렉토리에 프로젝트 빌드 결과물이 존재해야 한다.)

FROM node:lts-alpine AS build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# nginx 이미지를 사용하여 프로덕션 스테이지를 구성한다.
FROM nginx:stable-alpine AS production-stage
# 빌드 스테이지에서 생성된 정적 파일들을 Nginx의 기본 웹 서버 디렉토리로 복사한다.
# 이렇게 하면 Nginx가 Vue.js 애플리케이션의 빌드된 파일들을 서빙할 수 있게 된다.
COPY --from=build-stage /app/dist /usr/share/nginx/html

# 로컬 디렉토리의 nginx.conf 파일을 Nginx의 설정 디렉토리로 복사한다.
# 이 설정 파일은 Nginx의 동작을 커스터마이즈하는데 사용된다.
# 예를 들어, 라우팅 규칙, SSL 설정, 로깅 등을 정의할 수 있다.
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
