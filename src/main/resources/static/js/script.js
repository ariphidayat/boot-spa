var stompClient = null;

function connect() {
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, stompSuccess, stompFailure);
}

function stompSuccess() {
    stompClient.subscribe('/topic/public.messages', showMessage);
    stompClient.subscribe('/user/queue/private.messages', showMessage);
}

function stompFailure() {
    console.log("Lost connection! Reconecting in 10 second...");
    window.setTimeout(connect, 10000);
}

function sendMessage() {
    var to = document.getElementById('to').value;
    var content = document.getElementById('content').value;
    var instantMessage;

    if (to == 'public') {
        instantMessage = {'content' : content}
    } else {
        instantMessage = {
            'to' : to,
            'content' : content
        }
    }

    stompClient.send("/app/send.message", {}, JSON.stringify(instantMessage));
}

function showMessage(message) {
    var instantMessage = JSON.parse(message.body);
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.appendChild(document.createTextNode(instantMessage.from + ": " + instantMessage.content));
    response.appendChild(p);
}