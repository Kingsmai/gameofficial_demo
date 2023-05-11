import {createRouter, createWebHistory} from 'vue-router'
import {useAuthStore} from "@/stores/authStore";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            name: "index",
            component: () => import("@/views/MainView.vue"),
            children: [
                {
                    path: '',
                    name: 'blog',
                    component: () => import("@/pages/main/BlogPage.vue")
                },
                {
                    path: 'community',
                    name: 'community',
                    component: () => import("@/pages/main/CommunityPage.vue")
                },
                {
                    path: 'game-intro',
                    name: 'game introduction',
                    component: () => import("@/pages/main/GameIntroPage.vue")
                }
            ]
        },
        {
            path: "/welcome",
            name: 'welcome',
            component: () => import("@/views/WelcomeView.vue"),
            children: [
                {
                    path: '',
                    name: 'welcome-login',
                    component: () => import("@/pages/welcome/LoginPage.vue")
                },
                {
                    path: 'register',
                    name: 'welcome-register',
                    component: () => import("@/pages/welcome/RegisterPage.vue")
                }
            ]
        },
        {
            path: "/admin",
            name: "admin",
            component: () => import("@/views/AdminView.vue"),
            children: [
                {
                    path: '',
                    name: 'blog editor',
                    component: () => import("@/pages/admin/BlogManagementPage.vue")
                },
                {
                    path: 'post-editor',
                    name: 'post editor',
                    component: () => import("@/components/admin/PostEditor.vue")
                }
            ]
        }
    ]
})

router.beforeEach((to, from, next) => {
    const authStore = useAuthStore();
    if (authStore.isLoggedIn() && to.name.startsWith("welcome-")) {
        // 用户已经登录
        next('/')
    } else if (!authStore.isAdmin() && to.fullPath.startsWith('/admin')) {
        // 普通用户访问管理员界面
        next('/')
    } else if (to.matched.length === 0) {
        // 访问不存在的页面
        next('/')
    } else {
        next()
    }
})

export default router
