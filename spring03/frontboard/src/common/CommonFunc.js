export function formatDate(date) {  // 2024-06-28T10:19:24.394601
    var result = date.replace('T', ' '); // T를 공백으로 변경
    var index = result.lastIndexOf(' ') // 초 앞에 있는 : 위치 값, 공백으로 하면 연월일만 두고 다 지워짐

    result = result.substr(0, index); // 초 뒤로 전부다 삭제

    return result;
}