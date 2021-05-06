package com.ykp.snacks.Service;

import com.ykp.snacks.domain.goods;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsService {
    public void deleteGoods(String name);
    public List<goods> getAllGoods();
    public goods getGoodsByname(String name);
    public String addGoods(goods goods);
    public List<goods> FuzzyQuery(String name);
    public void updateGoods(goods goods);
    public void updateSurplus(String name,int surplus);
    public void updateSales(String name,int sales);
}
