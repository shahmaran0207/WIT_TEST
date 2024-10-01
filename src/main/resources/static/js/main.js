// 서비스 워커 등록
if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('/service-worker.js')
        .then(function(registration) {
            console.log('Service Worker registered with scope:', registration.scope);
        })
        .catch(function(error) {
            console.error('Service Worker registration failed:', error);
        });
}

// 알림 권한 요청
document.getElementById('notifyBtn').addEventListener('click', function() {
    Notification.requestPermission().then(function(permission) {
        if (permission === 'granted') {
            console.log('Notification permission granted.');
            // 푸시 알림 표시
            showNotification('푸시 알림이 활성화되었습니다!', '알림 권한이 허용되었습니다.');
        } else {
            console.log('Notification permission denied.');
        }
    });
});

// 푸시 알림 표시 함수
function showNotification(title, body) {
    const options = {
        body: body,
        icon: 'icon.png', // 아이콘 경로
        badge: 'badge.png' // 배지 경로
    };

    new Notification(title, options);
}
