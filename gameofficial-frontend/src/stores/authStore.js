import {reactive} from 'vue'
import {defineStore} from 'pinia'

export const useAuthStore = defineStore('auth', () => {
    const auth = reactive({
        user: null
    });

    const setUserInfo = (userInfo) => {
        auth.user = userInfo;
        localStorage.setItem("userInfo", JSON.stringify(userInfo));
    }

    const clearUserInfo = () => {
        auth.user = null;
        localStorage.removeItem("userInfo");
    }

    const getUsername = () => {
        if (isLoggedIn()) {
            return auth.user.username;
        } else {
            return "游客"
        }
    };

    const getUserId = () => {
        if (isLoggedIn()) {
            return auth.user.id;
        } else {
            return 0;
        }
    };

    const isLoggedIn = () => {
        return auth.user != null;
    }

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
        isAdmin,
        getUsername,
        getUserId
    }
})
