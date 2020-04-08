<template>

  <div ref="scroll" id="scroll-page" style="overflow: hidden">
    <slot></slot>
    <div
      style="height: 40px;margin-top: 10px;z-index: 1"
      v-loading="loading"
      element-loading-text="拼命加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(245,245,245)"></div>
  </div>

</template>

<script>
  export default {
    props: {
      loading: Boolean,
      noData: Boolean,
      offset: Number
    },
    name: "index",
    mounted() {
      window.addEventListener('scroll', this.handleScroll, false);
    },
    beforeDestroy() {
      window.removeEventListener('scroll', this.handleScroll)
    },
    data() {
      return {
        scrollAction: {
          x: 'undefined',
          y: 'undefined'
        }
      }
    },
    methods: {
      handleScroll(e) {
        var that = this
        if (!that.noData) {
          let curHeight = document.documentElement.scrollTop || document.body.scrollTop
          var scrollPage = document.getElementById('scroll-page');

          if ((curHeight + window.innerHeight >= that.$refs.scroll.offsetHeight + that.offset) && that.isDownDirection()) {
            if (!that.loading) {
              that.$emit('load')
            }
          }
        }
      },
      isDownDirection() {
        if (typeof this.scrollAction.x == 'undefined') {
          this.scrollAction.x = window.pageXOffset;
          this.scrollAction.y = window.pageYOffset;
        }
        var diffX = this.scrollAction.x - window.pageXOffset;
        var diffY = this.scrollAction.y - window.pageYOffset;

        this.scrollAction.x = window.pageXOffset;
        this.scrollAction.y = window.pageYOffset;

        if (diffX < 0) {
          // Scroll right
        } else if (diffX > 0) {
          // Scroll left
        } else if (diffY < 0) {
          // Scroll down
          return true
        } else if (diffY > 0) {
          // Scroll up
        } else {
          // First scroll event
        }
        return false
      }

    },
    created() {
        const hashLocation= sessionStorage.getItem("hashLocation");//缓存中获取当前页面的路由名称
        const newLocation = hashLocation.split("#/")[1];
        // 注意, 这里使用全路径匹配,在hash模式中,因为地址会携带#,所以页面报告中的url需要重新覆盖一下, 将#去除
        this.$matomo.setCustomUrl("http://localhost:8000/"+newLocation);//覆盖页面报告的url，可以自定义页面url，加上本页面路由
        // this.$matomo.trackEvent(shopCode,hashLocation);//事件
        this.$matomo.trackPageView(hashLocation);//页面名称,可以自定义页面名称
    }
  }
</script>

<style scoped>

</style>
