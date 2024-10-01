// app.js
if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('service-worker.js')
        .then((registration) => {
            console.log('Service Worker 등록됨:', registration);
        })
        .catch((error) => {
            console.error('Service Worker 등록 실패:', error);
        });
}

document.getElementById('subscribe').addEventListener('click', async () => {
    const registration = await navigator.serviceWorker.ready;
    const subscription = await registration.pushManager.subscribe({
        userVisibleOnly: true,
        applicationServerKey: urlB64ToUint8Array('<여기에 VAPID 공개 키를 입력하세요>')
    });

    console.log('푸시 알림 구독:', subscription);
});

// Base64 URL 변환 함수
function urlB64ToUint8Array(base64String) {
    const padding = '='.repeat((4 - base64String.length % 4) % 4);
    const base64 = (base64String + padding).replace(/-/g, '+').replace(/_/g, '/');
    const rawData = window.atob(base64);
    return Uint8Array.from([...rawData].map(char => char.charCodeAt(0)));
}
