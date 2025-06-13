package com.boa.conlog.ott.controller;

import com.boa.conlog.ott.exception.OttNotFoundException;
import com.boa.conlog.ott.model.dto.OttDTO;
import com.boa.conlog.ott.model.service.OttService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ott")
public class OttController {

    private final OttService ottService;

    public OttController(OttService ottService){
        this.ottService = ottService;
    }

    /* OTT 관리 페이지 - OTT 전체 조회 */
    @GetMapping("/list")
    public String ottPage(Model model){

        List<OttDTO> ottList = ottService.selectAllOtt();

        model.addAttribute("ottList", ottList);

        return "ott/list";
    }

    /* OTT 상세 조회 */
    @GetMapping("/one/{ottNo}")
    public String selectOneOtt(@PathVariable int ottNo, Model model) throws OttNotFoundException {

        OttDTO ott = ottService.selectOneOtt(ottNo);

        if(ott == null){
            throw new OttNotFoundException("해당 번호의 OTT는 찾을 수 없습니다.");
        }

        model.addAttribute("oneOtt", ott);

        return "ott/oneOtt";
    }

    /* OTT 추가 */
    @PostMapping("/regist")
    public String registNewOtt(RedirectAttributes rttr, @RequestParam String newOttName){

        /* 마지막을 그 외로 유지하고 새로 등록하는 ott를 그 외 이전 번호로 넣고싶음 */
        /* 마지막 OTT 번호 조회 */
        int lastOttNo = ottService.selectLastOttNo();
        System.out.println("lastOttNo = " + lastOttNo);

        /* 기타 OTT 번호 수정 */
        int newLastOttNo = lastOttNo + 1;
        ottService.updateLastOttNo(newLastOttNo);

        /* 등록하기 */
        OttDTO ottDTO = new OttDTO();
        ottDTO.setOttNo(lastOttNo);
        ottDTO.setOttName(newOttName);
        
        ottService.registNewOtt(ottDTO);

        rttr.addFlashAttribute("successMessage", "신규 OTT 등록에 성공하셨습니다.");

        return "redirect:/ott/list";
    }

    /* OTT 수정 */
    @PostMapping("/modify")
    public String modifyOttName(RedirectAttributes rttr, OttDTO ottDTO){

        ottService.modifyOttName(ottDTO);

        System.out.println("ottDTO = " + ottDTO);

        rttr.addFlashAttribute("successMessage", "정보 수정에 성공하였습니다.");

        return "redirect:/ott/one/" + ottDTO.getOttNo();
    }

    /* OTT 삭제 */
    @PostMapping("/delete")
    public String deleteOtt(@RequestParam int ottNo, RedirectAttributes rttr){

        ottService.deleteOtt(ottNo);

        /* "그 외" 전 ott의 번호 불러온 후 "그 외"번호 수정 */
        int lastSecondOttNo = ottService.findLastSecondOttNo();
        int newEctOttNo = lastSecondOttNo + 1;
        ottService.modifyEctOttNo(newEctOttNo);

        rttr.addFlashAttribute("successMessage", "OTT를 성공적으로 삭제했습니다.");

        return "redirect:/ott/list";
    }



}
