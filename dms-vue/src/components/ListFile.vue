
<template>
  <div id="requestSuccess" v-if="isRequestSuccess">
    <div v-for="file in fileLists" v-bind:key="file">
      <el-card class="box-card" shadow="hover">
        <template #header>
          <div class="card-header">
            <span id="fileName">{{ file.fileName }}</span>
            <el-button class="button" type="text">Delete(In dev)</el-button>
          </div>
        </template>
        <div id="fileAuthor">Author: {{ file.author }}</div>
        <div id="fileTags">Tags: {{ file.tags }}</div>
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
  name: "ListFile",
  data() {
    return {
      isRequestSuccess: this.isRequestSuccess,
      fileLists: this.fileLists,
    };
  },
  methods: {
    getFileList() {
      axios.get("api/file/").then((response) => {
        if (response.status === 200) {
          this.isRequestSuccess = true;
          this.fileLists = response.data;
        }
      });
    },
  },
  mounted() {
    this.getFileList();
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