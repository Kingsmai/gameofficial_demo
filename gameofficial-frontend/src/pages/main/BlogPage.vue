<script setup>

import BlogItem from "@/components/main/BlogItem.vue";
</script>

<template>
    <div class="blog-page" style="margin-top: 16px">
        <el-carousel trigger="click">
            <el-carousel-item>
                <img src="@/assets/carousel/workshop_skin_0.png" alt="workshop_skin_0">
            </el-carousel-item>
            <el-carousel-item>
                <img src="@/assets/carousel/workshop_skin_1.png" alt="workshop_skin_1">
            </el-carousel-item>
            <el-carousel-item>
                <img src="@/assets/carousel/workshop_skin_2.png" alt="workshop_skin_2">
            </el-carousel-item>
        </el-carousel>

        <el-row :gutter="10" style="margin-top: 16px">
            <el-col :span="18">
                <blog-item header="游戏持续开发中"
                           post-time="2023年5月10日 12点29分"
                           :tags="['开发日志', '程序员日常干架']"
                           image="https://i.imgur.com/X5A1mAA.jpeg"
                           content="这是一段废话"
                />

                <blog-item header="游戏持续开发中"
                           post-time="2023年5月10日 12点29分"
                           :tags="['发牢骚']"
                           content="这是一段废话"
                />
            </el-col>
            <el-col :span="6">
                <el-card>
                    <h1>博客一览表</h1>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<style scoped>
img {
    width: 100%;
    object-fit: contain;
}
</style>