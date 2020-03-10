
function connect() {
    var CHATID = document.getElementById('chatId').innerHTML;;
	var socket = new SockJS('/chat-messaging');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log("connected: " + frame);
		stompClient.subscribe('/chat/messages/' + CHATID, function(response) {
			var data = JSON.parse(response.body);
			draw("left", data.message);
		});
	});
}

function draw(side, text) {
	console.log("drawing...");
    var $message;
    $message = $($('.message_template').clone().html());
    $message.addClass(side).find('.text').html(text);
    $('.messages').append($message);
    return setTimeout(function () {
        return $message.addClass('appeared');
    }, 0);

}
function disconnect(){
	stompClient.disconnect();
}
function sendMessage(){
    var CHATID = document.getElementById('chatId').innerHTML;;
	stompClient.send("/app/message/" + CHATID, {}, JSON.stringify({'message': $("#message_input_value").val()}));
}