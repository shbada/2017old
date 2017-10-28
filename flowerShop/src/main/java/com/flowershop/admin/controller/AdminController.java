package com.flowershop.admin.controller;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flowershop.admin.domain.RequestVo;
import com.flowershop.admin.service.AdminService;
import com.flowershop.login.domain.UserVo;

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService; //서비스 객체 자동 주입
	
	@Autowired
	private JavaMailSender mailSender; //메일 전송 라이브러리 객체
	
	//고객 센터 문의 작성 화면
	@RequestMapping(value = "/customerCenter", method = RequestMethod.GET)
	public String customerCenter() throws Exception {		
		return "admin/customerCenter";
	}
	
	//고객 센터 메일 전송 추가
	@RequestMapping(value = "/mailForm")
	public String mailForm() {
		return "admin/mailForm";
	}
	//고객 센터 메일 전송
	@RequestMapping(value = "/mailSending")
	public String mailSending(HttpServletRequest request) {
		String setfrom = "cksthddl92@gmail.com"; //보내는사람 이메일    			
	    String tomail  = request.getParameter("tomail");     // 받는 사람 이메일	    
	    String title   = request.getParameter("request_title");      // 제목
	    String content = request.getParameter("request_content");    // 내용	    	    
	    String id = request.getParameter("user_id"); //아이디
	    
	    //메세지 전송 처리 객체 생성후 호출하여 설정(messageHelper)
	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	                          = new MimeMessageHelper(message, true, "UTF-8");
	   
	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함	        
	        messageHelper.setTo(tomail);     // 받는사람 이메일	  	        
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(id + "\n" + content);  // 메일 내용	   	        
	       
	        mailSender.send(message);
	      } catch(Exception e){
	        System.out.println(e);
	      }
	    return "redirect:/customerCenter"; //전송 완료하면 다시 원래 화면
	}
	
	//고객센터 문의 처리
	@RequestMapping(value = "/requestCreate", method = RequestMethod.POST)
	public String requestCreate(@ModelAttribute RequestVo vo) throws Exception {						
		adminService.requestCreate(vo);
		return "redirect:/one_to_one";
	}
	
	//1:1문의 목록
	@RequestMapping("/one_to_one")
	public ModelAndView one_to_one() throws Exception {
		List<RequestVo> one_to_one = adminService.one_to_oneAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/one_to_one");
		mav.addObject("one_to_one", one_to_one);
		return mav;
	}
	
	//1:1문의 상세보기
	@RequestMapping(value = "/requestView", method = RequestMethod.GET)
	public ModelAndView requestView(@RequestParam int request_no, HttpSession session) throws Exception {		
		
		//데이터와 뷰를 한번에 처리하는 객체
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("admin/requestView");
		mav.addObject("dto", adminService.requestRead(request_no));
		return mav;
	}		
	
	//1:1문의 수정
	@RequestMapping(value = "/requestUpdate", method = RequestMethod.GET)
	public void requestUpdateGET(int request_no, Model model) throws Exception {
		model.addAttribute(adminService.requestRead(request_no));
	}	
	@RequestMapping(value = "/requestUpdate", method = RequestMethod.POST)
	public String requestUpdate(RequestVo vo, RedirectAttributes rttr) throws Exception {
		
		logger.info("mod post................");
		
		adminService.requestUpdate(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");	//별도의 url호출 없이 바로 전송되게 한다.	
		return "redirect:/one_to_one";
	}
	
	//1:1문의 삭제
	@RequestMapping("/requestDelete")
	public String requestDelete(@RequestParam int request_no, RedirectAttributes rttr) throws Exception {
		adminService.requestDelete(request_no);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/one_to_one";
	}
	@RequestMapping("/requestDelete2")
	public String requestDelete2(@RequestParam int user_no, RedirectAttributes rttr) throws Exception {
		adminService.requestDelete(user_no);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/allMemberList";
	}
	
	//파일 업로드
	@RequestMapping(value = "/action")
	public String action(@RequestParam("uploadFile") MultipartFile file ,HttpServletRequest request, Model model) throws Exception {
	     
	     File f = new File("C:\\Users\\uploads\\"+file.getOriginalFilename());
	     file.transferTo(f);
	             
	    return "redirect:/customerCenter";
	}
	
	@RequestMapping("/allMemberList")
	public String allMemberList(Model model) throws Exception {
		List<UserVo> list = adminService.allMemberList();
		model.addAttribute("list", list);
		
		return "admin/allMemberList";
	}

	@RequestMapping(value="/memberDetail", method=RequestMethod.POST)
	public String MemberDetail(@ModelAttribute("UserVo") UserVo userVo, Model model, HttpSession session){
		UserVo list = adminService.memberDetail(userVo); 
		model.addAttribute("UserVo", list);
		
		return "admin/memberDetail";
	}
	
	@RequestMapping(value="/memberDelete", method=RequestMethod.POST)
	public String MemberDelete(@ModelAttribute("UserVo") UserVo userVo, Model model, HttpSession session){
		adminService.memberDelete(userVo); 
		return "redirect:/allMemberList";
	}
	
	@RequestMapping(value="/memberDown", method=RequestMethod.POST)
	public String MemberDown(@ModelAttribute("UserVo") UserVo userVo, Model model, HttpSession session){
		adminService.memberDown(userVo); 
		return "redirect:/allMemberList";
	}
	
	@RequestMapping(value="/memberUp", method=RequestMethod.POST)
	public String MemberUp(@ModelAttribute("UserVo") UserVo userVo, Model model, HttpSession session){
		adminService.memberUp(userVo); 
		return "redirect:/allMemberList";
	}
	
}
