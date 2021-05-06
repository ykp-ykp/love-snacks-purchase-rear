package com.ykp.snacks.Dao;

import com.ykp.snacks.domain.feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FeedbackDao {

    @Insert("insert into feedback values(#{openid},#{nickName},#{type},#{content},#{time})")
    public void addFeedback(feedback feedback);

    @Select("select * from feedback")
    public List<feedback> getAllFeedback();
}
