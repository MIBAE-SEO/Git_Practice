package kr.co.sol.custom.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sol.custom.service.MemberService;
import kr.co.sol.dto.memberDTO;


@Controller
public class CustomController {

	@Autowired
	MemberService memberService;
		
	
	
	
	@GetMapping("/")
	public String index(HttpServletRequest request,Model model,HttpServletResponse response) {
		
		//세션을 생성해서 받아서
		//회원정보가 있으면 회원정보를 저장 
		HttpSession session
		= request.getSession();
		
		String mem_id=
				(String)session.getAttribute("idKey");
		memberDTO member=new memberDTO();
		member.setMem_id(mem_id);
		return "index";
		
	}
	@GetMapping("/register")
	public String register(HttpServletRequest request,Model model,HttpServletResponse response) {
		
		return "Register";

	}
	
	  @GetMapping(value = "/login")
	   public String login(memberDTO mdto,HttpServletRequest request,HttpServletResponse response, Model model) {
	      
	      return "Login";
	      
	   }
	

	@RequestMapping(value="/idcheck")
	@ResponseBody
	public int idCheck(memberDTO mdto,HttpServletRequest request,HttpServletResponse response, Model model) {
		System.out.println(mdto.getMem_id()); 
		int cnt=0;
		String id =mdto.getMem_id();
		if(mdto.getMem_id()!=null) {
		 cnt=memberService.idCheck(id);
		}
		return cnt;
	}

	@RequestMapping(value="/registerProc")
	public String registerProc(memberDTO mdto,HttpServletRequest request,HttpServletResponse response, Model model) {
		//memberJoin 
		int r=memberService.memberJoin(mdto);
		if(r>0)
		model.addAttribute("msg","회원가입성공"); //저장결과 등을 확인하는 메소드 
		else
		model.addAttribute("msg","회원가입실패"); //저장결과 등을 확인하는 메소드 
		return"MsgPage";
	}
	
	
	@RequestMapping(value="/login")
	public String login() {
		return"Login";
	}
	
	@RequestMapping(value="/loginProc")
	public String loginProc(memberDTO mdto,HttpServletRequest request,HttpServletResponse response, Model model) {
		//memberJoin 
		String id=memberService.logonProc(mdto);
		HttpSession session = request.getSession();
		session.setAttribute("idKey",id);
		return "index";
	}
	
}
