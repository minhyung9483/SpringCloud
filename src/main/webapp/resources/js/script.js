/*초기 화면으로*/
function goHome(){
	location.href="/";
}

/* 게시물 확인 */
function selectBoard(board_id){
	location.href="/boards/"+board_id;
}

/* 게시물 등록 */
function goBoardWrite(){
	location.href="/boards/write";
}

/* 게시물 확인*/
function goBoardDetail(board_id){
	location.href="/boards/detail?board_id="+board_id;
}

/* 게시물 비밀번호 입력창으로 이동 */
function goCheckPwd(board_id){
	location.href="/boards/checkpwd?board_id="+board_id;
}

/* 게시물 비밀번호 확인*/
function checkBoardPwd(){
	var board_id=$("#board_id").val();
	var board_pwd=$("#board_pwd").val();
	var board_pwd_input=$("#board_pwd_input").val();
	
	if(board_pwd==board_pwd_input){
		location.href="/boards/detail?board_id="+board_id;
	}else{
		alert("비밀번호가 일치하지 않습니다.");
		location.href="/boards";		
	}
}

/* 게시물 등록 및 수정시 제목 , 컨텐트 , 비밀번호에 빈칸이 있는지 확인 */
function boardValidation() {
   var title = $("#title").val();
   var content = $("#content").val();
   var check = $("#secret").prop("checked");
   var board_pwd = $("#board_pwd").val();

   if(title == '' || title == null) {
      alert("제목을 입력해주세요!!!!");
      $("#title").focus();
      return;
   } 
   if(content == '' || content == null) {
      alert("내용을 입력해주세요!!!!");
      $("#content").focus();
      return;
   } 
   if(check==true){
	   if(board_pwd == '' || board_pwd == null){
		   alert("비밀번호를 입력해주세요!!!!");
		   $("#board_pwd").focus();
		   return;
	   }
   }else{
	   $("#board_pwd").val(""); //초기화
   }
   
   document.getElementById("frm").submit();
   
}

/* 게시판 수정/등록시 비밀번호칸 노출 / 숨김 */
function checkSecret(){
	var check = $("#secret").prop("checked");
	if(check==true){
		$("#pwd_row").show();
	}else{
		$("#pwd_row").hide();		
	}
}

/* 게시물 삭제 */
function deleteBoard(board_id){
	var result = confirm("정말 삭제하시겠습니까?(바로 삭제됩니다.)");
	if(result){
	    alert("삭제되었습니다.");
	    location.href="/boards/delete?board_id="+board_id;
	}
}

/* 게시물 등록 */
function insertBoard(){
	var result = confirm("등록하시겠습니까?");
	if(result){
		boardValidation();
	}
}

/* 게시물 등록 */
function updateBoard(){
	var result = confirm("수정하시겠습니까?");
	if(result){
		boardValidation();
	}
}


