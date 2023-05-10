<script setup>
import CommunityPostItem from "@/components/main/CommunityPostItem.vue";
</script>

<template>
    <div class="community-page" style="margin-top: 16px">

        <el-card style="margin-bottom: 16px">
            <div style="margin-bottom: 16px">欢迎回来，今天有什么想分享的吗？</div>
            <el-row gutter="16">
                <el-col :span="20">
                    <el-input type="textarea"
                              :autosize="{minRows: 2, maxRows: 4}"
                              placeholder="说点什么把~"
                              :disabled="true"/>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" style="height: 100%; width: 100%">发布帖子</el-button>
                </el-col>
            </el-row>
        </el-card>


        <community-post-item username="张三"
                             post-time="2023年5月10日 12点35分"
                             content="快点吧，我等到花儿都谢了~"
        />
        <community-post-item username="秃头工作室"
                             post-time="2023年5月10日 12点35分"
                             content="官方辟谣：游戏正在开发中，只是程序员技术很菜，没有跑路哈！"
        />
        <community-post-item username="zhangbo"
                             post-time="2023年5月10日 12点35分"
                             content="楼下的，听说开发商跑路了，垃圾游戏！"
        />
        <community-post-item username="小麦"
                             post-time="2023年5月10日 12点29分"
                             content="游戏啥时候才发布啊？等不及了欸！"
        />
    </div>
</template>

<style scoped>

</style>