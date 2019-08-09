<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 응시 결과</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
	<script type="text/javascript">
		function examSend() {
			var examno = $.cookie('c_examno');
			var dap1 = $.cookie('c_test1');
			var dap2 = $.cookie('c_test2');
			var dap3 = $.cookie('c_test3');
			var dap4 = $.cookie('c_test4');
			//전송한 답안지를 DB에 추가하고 현재 창은 닫기처리
			$.ajax({
				method : "GET"
				, url : "test.mo?crud=examAccount&exam_no="+c_examno
						                            +"$dap1="+dap1+"$dap2="+dap1
						                            +"$dap3="+dap1+"$dap4="+dap1
			    , success : function(data) { 
			    	alert("당신의 취득 점수는 "+data+"입니다.");
			    }
			}); 
			self.close();
		}
	</script>
</head>
<body>
	<!-- ======== 답안지확인 ======== -->
	<!-- 쿠키값 확인을 위해 examResult.jsp 페이지로 이관함. -->
	<div id="pan_confirm" class="easyui-panel" title="소프트웨어 디자인 답지" style="width:600px;height:300px;"
	      	data-options="footer:'#ft_confirm'">
	       <div id="d_confirm" style="margin-bottom:10px">
	       <div id="u_dap"></div>
	      		<script type="text/javascript">
 	      			$("#u_dap").text("1번."+$.cookie('c_test1')+", 2번. "+$.cookie('c_test2')
	      					       +", 3번. "+$.cookie('c_test3')+", 4번. "+$.cookie('c_test4')); 
	      		</script>
	       		수고요. <br>
	       		답안지 제출 버튼을 눌러주세요.
	       </div>
	</div>
	<!-- 푸터 -->
	<div id="ft_confirm" style="padding:5px;" align="right">
		<a href="javascript:examSend()" class="easyui-linkbutton">답안지 제출</a>
	</div>
</body>
</html>