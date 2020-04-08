
import Vue from 'vue'
import VueMatomo from 'vue-matomo'
import App from './App'

import router from './router'
import store from './store'

import lodash from 'lodash'

import ElementUI from 'element-ui'
import '@/assets/theme/index.css'

import '@/assets/icon/iconfont.css'

import {formatTime} from "./utils/time";


Vue.config.productionTip = false

Vue.use(ElementUI)

Object.defineProperty(Vue.prototype, '$_', { value: lodash })


Vue.directive('title',  function (el, binding) {
  document.title = el.dataset.title
})
// 格式话时间
Vue.filter('format', formatTime)

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})

Vue.use(VueMatomo, {
  host: 'http://192.168.163.148/', // 这里配置你自己的piwik服务器地址和网站ID
  siteId: 1,//siteId值
  // 根据router自动注册
  router: router,
  // // 是否需要在发送追踪信息之前请求许可
  // // 默认false
  requireConsent: false,
  enableLinkTracking: true,
  // // 是否追踪初始页面
  // // 默认true
  trackInitialView: false,
  // // 最终的追踪js文件名
  // // 默认 'piwik'
  trackerFileName: 'matomo',
  debug: false
});
