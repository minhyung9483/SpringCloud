/*현재시간 비동기로 가져오기*/
function curTime(){
	$.ajax({
		type: "GET",
		url: "/curTime",
		success: (data)=>{
			var resultHtml = "";
			resultHtml += "<p>  현재 시간 : ";
			resultHtml += data;
			resultHtml += ". </p>";
			
			$('#curtime').html(resultHtml);
		}
	});
}

/* 로그인 페이지로 이동 */
function goLogin(){
	location.href="/goLogin";
}

/* 회원가입 페이지로 이동 */
function goSign(){
	location.href="/goSign";	
}
