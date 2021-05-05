<template>
  <el-upload
    class="upload"
    ref="upload"
    accept=".txt, .pdf, .docs, .pptx, .md"
    action="/api/file/upload/"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :data="fileData"
    :file-list="fileList"
    :auto-upload="false"
  >
    <template #trigger>
      <el-button size="small" type="primary">Select</el-button>
    </template>
    <el-button
      style="margin-left: 10px"
      size="small"
      type="success"
      @click="submitUpload"
      >Upload</el-button
    >
    <template #tip>
      <div class="el-upload__tip">Support docs/txt/ppt/pdf/md/...</div>
    </template>
  </el-upload>
  <el-input v-model="fileData.tags" placeholder="default tag"></el-input>
  <el-input v-model="fileData.author" placeholder="default author"></el-input>
</template>

<script>
export default {
  data() {
    return {
      fileList: [],
      fileData: {
        tags: "default tags",
        author: "default author",
      },
    };
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    handlePreview(file) {
      console.log(file);
    },
  },
  name: "Upload",
};
</script>