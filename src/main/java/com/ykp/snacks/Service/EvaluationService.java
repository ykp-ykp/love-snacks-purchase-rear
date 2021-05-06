package com.ykp.snacks.Service;

import com.ykp.snacks.domain.evaluation;

import java.util.List;

public interface EvaluationService {
    public List<evaluation> getEvaluationByGoodsName(String goodsName);
    public List<evaluation> getPersonalEvaluation(String openid);
    public evaluation getOneEvaluation(String orderid,String openid);
    public void addEvaluation(evaluation evaluation);
}
