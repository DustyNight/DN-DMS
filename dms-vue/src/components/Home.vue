<template>
  <img src="../assets/logo_728397.png" />
  <div id="SearchBar">
    <el-input
      placeholder="What do you want?"
      prefix-icon="el-icon-search"
      v-model="input"
    >
    </el-input>
    <el-button @click="submit" type="primary">Search</el-button>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      input: '',
    };
  },
  methods: {
    submit() {
      this.$router.push({
        name: 'SearchResult',
        query: {
          searchTerm: this.input,
        }
      })

    }
  },
  mounted() {},
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
