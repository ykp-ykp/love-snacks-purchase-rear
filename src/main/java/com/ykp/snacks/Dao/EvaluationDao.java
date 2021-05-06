package com.ykp.snacks.Dao;


import com.ykp.snacks.domain.evaluation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper   /*@Mapper不可以省略*/
public interface EvaluationDao {

    @Select("select * from evaluation where goodsName=#{goodsName}")
    public List<evaluation> getEvaluationByGoodsName(String goodsName);

    @Insert("insert into evaluation values(#{orderId},#{openid},#{goodsName},#{time},#{content})")
    public void addEvaluation(evaluation evaluation);

    @Select("select * from evaluation where orderId=#{orderid} and openid=#{openid}")
    public evaluation getOneEvaluation(String orderid,String openid);
}
