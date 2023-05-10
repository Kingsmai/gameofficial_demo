<script>
</script>

<template>
    <div class="game-intro-page">
        <el-card class="game-intro">
            <h1>游戏介绍</h1>
            <div class="game-intro-content">
                <el-image src="https://i.imgur.com/xvamG0B.png"
                          class="game-intro-screenshot"/>
                <p>
                    《匠人英雄》是一款引人入胜的沙盒类 RPG
                    游戏，带你进入一个神秘而壮丽的奇幻世界。在这个充满魔法与冒险的大陆上，你将成为一个英勇的勇者，探索未知的领域，
                    与邪恶势力战斗，解开古老的秘密。
                </p>
                <p>
                    在游戏中，你将自由冒险于广袤的大陆，探索古老遗迹、神秘森林和危险的山脉。你将发现强大的魔法和神奇的物品，
                    学习古老的技能和咒语，与各种生物交互，从友善的精灵到凶猛的巨龙，甚至是隐藏在黑暗深渊中的邪恶生物。
                </p>
                <p>
                    在这个沙盒世界中，你可以建造属于自己的城市和堡垒，招募勇士和魔法师，建立强大的军队和公会，与其他玩家一起征战。
                    挑战副本和任务，寻找稀有的宝藏和装备，提升自己的实力，成为传说中的英雄。
                </p>
                <p>
                    《匠人英雄》不仅提供了令人惊叹的视觉效果和流畅的游戏体验，还有深度的剧情和丰富的角色发展。
                    你的选择和行动将决定整个大陆的命运。在这个充满挑战和机遇的世界中，你将面临艰难的抉择，做出决定，为你所信仰的正义而战。
                </p>
                <p>
                    现在就加入《匠人英雄》，探索无尽的冒险，创造属于你的传奇故事！准备好迎接挑战了吗？让我们一起勇闯未知的魔幻之地！
                </p>
            </div>
        </el-card>
        <el-card class="game-download">
            <h1>游戏下载</h1>
            <el-row>
                <el-col :span="8">
                    <img src="@/assets/character_drawings/knight_s0.png" alt="knight_drawing"/>
                </el-col>
                <el-col :span="16">
                    <div class="download-paragraph" style="text-align: center">
                        <div>在远古的大陆上，勇者们的命运等待着你！</div>
                        <div>释放你内心的英雄，踏入神秘的沙盒世界！</div>
                        <div>探索无边无际的奇遇，释放古老的魔法，驯服神兽，打造属于你的传世装备！</div>
                        <div>在这个沙盒类 RPG 游戏中，成为传说中最强大的勇者！</div>
                        <div>即刻下载，开启属于你的史诗冒险之旅！</div>
                        <div>揭开神秘的谜团，征服惊险的副本，挑战其他玩家的强大势力！</div>
                        <div>命运掌握在你手中，勇者啊，迎接你的传奇命运吧！</div>
                    </div>
                    <div style="text-align: center; margin: 24px 0">
                        <el-button type="primary" style="width: 70%">游戏下载</el-button>
                    </div>
                    <el-row>
                        <el-col :span="12">
                            <div class="download-information-header">文件信息</div>
                            <div>客户端版本：1.0.0.0</div>
                            <div>支持系统：WIN7 / WIN8 / WIN10 / WIN11</div>
                            <div>更新日期：2023-04-20</div>
                            <div>文件大小： 28989M</div>
                        </el-col>
                        <el-col :span="12">
                            <div class="download-information-header">下载耗时</div>
                            <div>100M光纤： 40分钟</div>
                            <div>50M光纤： 80分钟</div>
                            <div>12M宽带： 322分钟</div>
                            <div>8M宽带： 483分钟</div>
                            <div>4M宽带： 966分钟</div>
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
            <div class="download-information">
            </div>
        </el-card>
    </div>
</template>

<style scoped>
.el-card {
    margin-top: 16px;
}

.game-intro-screenshot {
    float: left;
    width: 30%;
    margin: 16px;
    padding: 8px;
    box-shadow: 2px 2px 8px #ccc;
}

.download-information-header {
    width: max-content;
    font-size: 1.75rem;
    padding-right: 72px;
    padding-bottom: 4px;
    margin-bottom: 16px;
    border-bottom: 2px solid rgb(182, 23, 23);
}
</style>