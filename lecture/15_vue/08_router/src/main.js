import { createApp } from 'vue'
import App from './App.vue'
import router from './router/01_router.js';

// npm install vue-router@next 필요
// createApp(App).use(router).mount('#app')
const app = createApp(App);
app.use(router);
app.mount('#app');
