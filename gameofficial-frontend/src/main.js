import './assets/main.css'
import 'element-plus/theme-chalk/dark/css-vars.css'

import {createApp} from 'vue'
import {createPinia} from 'pinia'

import App from './App.vue'
import router from './router'

import 'element-plus/dist/index.css'
import axios from "axios";

const app = createApp(App)

// axios.defaults.baseURL = 'http://192.168.1.100:8080'
axios.defaults.baseURL = 'http://localhost:8080'

app.use(createPinia())
app.use(router)

app.mount('#app')
