const getPostTime = (postTime) => {
    let time = new Date(postTime);
    let year = time.getFullYear();
    let month = String(time.getMonth() + 1).padStart(2, '0')
    let date = String(time.getDate()).padStart(2, '0')
    let hours = String(time.getHours()).padStart(2, '0')
    let minutes = String(time.getMinutes()).padStart(2, '0')
    // return postTime;
    return `${year}年${month}月${date}日 ${hours}时${minutes}分`
}

export {
    getPostTime
};