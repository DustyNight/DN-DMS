<template>
  <el-upload
    class="upload"
    action="https://jsonplaceholder.typicode.com/posts/"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    multiple
    :limit="1"
    :on-exceed="handleExceed"
    :file-list="fileList"
  >
    <el-button size="small" type="primary">Upload</el-button>
    <template #tip>
      <div class="el-upload__tip">Support docs/txt/ppt/pdf/md/...</div>
    </template>
  </el-upload>
  
</template>

<script>
export default {
  data() {
    return {
      fileList: [],
    };
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed() {
      this.$message.warning(
          'You can only upload 1 file once.'
      );
    },
  },
  name: "Upload",
};
</script>