package org.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.spring.dao.UserDAO;
import org.spring.dto.UserDTO;
import org.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private LoginService los;
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		
		return "main";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		
		return "register";
	}
	
	@RequestMapping("/forgot-password")
	public String forgot() {
		
		return "forgot-password";
	}
	
	//회원가입 버튼 눌렀을 때
	@ResponseBody
	@RequestMapping("/join_ok")
	public String join_ok(HttpServletRequest request, HttpServletResponse response, UserDTO dto, @RequestParam("user_pwd2") String pwd) throws IOException {
		
		//service에 로직 만들어서 테스트해본 것
		String test = los.join(dto, pwd);
		
		return test;
	}
	
	//로그인 버튼 눌렀을 때
	@RequestMapping("login_ok")
	@ResponseBody
	public void login_ok(@RequestParam("user_id") String id, @RequestParam("user_pwd") String pwd,
			HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		
		//한글설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		
		
		String db_pwd = userDAO.pwdcheck(id);
		
		//아이디로 조회해서 비밀번호 맞는지 등 체크
		UserDTO dto = userDAO.userInfo(id);
		
		PrintWriter out = response.getWriter();
		
		int count = userDAO.idcheck(id);
		if(count == 0) {
			out.println("<script>");
			out.println("alert('없는 아이디')");	
			out.println("history.back()");
			out.println("</script>");
		}else {
			if(db_pwd.equals(pwd) && !id.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("session_id", dto.getUser_id());
				session.setAttribute("session_email", dto.getUser_email());
				session.setAttribute("session_name", dto.getUser_name());
				out.println("<script>");
				out.println("alert('로그인 성공')");	
				out.println("location.href='main'");
				out.println("</script>");
			}else if(db_pwd.equals(pwd) && id.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("session_id", dto.getUser_id());
				session.setAttribute("session_email", dto.getUser_email());
				session.setAttribute("session_name", dto.getUser_name());
				out.println("<script>");
				out.println("alert('관리자 로그인 성공')");
				out.println("location.href='main_admin'");
				out.println("</script>");
			}else {
			
				out.println("<script>");
				out.println("alert('비밀번호 틀림')");	
				out.println("history.back()");
				out.println("</script>");
			}
		}
	}
	
	//gmail 메일전송
	@Autowired
    protected JavaMailSender gmailMailSender;
	//forgot 비밀번호 찾기 눌렀을 때
	@RequestMapping("forgot_ok")
	public void forgot_ok(@RequestParam("user_email") String email, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//한글설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		int email_check = userDAO.emailcheck(email);
		String pwd = userDAO.pwd(email);
		
		PrintWriter out = response.getWriter();
		
		if(email_check == 0) {
			out.println("<script>");
			out.println("alert('없는이메일')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			try{
	            MimeMessage mail = gmailMailSender.createMimeMessage();
	            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
	            
	            mailHelper.setTo(email);   					// 받을 이메일
	            mailHelper.setSubject("비밀번호 전달 드립니다.");  // 제목
	            mailHelper.setText("해당계정 비밀번호는 " + pwd + " 입니다");  // 내용
	 
	            // 전송
	            gmailMailSender.send(mail);
	            
	            out.println("<script>");
				out.println("alert('메일전송완료')");	
				out.println("location.href='login'");
				out.println("</script>");
	        }catch(MessagingException e){
	            System.out.println("MessagingException");
	            e.printStackTrace();
	        }
			
		}
	}
	
	//프로필 버튼 눌렀을 때
	@RequestMapping("profile")
	public String profile(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		//session 받아오기
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("session_id");
		
		UserDTO dto = userDAO.userInfo(user_id);
		
		model.addAttribute("dto", dto);
		
		return "profile";
	}
	
	// 회원정보 변경 눌렀을 때
	@RequestMapping("/profile_ok")
	@ResponseBody
	public String profile_ok(HttpServletRequest request, HttpServletResponse response, Model model, String user_id,String user_pwd,String user_name,String user_email) throws Exception {
		
		//한글설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
	
		//session 받아오기
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("session_id");
		
		UserDTO dto = userDAO.userInfo(user_id);
		
		dto.setUser_email(user_email);
		dto.setUser_name(user_name);
		dto.setUser_pwd(user_pwd);

		userDAO.userUpdate(dto);
		
		return "profile";
	}
}
