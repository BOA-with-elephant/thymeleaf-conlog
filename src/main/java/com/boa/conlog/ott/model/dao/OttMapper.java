package com.boa.conlog.ott.model.dao;

import com.boa.conlog.ott.model.dto.OttDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OttMapper {

    /* OTT 전체 조회 */
    List<OttDTO> selectAllOtt();

    /* OTT 상세 조회 */
    OttDTO selectOneOtt(int ottNo);

    /* 새 OTT 등록 */
    void registNewOtt(OttDTO ottDTO);

    /* 마지막 OTT 번호 조회 */
    int selectLastOttNo();

    /* 마지막 OTT 번호에 +1 하기 */
    void updateLastOttNo(int newLastOttNo);

    /* OTT 수정 */
    void modifyOttName(OttDTO ottDTO);

    /* OTT 삭제 */
    void deleteOtt(int ottNo);
}
