<script setup>
import {RouterView} from 'vue-router'
import {useAuthStore} from "@/stores/authStore";
import {get} from "@/net";

const authStore = useAuthStore()

let userInfo = JSON.parse(localStorage.getItem("userInfo"));
authStore.setUserInfo(userInfo);

if (!authStore.isLoggedIn()) {
    get("/api/user/me",
        (message) => {
            authStore.setUserInfo(message);
        },
        () => {
            authStore.clearUserInfo();
        }
    )
}
</script>

<template>
    <RouterView/>
</template>

<style scoped>
</style>
