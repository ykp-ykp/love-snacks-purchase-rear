package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.GoodsDao;
import com.ykp.snacks.Service.GoodsService;
import com.ykp.snacks.domain.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    @Override
    public void deleteGoods(String name) {
        goodsDao.deleteGoods(name);
    }

    @Override
    public goods getGoodsByname(String name) {
        return goodsDao.getGoodsByname(name);
    }

    @Override
    public String addGoods(goods goods) {
        goodsDao.addGoods(goods);
        return "1";
    }

    @Override
    public List<goods> FuzzyQuery(String name){
        return goodsDao.FuzzyQuery(name);
    }

    @Override
    public void updateGoods(goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public void updateSurplus(String name, int surplus) {
        goodsDao.updateSurplus(name,surplus );
    }

    @Override
    public void updateSales(String name, int sales) {
        goodsDao.updateSales(name,sales );
    }
}
