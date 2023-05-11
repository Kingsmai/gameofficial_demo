<script>
export default {
    props: {
        header: {
            type: String,
            required: true
        },
        postTime: {
            type: String,
            required: true
        },
        tags: {
            type: Array,
            required: false
        },
        image: {
            type: String,
            required: false
        },
        content: {
            type: String,
            required: true
        }
    },
    methods: {
        getParagraphs(content) {
            return content.split('\n');
        }
    }
}
</script>

<template>
    <div class="blog-item">
        <el-card>
            <h1>{{ header }}</h1>
            <div>发布时间：{{ postTime }}</div>
            <div class="tag" style="margin: 8px 0">
                <el-tag v-for="tagContent in tags">{{ tagContent }}</el-tag>
            </div>
            <el-image :src="image" v-if="image != null"></el-image>
            <div class="blog-content" style="margin-top: 16px">
                <p v-for="paragraph in getParagraphs(content)">
                    {{ paragraph }}
                </p>
            </div>
        </el-card>
    </div>
</template>

<style scoped>
.blog-item {
    margin-bottom: 16px;
}

.el-tag {
    margin-right: 8px;
}

p {
    margin: 8px 0;
    text-indent: 2ch;
}
</style>