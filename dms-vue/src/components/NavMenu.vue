<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu"
    mode="horizontal"
    @select="handleSelect"
  >
    <el-menu-item index="1"
      ><router-link :to="{ path: '/home' }">Home</router-link></el-menu-item
    >
    <el-menu-item index="2"
      ><router-link :to="{ path: '/upload' }">Upload</router-link></el-menu-item
    >
    <el-menu-item index="3"
      ><router-link :to="{ path: '/listfile' }"
        >All Files</router-link
      ></el-menu-item
    >
  </el-menu>
</template>

<script>
export default {
  name: "NavMenu",
  data() {
    return {
      activeIndex: "1",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
    },
  },
};
</script>