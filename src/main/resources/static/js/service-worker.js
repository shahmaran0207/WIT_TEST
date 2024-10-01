self.addEventListener('push', function(event) {
    const options = {
        body: event.data ? event.data.text() : '기본 메시지',
        icon: 'icon.png', // 아이콘 경로
        badge: 'badge.png' // 배지 경로
    };

    event.waitUntil(
        self.registration.showNotification('알림 제목', options)
    );
});
