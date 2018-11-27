import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import Axios from 'axios'

Vue.prototype.$http = Axios
Vue.use(ElementUI)

new Vue({
    el: '#app',
    render: h => h(App)
})

global.BASE_URL = "http://localhost:8080/"