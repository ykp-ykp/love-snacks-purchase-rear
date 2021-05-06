package com.ykp.snacks.Dao;

import com.ykp.snacks.domain.admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper   /*@Mapper不可以省略*/
public interface AdminDao {

    @Select("select * from admin where name=#{name} and password=#{password}")
    public admin vertifyAdmin(String name,String password);

    @Select("select * from admin where name=#{name}")
    public admin getAdminByName(String name);

    @Update("update admin set password=#{password},phone=#{phone} where name=#{name}")
    public void update(admin admin);
}