import { createApp } from 'vue';
import App from './App.vue';
import installElementPlus from './plugins/element';
import router from './routers/router.js'

const app = createApp(App);
installElementPlus(app);
app.use(router);
app.mount('#app');