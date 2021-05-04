<template>
  <img src="./assets/logo.png" />
  <p>
    <router-link to="/upload">Upload</router-link>
    <br>
    <router-link to="/hello">Hello</router-link>
  </p>
  <router-view></router-view>
</template>

<script>

export default {
  name: "App",
  components: {
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
