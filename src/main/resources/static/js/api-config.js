// 获取当前项目的上下文路径
const contextPath = window.location.pathname.split('/')[1];
const BASE_PATH = contextPath ? `/${contextPath}` : '';

// 全局配置
const API_CONFIG = {
    baseURL: `${BASE_PATH}/api`,
    headers: {
        'Content-Type': 'application/json'
    },
    errorAnalysis: {
        fetch: `${BASE_PATH}/api/error/analysis`,
    }
};

// 创建axios实例
const apiClient = axios.create(API_CONFIG);

// 通用的请求方法
async function makeRequest(url, data = {}, method = 'POST') {
    showLoading();
    try {
        const response = await apiClient({
            method,
            url,
            data
        });
        return response.data;
    } catch (error) {
        handleError(error);
        throw error;
    } finally {
        hideLoading();
    }
}

// 错误处理
function handleError(error) {
    const message = error.response?.data?.message || '操作失败';
    if (error.response?.status === 401) {
        showError(message);
        setTimeout(() => window.location.href = '/login', 1500);
    } else {
        showError(message);
    }
}

// 显示错误信息
function showError(message) {
    const errorDiv = document.getElementById('errorMessage');
    if (errorDiv) {
        errorDiv.textContent = message;
        errorDiv.style.display = 'block';
        setTimeout(() => errorDiv.style.display = 'none', 3000);
    }
}

// 显示成功信息
function showSuccess(message) {
    const successDiv = document.getElementById('successMessage');
    if (successDiv) {
        successDiv.textContent = message;
        successDiv.style.display = 'block';
        setTimeout(() => successDiv.style.display = 'none', 3000);
    }
}

// 加载效果
function showLoading() {
    // TODO: 实现加载动画
    console.log('Loading...');
}

function hideLoading() {
    // TODO: 隐藏加载动画
    console.log('Loading complete');
}

// 导出工具函数
window.API = {
    makeRequest,
    handleError,
    showError,
    showSuccess,
    showLoading,
    hideLoading,

    // 获取 DeepSeek 错误分析结果
    async fetchErrorAnalysis() {
        try {
            const response = await makeRequest(API_CONFIG.errorAnalysis.fetch, {}, 'GET');
            const analysisPanel = document.getElementById('deepseekAnalysis');
            const analysisResult = document.getElementById('analysisResult');

            if (response.analysis) {
                analysisResult.textContent = response.analysis;
                analysisPanel.style.display = 'block';
            }
        } catch (error) {
            console.error('获取错误分析失败:', error);
        }
    },

    // 扩展错误处理函数
    handleError(error) {
        // 原有的错误处理逻辑
        const message = error.response?.data?.message || '操作失败';
        showError(message);

        // 触发错误分析
        this.fetchErrorAnalysis();
    }
};