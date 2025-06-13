package com.boa.conlog.ott.model.service;

import com.boa.conlog.ott.model.dao.OttMapper;
import com.boa.conlog.ott.model.dto.OttDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OttService {

    private final OttMapper ottMapper;

    public OttService(OttMapper ottMapper){
        this.ottMapper = ottMapper;
    }

    /* OTT 전체 조회 */
    public List<OttDTO> selectAllOtt() {

        return ottMapper.selectAllOtt();
    }

    /* OTT 상세 조회 */
    public OttDTO selectOneOtt(int ottNo) {

        return ottMapper.selectOneOtt(ottNo);
    }

    /* 새 OTT 등록 */
    public void registNewOtt(OttDTO ottDTO) {

        ottMapper.registNewOtt(ottDTO);
    }

    /* 마지막 OTT 번호 조회 */
    public int selectLastOttNo() {

        return ottMapper.selectLastOttNo();
    }

    /* 마지막 OTT 번호에 +1 하기 */
    public void updateLastOttNo(int newLastOttNo) {

        ottMapper.updateLastOttNo(newLastOttNo);
    }

    /* OTT 수정 */
    public void modifyOttName(OttDTO ottDTO) {

        ottMapper.modifyOttName(ottDTO);
    }

    /* OTT 삭제 */
    public void deleteOtt(int ottNo) {

        ottMapper.deleteOtt(ottNo);
    }
}
