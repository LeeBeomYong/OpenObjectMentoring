package org.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// 로그인 안한 사용자
	@RequestMapping("/")
	public String main() {
		
		return "main";
	}
	
	// 일반 사용자
	@RequestMapping("/main")
	public String main2() {
		
		return "main2";
	}
	
	// 관리자 로그인
	@RequestMapping("/main_admin")
	public String main3() {
		
		return "admin/main_admin";
	}
	
}
