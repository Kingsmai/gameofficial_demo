<script setup>
import CommunityPostItem from "@/components/main/CommunityPostItem.vue";
import {useAuthStore} from "@/stores/authStore";
import {ref} from "vue";
import {get} from "@/net";

const authStore = useAuthStore()

const postList = ref([])

// 获取帖子
get("/api/post/get", (message) => {
    postList.value = message;
})

const getPostTime = (postTime) => {
    let time = new Date(postTime);
    let year = time.getFullYear();
    let month = String(time.getMonth() + 1).padStart(2, '0')
    let date = String(time.getDate()).padStart(2, '0')
    let hours = String(time.getHours()).padStart(2, '0')
    let minutes = String(time.getMinutes()).padStart(2, '0')
    // return postTime;
    return `${year}年${month}月${date} ${hours}时${minutes}分`
}
</script>

<template>
    <div class="community-page" style="margin-top: 16px">

        <el-card style="margin-bottom: 16px">
            <div style="margin-bottom: 16px" v-if="authStore.isLoggedIn()">
                欢迎回来！{{ authStore.getUsername() }}，今天有什么想分享的吗？
            </div>
            <div style="margin-bottom: 16px" v-if="!authStore.isLoggedIn()">欢迎游客，请登录后再发帖</div>
            <el-row :gutter="16">
                <el-col :span="20">
                    <el-input type="textarea"
                              :autosize="{minRows: 2, maxRows: 4}"
                              placeholder="说点什么把~"
                              :disabled="!authStore.isLoggedIn()"/>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" style="height: 100%; width: 100%">发布帖子</el-button>
                </el-col>
            </el-row>
        </el-card>


        <community-post-item v-for="post in postList"
                             :post-id="post.id"
                             :username="post.username"
                             :post-time="getPostTime(post.postTime)"
                             :content="post.content"
                             :can-delete="authStore.isAdmin() || authStore.getUserId() === post.userId"/>
    </div>
</template>

<style scoped>

</style>