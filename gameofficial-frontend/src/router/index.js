import {createRouter, createWebHistory} from 'vue-router'

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
                    name: 'login',
                    component: () => import("@/pages/welcome/LoginPage.vue")
                },
                {
                    path: 'register',
                    name: 'register',
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

export default router
