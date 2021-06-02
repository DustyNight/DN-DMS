<template>
  <el-input v-model="tags" placeholder="default tag"></el-input>
  <el-input v-model="author" placeholder="default author"></el-input>
  <el-button @click="InfoUpdate(fileId)" type="primary">Submit</el-button>
</template>

<script>
import axios from "axios";
export default {
  name: "FileInfoUpdate",
  data() {
    return {
      fileId: this.fileId,
      author: "default author",
      tags: "default tag",
    };
  },
  methods: {
    InfoUpdate(fileId) {
      axios
        .post("api/file/update", {
          fileId: fileId,
          author: this.author,
          tags: this.tags,
        })
        .then(function (response) {
          console.log(response);
        });
    },
  },
  mounted() {
    this.fileId = this.$router.query.fileId;
  },
};
</script>