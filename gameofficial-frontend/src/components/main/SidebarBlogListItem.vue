<script setup>
import {ArrowRightBold} from "@element-plus/icons-vue";

const props = defineProps({
    blogTitle: {
        type: String,
        required: true
    }
})
</script>

<template>
    <a :href="`#${blogTitle}`" class="sidebar-blog-list-item">

        <el-icon>
            <arrow-right-bold/>
        </el-icon>
        <el-text truncated size="large" style="margin-left: 16px">
            {{ blogTitle }}
        </el-text>
    </a>
</template>

<style scoped>
.sidebar-blog-list-item {
    display: flex;
    align-items: center;
    cursor: pointer;
    padding: 8px 0;
    max-width: 100%;
}

.sidebar-blog-list-item:first-child {
    border-top: 1px solid black;
}

.sidebar-blog-list-item:last-child {
    border-bottom: 1px solid black;
}

.sidebar-blog-list-item:nth-child(2n) {
    border-top: 1px solid black;
    border-bottom: 1px solid black;
}

.sidebar-blog-list-item:hover {
    padding-left: 16px;
}

a {
    text-decoration: none;
    color: inherit;
}
</style>