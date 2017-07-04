package com.haley.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haley.mvc.domain.Login;

// 객체를 자동 생성하고 사용자의 요청을 처리할 수 있는 객체로 만드는 어노테이션
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// @RequestMapping - value="/"로 오는 요청이 있으면 return 페이지로 가겠다
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		// 모델에 데이터 넘겨주기
		model.addAttribute("attr", "넘기고 싶은 데이터");
		// 위와 같이 추가 할 경우, 하기 return "home"으로 갈 때 위의 데이터를 같이 가져감
		// - > home.jsp로 이동
		
		return "home";
	}

	// home.jsp에서 추가한 goguma.do 요청이 오면 goguma를 리턴하도록 변경
	/*
	 * servlet-context.xml에서 하기와 같이 설정되어있음 <beans:property name="prefix"
	 * value="/WEB-INF/views/" /> <beans:property name="suffix" value=".jsp" />
	 */
	// -> 따라서 /WEB-INF/views/goguma.jsp로 이동
	@RequestMapping(value = "goguma.do", method = RequestMethod.GET)
	public String goguma(@RequestParam("num") int num, @RequestParam("page") int page) {

		System.out.println(num + " : " + page);
		// goguma로 포워딩해라 -> servlet-context.xml로 이동해서 ViewResolver 확인
		// <beans:property name="prefix" * value="/WEB-INF/views/" /> 
		// <beans:property name="suffix" value=".jsp" />
		// /WEB-INF/views/goguma.jsp로 이동
		// 그러나 주소는 goguma.do - 새로고침 할 때 마다 계속 이 함수가 실행됨
		return "goguma";
	}

	///////////////////// Controller에서 파라미터 처리 방법 ////////////////////////
	// 1. HttpServletRequest를 이용한 파라미터 처리
	// login이라는 요청이 오면 아래 login 메소드를 호출

	/*
	 * @RequestMapping(value = "login", method = RequestMethod.POST) public
	 * String login(HttpServletRequest request) {
	 * 
	 * System.out.println(request.getParameter("id"));
	 * System.out.println(request.getParameter("pw")); return "goguma"; }
	 */

	// 2. @RequestParam을 이용한 파라미터 처리
	// -> 형 변환 없이 파라미터를 읽는 것이 가능, 현업 개발자들은 대부분 이 방법을 사용
	/*
	 * @RequestMapping(value = "login", method = RequestMethod.POST) public
	 * String login(@RequestParam("id") String id, @RequestParam("pw") String
	 * pw) {
	 * 
	 * System.out.println("아이디 : " + id); System.out.println("비밀번호 : " + pw);
	 * return "goguma"; }
	 */

	// 3. Command 객체 이용
	// Command 객체의 변수명(Login 클래스의 변수명)과 파라미터 이름이 일치하면 자동으로 대입
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Login login) {
		// 출력하는 메소드에 객체 이름을 직접 대입하면 toString()의 결과가 출력됨
		System.out.println(login);
		return "goguma";
	}

}
