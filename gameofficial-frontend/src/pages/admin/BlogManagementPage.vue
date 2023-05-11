<script setup>

import {Plus} from "@element-plus/icons-vue";
import router from "@/router";
import {ref} from "vue";
import {get} from "@/net";
import {getPostTime} from "../../utils";

const blogList = ref([])

const getBlogList = () => {
    get("api/blog/get", (message) => {
        blogList.value = message;
    })
}

getBlogList();
</script>

<template>
    <div class="blog-management">
        <div style="display: flex; justify-content: space-between; margin-bottom: 32px">
            <div>
                <h1>博客管理</h1>
            </div>
            <div>
                <el-button :icon="Plus" type="primary" @click="router.push('/admin/post-editor')">发布新内容</el-button>
            </div>
        </div>
        <el-table :data="blogList" style="width: 100%">
            <el-table-column prop="blogTitle" label="博客标题">
                <template #default="scope">
                    <span style="font-weight: bold">{{ scope.row.title }}</span>
                </template>
            </el-table-column>
            <el-table-column label="发布时间" width="256">
                <template #default="scope">
                    <span>{{ getPostTime(scope.row.postTime)}}</span>
                </template>
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="128">
                <template #default>
                    <el-button link type="primary" size="small" @click="router.push('/admin/post-editor')">
                        编辑
                    </el-button>
                    <el-button link type="danger" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<style scoped>

</style>