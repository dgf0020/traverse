package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traverse.www.service.MyPageService;
import com.traverse.www.vo.AccountsVO;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
public class MypageController {
   
   @Autowired
   MyPageService ms;
   
   // 마이페이지
   @GetMapping("/myPage")
   public String mypage(HttpSession session) {
  	 AccountsVO user = (AccountsVO) session.getAttribute("user");
  	 
  	 if (user == null) {
  		 return "redirect:/member/login";
  	 }
  	 
  	 return "member/myPage";
   }
   
   // 수정
   @GetMapping("/update")
   public void update() {}
   
   // 수정실행
   @PostMapping("/update")
   public String update(AccountsVO input) {
      ms.update(input);
      return "redirect:/member/logout";
   }
   
   // 삭제
   @GetMapping("/delete/{accounts_idx}")
   public String delete(AccountsVO idx) {
 		
 		ms.deleteAccount(idx);
 		
 		return "redirect:/member/logout";
 	}
}
