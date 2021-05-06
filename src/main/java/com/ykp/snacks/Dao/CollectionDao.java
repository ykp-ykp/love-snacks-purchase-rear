package com.ykp.snacks.Dao;

import com.ykp.snacks.domain.collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CollectionDao {

    @Select("select * from collection where openid=#{openid}")
    public List<collection> getByOpenid(String openid);

    @Insert("insert into collection values(#{openid},#{goodsName},#{price},#{type},#{image},#{information},#{discount})")
    public void addCollection(collection collection);

    @Delete("delete from collection where openid=#{openid} and goodsName=#{goodsName}")
    public void deleteOneCollection(String openid,String goodsName);
}
