package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.EvaluationDao;
import com.ykp.snacks.Service.EvaluationService;
import com.ykp.snacks.domain.evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationDao evaluationDao;

    @Override
    //获取一个商品的所有评价信息
    public List<evaluation> getEvaluationByGoodsName(String goodsName) {
        return evaluationDao.getEvaluationByGoodsName(goodsName);
    }

    @Override
    //获取一个人的所有评价信息
    public List<evaluation> getPersonalEvaluation(String openid) {
        return null;
    }

    @Override
    //获取某人对自己的一个订单的评论
    public evaluation getOneEvaluation(String orderid,String openid) {
        return evaluationDao.getOneEvaluation(orderid,openid );
    }

    @Override
    //添加评论
    public void addEvaluation(evaluation evaluation) {
        evaluationDao.addEvaluation(evaluation);
    }
}
