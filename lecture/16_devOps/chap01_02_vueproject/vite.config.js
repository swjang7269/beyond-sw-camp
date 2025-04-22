import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
  // 프론트를 docker로 이미지를 떠 더이상 vue에서는 cors처리를 하기 힘드니 cors처리를 백엔드에서 해보자
  // server: {
  //   proxy: {
  //     '/api': {
  //       // target: 'http://localhost:7777',

  //       // 백엔드가 컨테이너화 된 후 docker 외부에서 접근할 때는 7777 포트가 아니라 8055 포트로 접근해야한다.(8055로 접근하라고 포트포워딩을 하였기 때문)
  //       // -p 8055:7777
  //       target: 'http://localhost:8055',  // 컨테이너로 감싸는 순간부터 localhost는 컨테이너가 띄어진 순간부터 컨테이너의 공간을 칭하게 된다.
  //       changeOrigin: true, // 요청 헤더의 Origin을 백엔드의 주소로 바꾸는 설정
  //       rewrite: (path) => path.replace(/^\/api/, '')
  //     }
  //   }
  // }
})
