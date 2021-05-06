package com.ykp.snacks.Dao;


import com.ykp.snacks.domain.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper   /*@Mapper不可以省略*/
public interface UserDao {

    @Select("select * from user")
    public List<user> getAllUser();

    @Insert("insert into user (openid,nickName,avatarUrl,phone,address) values(#{openid},#{nickName},#{avatarUrl},#{phone},#{address})")
    public void addUser(user user);

    @Select("select * from user where openid=#{openid}")
    public user getUserByOpenid(String openid);

    @Update("update user set phone=#{phone} where openid=#{openid}")
    public void updateUser(String phone,String openid);

    @Update("update user set address=#{address} where openid=#{openid}")
    public void updateAddress(String address,String openid);

    @Update("update user set address=#{address},phone=#{phone} where openid=#{openid}")
    public void updatePWDADD(user user);

}
