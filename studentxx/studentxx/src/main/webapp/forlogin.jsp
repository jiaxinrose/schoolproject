<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
				<p>请先登录</p>
				<p>3秒后跳转到登录页面...</p>
				<script type="text/javascript">
					setTimeout("location.href='login.jsp'", 3000);
				</script>
			</div>
</body>
</html>