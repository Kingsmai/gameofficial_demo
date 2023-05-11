<script setup>

import {Odometer, Search, User} from "@element-plus/icons-vue";
import router from "@/router";
import {useAuthStore} from "@/stores/authStore";
import {get} from "@/net";
import {ElMessage} from "element-plus";

const authStore = useAuthStore();

const logout = () => {
    get("/api/auth/logout", (message) => {
        ElMessage.success(message);
        authStore.clearUserInfo();
        router.push("/welcome");
    })
}
</script>

<template>
  <!-- 页面标题 -->
    <div class="main-view" style="overflow: hidden">
        <div class="page-header">
            <div style="font-size: 2rem">匠人英雄：序章 Prologue</div>
            <div>一个比艺画鸽天还会鸽的工作室开发的小游戏</div>
        </div>
        <nav>
            <div style="width: 250px">
                <el-input type="text" :prefix-icon="Search"
                          placeholder="请输入搜索内容"/>
            </div>
            <div class="menu-bar">
                <div @click="router.push('/')">
                    <div>首页</div>
                    <div>Home</div>
                </div>
                <div @click="router.push('/community')">
                    <div>社区互动</div>
                    <div>Community</div>
                </div>
                <div @click="router.push('/game-intro')">
                    <div>游戏介绍</div>
                    <div>Intro</div>
                </div>
            </div>
            <div style="width: 250px; text-align: right;">
                <el-button :icon="Odometer" @click="router.push('/admin')" v-if="authStore.isAdmin()">管理员仪表盘
                </el-button>
                <el-button :icon="User" @click="router.push('/welcome')" v-if="!authStore.isLoggedIn()">
                    登录
                </el-button>
                <el-button :icon="User" @click="logout" v-if="authStore.isLoggedIn()">
                    退出
                </el-button>
            </div>
        </nav>
        <router-view/>
    </div>
</template>

<style scoped>
.main-view {
    max-width: 1100px;
    margin: 0 auto;
}

.page-header {
    width: fit-content;
    text-align: center;
    margin: 32px auto;
    padding: 8px 48px;
    border-left: 2px solid black;
    border-right: 2px solid black;
}

nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 8px 0;
    border-top: 2px solid grey;
    border-bottom: 2px solid grey;
}

nav a {
    font-size: 1.25rem;
}

nav .menu-bar {
    flex-grow: 5;
    margin: 0 auto;
    text-align: center;
}

nav .menu-bar > div {
    width: 128px;
    display: inline-block;
    cursor: pointer;
    padding: 0 16px;
}

nav .menu-bar > div:hover {
    background-image: linear-gradient(to bottom, #fff, #ddd);
}
</style>