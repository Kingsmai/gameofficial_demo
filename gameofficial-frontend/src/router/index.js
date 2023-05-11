import {createRouter, createWebHistory} from 'vue-router'
import {useAuthStore} from "@/stores/authStore";
import {ElMessage} from "element-plus";

const router = createRouter({
    scrollBehavior(to, from, savedPosition) {
        if (savedPosition) {
            return savedPosition;
        } else if (to.hash) {
            return {
                el: to.hash,
                behavior: 'smooth'
            };
        } else {
            return {
                top: 0,
                behavior: 'smooth'
            }
        }
    },
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
                },
                {
                    path: 'search',
                    name: 'search',
                    component: () => import("@/pages/main/SearchPage.vue")
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
    if (authStore.isLoggedIn() && to.name.startsWith("welcome")) {
        // 用户已经登录
        ElMessage.error("405：您已登录，自动为您跳转")
        next('/')
    } else if (!authStore.isAdmin() && to.fullPath.startsWith('/admin')) {
        // 普通用户访问管理员界面
        ElMessage.error(`401：您${authStore.isAdmin() ? "是" : "不是"}管理员，无权限访问此界面`)
        next('/')
    } else if (to.matched.length === 0) {
        // 访问不存在的页
        ElMessage.error("404：查无此页面")
        next('/')
    } else {
        next()
    }
})

export default router
