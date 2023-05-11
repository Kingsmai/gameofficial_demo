<script setup>
import {Lock, Message, User} from "@element-plus/icons-vue";
import router from "@/router";
import {reactive, ref} from "vue";
import {post} from "@/net";
import {ElMessage} from "element-plus";

const formRef = ref()
const form = reactive({
    username: '',
    password: '',
    password_repeat: '',
    email: ''
})

// ========================
// 数据校验
// ========================
// 用户名合法性验证
const validateUsername = (rule, value, callback) => {
    if (!/^[\u4e00-\u9fa5a-zA-Z0-9]+$/.test(value)) {
        // 不符合：包含中文英文的用户名不能有特殊字符 正则表达式
        callback(new Error('用户名不能包含特殊字符，只能中文 / 英文'))
    } else {
        // 通过
        callback()
    }
}

// 密码合法性校验
const validatePassword = (rule, value, callback) => {
    if (/[\u4e00-\u9fa5]+/.test(value)) {
        callback(new Error('密码中不能包含中文'))
    } else if (!/\d/.test(value)) {
        callback(new Error('密码至少包含一个数字'))
    } else if (!/[A-Z]/.test(value)) {
        callback(new Error('密码至少包含一个大写字母'))
    } else if (!/[!@#$%^&*]/.test(value)) {
        callback(new Error('密码至少包含一个标点符号'))
    } else {
        // 通过
        callback()
    }
}

const validatePasswordRepeat = (rule, value, callback) => {
    if (value !== form.password) {
        callback(new Error('两次输入的密码不一致'))
    } else {
        callback()
    }
}

const rules = {
    username: [
        {required: true, message: '请输入用户名', trigger: 'blur'},
        {validator: validateUsername, trigger: ['blur', 'change']},
        {min: 2, max: 16, message: '用户名必须在 2 - 16 字符以内', trigger: ['blur', 'change']}
    ],
    password: [
        {required: true, message: '请输入密码', trigger: 'blur'},
        {min: 8, max: 16, message: '密码必须在 8 - 16 字符以内', trigger: ['blur', 'change']},
        {validator: validatePassword, trigger: ['blur', 'change']}
    ],
    password_repeat: [
        {required: true, message: '请再次输入密码', trigger: 'blur'},
        {validator: validatePasswordRepeat, trigger: ['blur', 'change']}
    ],
    email: [
        {required: true, message: '请输入电子邮件', trigger: 'blur'},
        {type: 'email', message: '请输入正确的电子邮件', trigger: ['blur', 'change']}
    ]
}
// ========================
// 数据校验结束
// ========================

// ========================
// 注册
// ========================
const register = () => {
    formRef.value.validate((isValid) => {
        if (isValid) {
            // 表单合法，访问后端请求
            post("/api/auth/register", {
                username: form.username,
                password: form.password,
                email: form.email
            }, (message) => {
                ElMessage.success(message);
                router.push("/welcome");
            })
        } else {
            ElMessage.warning("请完整填写表单注册内容。")
        }
    })
}
</script>

<template>
    <div class="login-page">
        <div class="page-title" style="text-align: center">
            <div style="font-size: 1.5rem; font-weight: bold">用户登录</div>
            <div style=" color: grey; margin-top: 10px">欢迎访问匠人英雄官方网站</div>
        </div>
        <el-form :model="form"
                 :rules="rules"
                 ref="formRef"
                 style="margin-top: 20px">
            <el-form-item prop="username">
                <el-input v-model="form.username" :maxlength="16"
                          :prefix-icon="User" placeholder="请输入用户名"/>
            </el-form-item>
            <el-form-item prop="email">
                <el-input v-model="form.email" type="email"
                          :prefix-icon="Message" placeholder="请输入邮箱"/>
            </el-form-item>
            <el-form-item prop="password">
                <el-input v-model="form.password" type="password" :maxlength="16"
                          :prefix-icon="Lock" placeholder="请输入密码"
                          show-password/>
            </el-form-item>
            <el-form-item prop="password_repeat">
                <el-input v-model="form.password_repeat" type="password" :maxlength="16"
                          :prefix-icon="Lock" placeholder="请重复输入密码"
                          show-password/>
            </el-form-item>
        </el-form>
        <el-button type="success" style="width: 100%" @click="register">注册</el-button>
        <span>已有账号？<el-link type="primary" @click="router.push('/welcome')">登录</el-link></span>
    </div>
</template>

<style scoped>

</style>