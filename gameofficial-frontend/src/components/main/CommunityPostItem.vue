<script>
import {DeleteFilled, EditPen} from "@element-plus/icons-vue";
import {ElMessage} from "element-plus";
import {post} from "@/net";

export default {
    computed: {
        EditPen() {
            return EditPen
        },
        DeleteFilled() {
            return DeleteFilled
        }
    },
    props: {
        postId: {
            type: Number,
            required: true
        },
        username: {
            type: String,
            required: true
        },
        postTime: {
            type: String,
            required: true
        },
        content: {
            type: String,
            required: true
        },
        canDelete: {
            type: Boolean,
            required: true,
        },
        tags: {
            type: Array,
        }
    },
    methods: {
        getUsernameColor(username) {
            // 将用户名转换为 UTF-8 编码的字节数组
            const utf8Bytes = new TextEncoder().encode(username);

            // 将字节数组转换为十六进制字符串
            const hexString = Array.from(utf8Bytes)
                .map(byte => byte.toString(16).padStart(2, '0'))
                .join('');

            // 提取前六位作为颜色值
            return '#' + hexString.slice(0, 6);
        },
        deletePost() {
            post("/api/community/delete", {
                postId: this.postId
            }, (message) => {
                ElMessage.success(message);
                // 当请求成功，删除本组件
                this.$emit('delete');
            })
        }
    }
}

</script>

<template>
    <div class="blog-item" style="margin-top: 16px">
        <el-card>
            <div class="post-info">
                <span class="user-avatar" :style="{ backgroundColor: getUsernameColor(username) }">
                    {{ username.charAt(0).toUpperCase() }}
                </span>
                <div style="margin-left: 16px">
                    <div style="font-weight: bold">{{ username }}</div>
                    <div style="font-size: 0.9rem; font-style: italic; color: grey">{{ postTime }}</div>
                </div>
            </div>
            <div class="post-content" style="margin-top: 16px;">
                {{ content }}
            </div>
            <div class="post-tags" style="margin-top: 16px">
                <el-tag v-for="tag in tags" style="margin-right: 8px">{{ tag }}</el-tag>
            </div>
            <div style="margin-top: 10px">
                <el-button v-if="canDelete" @click="deletePost"
                           :icon="DeleteFilled" type="danger" link>删除
                </el-button>
            </div>
        </el-card>
    </div>
</template>

<style scoped>
.post-info {
    display: flex;
    align-items: center;
    margin-bottom: 8px;
}

.user-avatar {
    width: 40px;
    height: 40px;
    text-align: center;
    line-height: 40px;
    border-radius: 20px;
}
</style>