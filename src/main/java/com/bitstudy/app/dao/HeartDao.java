package com.bitstudy.app.dao;

import com.bitstudy.app.domain.HeartDto;

import java.util.List;
import java.util.Map;

public interface HeartDao {
    int deleteMyLike(String user_id);
    int deleteLikeOne(Integer FK_A_seqno, String H_writer);
    int insertMyLike(Integer FK_A_seqno, String H_writer);
    int MyArticleHeart(String user_id);

    List<HeartDto> heartCount( );

    HeartDto heartSelect (Map map);

    HeartDto heartCountOne (Integer A_seqno);
}
