package org.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.spring.dto.SearchCondition;
import org.spring.dto.UserDTO;
import org.spring.service.AdminLoginServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminLoginController {
	
	@Autowired
	private AdminLoginServiceIpml als;
	
	// 관리자로 로그인해서 userlist로 이동
	@RequestMapping("admin_userList")
	public String admin_userList(Model model, SearchCondition sc) {
		
		Map<String, Object> map = als.user_list(sc);
		
		model.addAttribute("totalCnt", map.get("totalCnt"));
		model.addAttribute("List", map.get("List"));
		model.addAttribute("ph", map.get("pageHandler"));
		
		return "admin/user_list";
	}
	
	// 유저목록에서 수정 눌렀을 때 수정 페이지로 이동
	@RequestMapping("admin_userUpdate")
	public String admin_userUpdate(UserDTO dto, @RequestParam("no") int no, Model model) {
		dto = als.user_update(no);
		model.addAttribute("dto", dto);
		return "admin/user_update";
	}
	
	// 유저 상세정보에서 수정 버튼 눌렀을 때
	@RequestMapping("admin_userUpdate_ok")
	@ResponseBody
	public void admin_userUpdate_ok(UserDTO dto) {
		als.user_update_ok(dto);
	}
	
	// 유저 상세 정보에서 삭제 버튼 눌렀을 때
	@RequestMapping("admin_userDelete_ok")
	@ResponseBody
	public String admin_userDelete_ok(@RequestParam("no") int no){
		als.user_delete_ok(no);
//		als.user_num_update(no);
		return "<script>location.href='admin_userList'</script>";
	}
	
	// 관리자가 회원 목록에서 등록하기 누르면 페이지 이동
	@RequestMapping("admin_userInsert")
	public String admin_userInsert() {
		return "admin/user_insert";
	}
	
	@RequestMapping(value = "admin_userInsert_ok")
	@ResponseBody
	public String admin_userInsert_ok(UserDTO dto, @RequestParam("user_id") String id, @RequestParam("user_pwd") String pwd,
			@RequestParam("user_email") String email, @RequestParam("user_name") String name) {
		String move = als.user_insert(dto, id, pwd, email, name);
		
		if(move.equals("아이디 실패")) { return "<script>alert('중복아이디');history.go(-1);</script>"; }
		else if(move.equals("이메일 실패")) { return "<script>alert('중복이메일');history.go(-1);</script>";}
		else {	return "<script>alert('등록 성공');location.href='admin_userList';</script>";}
	}
}
