import {reactive} from 'vue'
import {defineStore} from 'pinia'

export const useAuthStore = defineStore('auth', () => {
    const auth = reactive({
        user: null
    });

    const setUserInfo = (userInfo) => {
        auth.user = userInfo;
    }

    const clearUserInfo = () => {
        auth.user = null;
    }

    const isLoggedIn = () => auth.user != null;

    const isAdmin = () => {
        if (isLoggedIn()) {
            return auth.user.roleId === 0;
        } else {
            return false;
        }

    }

    return {
        auth,
        setUserInfo,
        clearUserInfo,
        isLoggedIn,
        isAdmin
    }
})
