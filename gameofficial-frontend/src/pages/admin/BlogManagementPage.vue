<script setup>

import {Plus} from "@element-plus/icons-vue";
import router from "@/router";

const blogData = [
    {
        blogTitle: "官网上线啦！",
        postDate: "2023年5月10日 12点29分"
    },
    {
        blogTitle: "游戏持续开发中",
        postDate: "2023年5月10日 16点27分",
    }
]
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
        <el-table :data="blogData" style="width: 100%">
            <el-table-column prop="blogTitle" label="博客标题">
                <template #default="scope">
                    <span style="font-weight: bold">{{ scope.row.blogTitle }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="postDate" label="发布时间" width="256"/>
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