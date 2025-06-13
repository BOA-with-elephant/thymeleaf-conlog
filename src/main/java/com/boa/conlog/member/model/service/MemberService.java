package com.boa.conlog.member.model.service;

import com.boa.conlog.member.model.dao.MemberMapper;
import com.boa.conlog.member.model.dto.EmailAndMemberDTO;
import com.boa.conlog.member.model.dto.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {
    //7) summon the MemberMapper to push request to menuMapper from MenuService
    private final MemberMapper mapper;
    public MemberService(MemberMapper mapper){
        this.mapper=mapper;
    }

    public List<MemberDTO> findAllMember() {
        return mapper.findAllMember();
    }     //8) fill the MemberDTO before use it


    public List<EmailAndMemberDTO> findMemberByEmail(String email) {
        return mapper.findMemberByEmail(email);
    }

    public void updateMember(MemberDTO updateMember) {
        mapper.updateMember(updateMember);
    }

    public void deleteMember(MemberDTO deleteMember) {
        mapper.deleteMember(deleteMember);
    }

    @Transactional
    public void createNewMember(MemberDTO newMember) {
        mapper.createNewMember(newMember);
    }

}
