<script setup>
import {RouterView} from 'vue-router'
import {useAuthStore} from "@/stores/authStore";
import {get} from "@/net";
import router from "@/router";

const authStore = useAuthStore()

if (!authStore.isLoggedIn()) {
    get("/api/user/me",
        (message) => {
            authStore.setUserInfo(message);
            router.push('/')
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
