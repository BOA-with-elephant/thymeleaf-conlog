package com.boa.conlog.member.model.dao;

import com.boa.conlog.member.model.dto.EmailAndMemberDTO;
import com.boa.conlog.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    //interface이름이 단순 Mapper로 어노테이션이랑 똑같으면, @Mapper 어노테이션이 안 붙는다(노란 글씨로 안 바뀌고 흰색 일반 글자 처리됨)
    List<MemberDTO> findAllMember();

    List<EmailAndMemberDTO> findMemberByEmail(@Param("email") String email);

    void updateMember(MemberDTO updateMember);
    //이제 MemberMapper.xml 가서 <UPDATE> 작성 17:37

    void deleteMember(MemberDTO deleteMember);
    //MemberMapper.xml가서 <DELETE> 작성 18:12

    void createNewMember(MemberDTO newMember);

}
