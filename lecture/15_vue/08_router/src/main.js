import { createApp } from 'vue'
import App from './App.vue'
// import router1 from './router/01_router.js';
import router2 from './router/02_nextedRouter.js';

// npm install vue-router@next 필요
// createApp(App).use(router).mount('#app')
const app = createApp(App);
// app.use(router1);
app.use(router2);
app.mount('#app');
