<script setup>
</script>

<template>
    <div class="welcome_view">
        <el-card class="welcome_page" style="width: 300px">
            <router-view/>
        </el-card>
    </div>
</template>

<style scoped>
.welcome_view {
    height: 100vh;
    background-image: url("@/assets/background/background_login.png");
    background-repeat: no-repeat;
    background-size: cover;
    background-position: 50% 50%;
}

.welcome_page {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
</style>