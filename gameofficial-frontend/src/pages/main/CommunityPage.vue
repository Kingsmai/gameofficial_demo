<script setup>
import CommunityPostItem from "@/components/main/CommunityPostItem.vue";
import {useAuthStore} from "@/stores/authStore";
import {reactive, ref} from "vue";
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import {getPostTime} from "@/utils";

const authStore = useAuthStore()

const formRef = ref();
const form = reactive({
    postContent: ''
})

const postList = ref([])

const getPostList = () => {
// 获取帖子
    get("/api/community/get", (message) => {
        postList.value = message;
    })
}

getPostList()

const createNewPost = () => {
    if (form.postContent.trim() !== '') {
        post('/api/community/newPost', {
            content: form.postContent
        }, (message) => {
            ElMessage.success(message);
            form.postContent = '';
            getPostList();
        })
    } else {
        ElMessage.error("不能发布空帖子");
    }
}

const handlePostDelete = () => {
    // 重新获取帖子列表即可
    getPostList()
}
</script>

<template>
    <div class="community-page" style="margin-top: 16px">

        <el-card style="margin-bottom: 16px">
            <div style="margin-bottom: 16px" v-if="authStore.isLoggedIn()">
                欢迎回来！{{ authStore.getUsername() }}，今天有什么想分享的吗？
            </div>
            <div style="margin-bottom: 16px" v-if="!authStore.isLoggedIn()">欢迎游客，请登录后再发帖</div>
            <el-form ref="formRef"
                     :model="form">
                <el-row :gutter="16">
                    <el-col :span="20">
                        <el-form-item prop="postContent">
                            <el-input type="textarea" v-model="form.postContent"
                                      :autosize="{minRows: 2, maxRows: 4}"
                                      placeholder="说点什么把~"
                                      :disabled="!authStore.isLoggedIn()"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-button @click="createNewPost"
                                   :disabled="!authStore.isLoggedIn()"
                                   type="primary" style="height: calc(100% - 18px); width: 100%">发布帖子
                        </el-button>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>


        <community-post-item v-for="post in postList"
                             :post-id="post.id"
                             :username="post.username"
                             :post-time="getPostTime(post.postTime)"
                             :content="post.content"
                             :tags="post.tags"
                             :can-delete="authStore.isAdmin() || authStore.getUserId() === post.userId"
                             @delete="handlePostDelete"/>
    </div>
</template>

<style scoped>

</style>