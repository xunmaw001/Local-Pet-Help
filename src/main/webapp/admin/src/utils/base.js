const base = {
    get() {
        return {
            url : "http://localhost:8080/chongwulingyangpingtai/",
            name: "chongwulingyangpingtai",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/chongwulingyangpingtai/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "同城宠物帮"
        } 
    }
}
export default base
