<template>
  <div id="requestSuccess" v-if="isRequestSuccess">
    <div v-for="file in highligetedData" v-bind:key="file">
      <el-card class="box-card" shadow="hover">
        <template #header>
          <div class="card-header">
            <span id="fileName">{{ file.fileName }}</span>
            <el-button class="button" type="text">Preview</el-button>
            <el-button class="button" type="text">Download</el-button>
            <el-button class="button" type="text">Delete</el-button>
          </div>
        </template>
        <div id="fileAuthor">Author: {{ file.author }}</div>
        <div id="fileTags">Tags: {{ file.tags }}</div>
        <div id="fileContent" v-html="file.highlightContent"></div>
      </el-card>
      <el-divider></el-divider>
    </div>
  </div>
  <div id="requestFail" v-else>
    <span
      >Sorry, something goes wrong, please wait a few seconds, or press F5 to
      refresh website
    </span>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "SearchResult",
  data() {
    return {
      searchTerm: this.searchTerm,
      isRequestSuccess: this.isRequestSuccess,
      highligetedData: this.highligetData,
    };
  },
  methods: {
    getSearchResult(searchTerm) {
      console.log(searchTerm);
      axios
        .get("/api/search", {
          params: {
            searchTerm: searchTerm,
          },
        })
        .then((response) => {
          if (response.status === 200) {
            this.isRequestSuccess = true;
            this.highligetedData = response.data;
          }
        });
    },
  },
  mounted() {
    this.searchTerm = this.$route.query.searchTerm;
    this.getSearchResult(this.searchTerm);
  },
};
</script>

<style>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 480px;
}
</style>