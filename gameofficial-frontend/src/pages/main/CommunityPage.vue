<script setup>
import CommunityPostItem from "@/components/main/CommunityPostItem.vue";
import {useAuthStore} from "@/stores/authStore";
import {reactive, ref} from "vue";
import {post} from "@/net";
import {ElMessage} from "element-plus";
import {getPostTime} from "@/utils";

const authStore = useAuthStore()

const formRef = ref();
const form = reactive({
    postContent: ''
})

const pageInfo = reactive({
    pageSize: 10,
    pageNumber: 1,
    totalRecords: 32
})

const postList = ref([])

const getPostList = () => {
// 获取帖子
    post("/api/community/get", {
        pageSize: pageInfo.pageSize,
        pageNumber: pageInfo.pageNumber,
    }, (message, info) => {
        postList.value = message;
        pageInfo.value = info;
    })
}

getPostList()

const createNewPost = () => {
    if (form.postContent.trim() !== '') {
        post('/api/community/post', {
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

const handlePageChange = (val) => {
    pageInfo.pageNumber = val;
    getPostList()
}

const handlePageSizeChange = (val) => {
    pageInfo.pageSize = val;
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

        <div style="margin: 32px 0">
            <el-pagination background
                           :total="pageInfo.totalRecords"
                           v-model:page-size="pageInfo.pageSize"
                           v-model:current-page="pageInfo.pageNumber"
                           :page-sizes="[5, 10, 20, 30, 50]"
                           layout="total, sizes, prev, pager, next"
                           @current-change="handlePageChange"
                           @size-change="handlePageSizeChange"/>
        </div>
    </div>
</template>

<style scoped>

</style>