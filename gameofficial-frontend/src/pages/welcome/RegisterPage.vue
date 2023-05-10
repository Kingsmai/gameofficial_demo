<script setup>

import {Lock, Message, User} from "@element-plus/icons-vue";
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
                <el-input :prefix-icon="User" placeholder="请输入用户名"/>
            </el-form-item>
            <el-form-item>
                <el-input type="email"
                          :prefix-icon="Message" placeholder="请输入邮箱"/>
            </el-form-item>
            <el-form-item>
                <el-input type="password"
                          :prefix-icon="Lock" placeholder="请输入密码"/>
            </el-form-item>
            <el-form-item>
                <el-input type="password"
                          :prefix-icon="Lock" placeholder="请重复输入密码"/>
            </el-form-item>
        </el-form>
        <el-button type="success" style="width: 100%">注册</el-button>
        <span>已有账号？<el-link type="primary" @click="router.push('/welcome')">登录</el-link></span>
    </div>
</template>

<style scoped>

</style>