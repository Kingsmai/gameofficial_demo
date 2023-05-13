<script setup>

import {Lock, User} from "@element-plus/icons-vue";
import router from "@/router";
import {reactive} from "vue";
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import {useAuthStore} from "@/stores/authStore";

const authStore = useAuthStore();

const form = reactive({
    username: '',
    password: '',
    remember: false
})

const login = () => {
    post("/api/auth/login", {
        username: form.username,
        password: form.password,
        remember: form.remember,
    }, (message) => {
        ElMessage.success(message);
        get("/api/user/me", (message) => {
            authStore.setUserInfo(message);
        })
        router.push("/");
    })
}
</script>

<template>
    <div class="login-page">
        <div class="page-title" style="text-align: center">
            <div style="font-size: 1.5rem; font-weight: bold">用户登录</div>
            <div style=" color: grey; margin-top: 10px">欢迎访问匠人英雄官方网站</div>
        </div>
        <el-form style="margin-top: 20px">
            <el-form-item>
                <el-input type="email"
                          :prefix-icon="User" placeholder="请输入用户名 / 邮箱"
                          v-model="form.username"/>
            </el-form-item>
            <el-form-item>
                <el-input type="password"
                          :prefix-icon="Lock" placeholder="请输入密码"
                          v-model="form.password"/>
            </el-form-item>
            <el-form-item>
                <el-checkbox v-model="form.remember" label="记住我"/>
            </el-form-item>
        </el-form>
        <el-button type="primary"
                   @click="login"
                   style="width: 100%">
            登录
        </el-button>
        <el-divider>没有账号？</el-divider>
        <el-button type="warning" plain
                   @click="router.push('/welcome/register')"
                   style="width: 100%">
            注册
        </el-button>
    </div>
</template>

<style scoped>
</style>