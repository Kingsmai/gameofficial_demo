<script setup>

import {Lock, User} from "@element-plus/icons-vue";
import router from "@/router";
</script>

<template>
    <div class="login-page">
        <div class="page-title" style="text-align: center">
            <div style="font-size: 1.5rem; font-weight: bold">用户登录</div>
            <div style=" color: grey; margin-top: 10px">欢迎访问匠人英雄官方网站</div>
        </div>
        <el-form style="margin-top: 20px">
            <el-form-item>
                <el-input :prefix-icon="User" placeholder="请输入用户名 / 邮箱"/>
            </el-form-item>
            <el-form-item>
                <el-input :prefix-icon="Lock" placeholder="请输入密码"/>
            </el-form-item>
        </el-form>
        <el-button type="primary" style="width: 100%">登录</el-button>
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