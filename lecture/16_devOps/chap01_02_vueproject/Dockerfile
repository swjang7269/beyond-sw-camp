FROM node:lts-alpine

WORKDIR /app

COPY . .

RUN npm install

# npm run dev --host 0.0.0.0
# --host 0.0.0.0은 네트워크 인터페이스에서 접속을 허용하도록 설정(모든 ip 허용, Docker 컨테이너 외부에서 접속 가능)
# "--": 구분자 역할(npm 명령어와 구분하기 위함)
# 각 요소는 ""(쌍따옴표)로 작성할 것
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]