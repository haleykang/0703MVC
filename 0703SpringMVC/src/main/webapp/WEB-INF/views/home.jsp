<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- title은 꼭 정해주기! - 검색 엔진이 타이틀을 보고 검색하기 때문에! -->
<title>강핼리의 Spring MVC 프로젝트</title>
</head>
<body>

	<!-- 기본으로 생성되는 home.jsp는 한글 encoding이 안되어있어서 한글 입력이 안됨 -->
	<!-- 기존 home.jsp를 삭제하고 다시 생성하기! -->
	<!-- goguma.do라는 요청 생김 -> HomeController가 처리(HomeController로 이동) -->
	
	<!-- jsp에서 파라미터를 주는 방법 -->
	<a href="goguma.do?num=1212&page=1">페이지 이동</a> <br/>
	<!-- HomeController에서 넘긴 데이터를 가져오기 -->
	<!-- model.addAttribute("attr", "넘기고 싶은 데이터");  -->
	${attr}

</body>
</html>