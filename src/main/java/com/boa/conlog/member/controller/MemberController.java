package com.boa.conlog.member.controller;
import com.boa.conlog.member.model.dto.EmailAndMemberDTO;
import com.boa.conlog.member.model.dto.MemberDTO;
import com.boa.conlog.member.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


//3) attach @Controller to make this class as a controller Bean
@Controller
//4) put @RequestMapping("/member") to make this class mapping with localhost:8001/member/* page
@RequestMapping("/member")
public class MemberController {

    //5) call the Service with final to use in this class
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member-list")
    public String findMemberList(Model model){
        List<MemberDTO> memberList = memberService.findAllMember();

        model.addAttribute("memberList", memberList);
        return "member/member-list";
    }

    @GetMapping("/email-input")
    public String showEmailInputForm(Model model){
        List<MemberDTO> memberList = memberService.findAllMember();
        model.addAttribute("memberList", memberList);
        return "member/email-input";
    }

    @PostMapping("/email-input")
    public String processEmailInput(@RequestParam("email") String email, Model model){
        model.addAttribute("email", email);
        return "member/email-input";
    }
    /*Whitelabel Error Page :This application has no explicit mapping for /error, so you are seeing this as a fallback.
Thu Jun 12 15:56:13 KST 2025
There was an unexpected error (type=Method Not Allowed, status=405).
Method 'POST' is not supported.
@GetMapping("/email-input")만 있었는데 Post is not supported라고 해서
@PostMapping("/email-input") 만들어줌 16:00 */

    //6) go to MemberService to request MenuMapper
    @PostMapping("/email-list")
    //7)resources아래에 member-member-list.html.html 내용 채우러 간다
    public String showMenuByCategoryCode(@RequestParam("email") String email, Model model) {

        //9) MemberDTO에 한 번에 담아서 MenuService.java로 전달
        List<EmailAndMemberDTO> memberByEmail = memberService.findMemberByEmail(email); //MemberDTO의 변수를
        //10)MenuService.java에 findMemberByEmail ALT+ENTER로 생성
        model.addAttribute("memberByEmail", memberByEmail);
        //view 쪽으로 넘겨주는 출력문.html에선 ""안에 들어간 이름을 참조한다.
        //만약 .html에서  <tr th:each="member: ${memberByEmail}">로 받았는데
        //컨트롤러에선 "member"로 보냈다면 매치가 안 되어서 실제 데이터가 출력되지 않을 것. 16:33
        model.addAttribute("memberEmail", email);
        return "member/email-list";
    }

    //17:35 아... 콘트롤러, 서비스, 매퍼(인터페이스) 까먹을 뻔
    @GetMapping("/update")
    public String updatePage(Model model){
        List<MemberDTO> memberList = memberService.findAllMember();
        model.addAttribute("memberList", memberList);
        return "member/update";
    }

    @PostMapping("/update")
    public String updateMember(MemberDTO updateMember, RedirectAttributes rttr){
        memberService.updateMember(updateMember);
        rttr.addFlashAttribute("updateSuccess", "정보 수정 성공!");
        return "redirect:/member/member-list";
    }
    
    // 18:08 function delete
    @GetMapping("/delete")
    public String deletePage(Model model){
        List<MemberDTO> memberList = memberService.findAllMember();
        model.addAttribute("memberList", memberList);
        return "member/delete";
    }

    @PostMapping("/delete")
    public String deleteMember(MemberDTO deleteMember, RedirectAttributes rttr){
        memberService.deleteMember(deleteMember);
        rttr.addFlashAttribute("deleteSuccess", "정보 삭제 성공!");
        return "redirect:/member/member-list";
    }

    @GetMapping("/create")
    public void createPage(Model model){
        List<MemberDTO> memberList = memberService.findAllMember();
        model.addAttribute("memberList", memberList);
    }

    @PostMapping("/create")
    public String createNewMember(MemberDTO newMember, RedirectAttributes rttr) {
        //RedirectAttributes : submit 버튼 클릭 후 전송할(보여줄) 메세지 담을 변수
        memberService.createNewMember(newMember);

        rttr.addFlashAttribute("successMessage", "Successfully created new member");
        //list.html에서 위에서 작성한 석세스 메세지를 출력할 수 있도록 코드 작성해야함 11:00

        return "redirect:/member/member-list"; //After registering, show the user that the menu really successfully registered with
    }
}
