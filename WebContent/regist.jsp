<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
	BODY {
		FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
	}
	TD {
		FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
	}
	
	.error{
		color:red;
	}
	
</STYLE>
<META content="MSHTML 6.00.6000.16809" name=GENERATOR>

<!-- 引入JQ -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	// 验证登录名
	function checkCode(){
		// 获取用户输入的登录名
		var code = $("#user_code").val();
		// 进行判断，说明没有输入登录名
		if(code.trim() == ""){
			// 给提示
			$("#codeId").addClass("error");
			$("#codeId").html("登录名不能为空");
		}else{
			// 登录名不为空，ajax请求，验证
			var url = "${pageContext.request.contextPath}/user_checkCode.action";
			var param = {"user_code":code};
			$.post(url,param,function(data){
				// 操作data，进行判断
				if(data && data == "no"){
					// 提示
					$("#codeId").addClass("error");
					$("#codeId").html("登录名已经存在");
				}else{
					$("#codeId").removeClass("error");
					$("#codeId").html("可以注册");
				}
			});
		}
	}
	
	// 可以阻止表单的提交
	function checkForm(){
		// 先让校验名称的方法先执行以下
		checkCode();
		// 获取error的数量，如果数量 > 0，说明存在错误，不能提交表单
		if($(".error").size() > 0){
			return false;
		}
	}
	
</script>

</HEAD>

<BODY>

<FORM id=form1 name=form1 action="${ pageContext.request.contextPath }/user_regist.action" onsubmit="return checkForm()" method=post>

<DIV id=UpdatePanel1>
<DIV id=div1 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


<DIV>&nbsp;&nbsp; </DIV>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
  <TBODY>
  <TR>
    <TD style="HEIGHT: 105px"><IMG src="images/login_1.gif" 
  border=0></TD></TR>
  <TR>
    <TD background=images/login_2.jpg height=300>
      <TABLE height=300 cellPadding=0 width=900 border=0>
        <TBODY>
        <TR>
          <TD colSpan=2 height=35></TD></TR>
        <TR>
          <TD width=360></TD>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
                
                <TD style="HEIGHT: 28px" width=150>
                	<INPUT id="user_code" style="WIDTH: 130px" name="user_code" onblur="checkCode()">
                </TD>
                <TD style="HEIGHT: 28px" width=370>
                	<SPAN id="codeId" style="FONT-WEIGHT: bold;"></SPAN>
                 </TD>
              </TR>
              
              <TR>
                <TD style="HEIGHT: 28px">登录密码：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id="user_password" style="WIDTH: 130px" type=password name="user_password">
                </TD>
                <TD style="HEIGHT: 28px">
                	<SPAN id=RequiredFieldValidator4 
                  	style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN>
                  </TD>
              </TR>
              
              <TR>
                <TD style="HEIGHT: 28px">用户姓名：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id="user_name" style="WIDTH: 130px" type="text" name="user_name">
                </TD>
                
                <TD style="HEIGHT: 28px">
                	<SPAN id=RequiredFieldValidator4 style="FONT-WEIGHT: bold;"></SPAN>
                </TD></TR>
              
              <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD></TR>
              <TR>
                <TD></TD>
                <TD>
                  
                <input type="submit" value="注册" />  
                  
              </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="images/login_3.jpg" 
border=0></TD></TR></TBODY></TABLE></DIV></DIV>


</FORM></BODY></HTML>


</body>
</html>