<script setup>
import {User} from "@element-plus/icons-vue";
import router from "@/router";

</script>

<template>
    <div class="admin-view">
        <nav style="display: flex; justify-content: space-between; padding: 32px 0 16px">
            <div>
                <span @click="router.push('/')">首页</span>
                |
                <span @click="router.push('/admin')">博客管理</span>
            </div>
            <div>
                <el-button :icon="User" type="danger">退出登录</el-button>
            </div>
        </nav>
        <router-view/>
    </div>
</template>

<style scoped>
.admin-view {
    max-width: 1100px;
    margin: 0 auto;
}
</style>