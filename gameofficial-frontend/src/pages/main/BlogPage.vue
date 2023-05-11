<script setup>
import BlogItem from "@/components/main/BlogItem.vue";
import {ref} from "vue";
import {get} from "@/net";
import {getPostTime} from "@/utils";

const blogList = ref([])

const getBlogList = () => {
    get("api/blog/get", (message) => {
        blogList.value = message;
    })
}

getBlogList();
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
                <blog-item v-for="blog in blogList"
                           :header="blog.title"
                           :post-time="getPostTime(blog.postTime)"
                           :tags="blog.tags"
                           :content="blog.content"
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