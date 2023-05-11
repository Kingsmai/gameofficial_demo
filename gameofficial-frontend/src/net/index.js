import axios from "axios";
import {ElMessage} from "element-plus";

// =============================
// 默认异常操作，弹出信息
// =============================
const defaultError = () => ElMessage.error("发生了一些错误，请联系管理员");
const defaultFailure = (message) => ElMessage.warning(message);

function post(url, data, success, failure = defaultFailure, error = defaultError) {
    axios.post(url, data, {
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        withCredentials: true // 带上 cookie。后期学习 jwt 之后使用别的方式作为用户身份验证
    }).then(({data}) => {
        if (data.success) {
            let pageInfo = {
                pageSize: data.pageSize,
                pageNumber: data.pageNumber,
                totalRecords: data.totalRecords
            }
            success(data.message, pageInfo, data.status);
        } else {
            failure(data.message, data.status);
        }
    }).catch(error)
}

function get(url, success, failure = defaultFailure, error = defaultError) {
    axios.get(url, {
        withCredentials: true // 带上 cookie。后期学习 jwt 之后使用别的方式作为用户身份验证
    }).then(({data}) => {
        if (data.success) {
            let pageInfo = {
                pageSize: data.pageSize,
                pageNumber: data.pageNumber,
                totalRecords: data.totalRecords
            }
            success(data.message, pageInfo, data.status);
        } else {
            failure(data.message, data.status);
        }
    }).catch(error)
}

// ===========================
// 暴露两个函数
// ===========================
export {
    get, post
}