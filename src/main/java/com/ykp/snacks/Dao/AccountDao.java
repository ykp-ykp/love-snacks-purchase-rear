package com.ykp.snacks.Dao;

import com.ykp.snacks.domain.Account;
import com.ykp.snacks.domain.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper   /*@Mapper不可以省略*/
public interface AccountDao {

    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account (name,money) values(#{name},#{money})")
    public void saveAccount(Account account);

    @Insert("insert into user (openid,nickName,avatarUrl,phone) values(#{openid},#{nickName},#{avatarUrl},#{phone})")
    public void saveUser(user user);

}

