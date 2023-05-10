<script setup>
import router from "@/router";

const quitConfirm = () => {
    // TODO：让用户确认是否取消编辑
    // 跳转
    router.push("/admin");
}

const sendNewPost = () => {
    // 当发布成功，跳转到 博客管理界面
    router.push("/admin");
}
</script>

<template>
    <div class="post-editor">
        <h1 style="text-align: center; margin-bottom: 16px">博客编辑器</h1>
        <el-form>
            <el-form-item>
                <span>页面标题</span>
                <el-input/>
            </el-form-item>
            <el-form-item>
                <span>内容</span>
                <el-input type="textarea" rows="20"/>
            </el-form-item>
        </el-form>
        <div style="text-align: right">
            <el-button type="danger" plain @click="quitConfirm">取消</el-button>
            <el-button type="primary" @click="sendNewPost">发布博客</el-button>
        </div>
    </div>
</template>

<style scoped>

</style>