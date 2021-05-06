package com.ykp.snacks.Dao;

import com.ykp.snacks.domain.goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper   /*@Mapper不可以省略*/
public interface GoodsDao {
    @Insert("insert into goods (name,price,type,surplus,discount,sales,image,information) values(#{name},#{price},#{type},#{surplus},#{discount},#{sales},#{image},#{information})")
    public void addGoods(goods goods);

    @Delete("delete from goods where name=#{name}")
    public void deleteGoods(String name);

    @Select("select * from goods")
    public List<goods> getAllGoods();

    @Select("select * from goods where name=#{name}")
    public goods getGoodsByname(String name);

//concat函数是是用于模糊查询的，格式如下
    @Select("select * from goods where name like concat('%',#{name},'%')")
    public List<goods> FuzzyQuery(String name);

    @Update("update goods set price=#{price},type=#{type},surplus=#{surplus},discount=#{discount},information=#{information},image=#{image} where name=#{name}")
    public void updateGoods(goods goods);

    @Update("update goods set surplus=#{surplus} where name=#{name}")
    public void updateSurplus(String name,int surplus);

    @Update("update goods set sales=#{sales} where name=#{name}")
    public void updateSales(String name,int sales);
}
