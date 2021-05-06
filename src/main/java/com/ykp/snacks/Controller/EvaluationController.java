package com.ykp.snacks.Controller;

import com.ykp.snacks.Service.Impl.EvaluationServiceImpl;
import com.ykp.snacks.domain.evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/EvaluationController")
public class EvaluationController {
    @Autowired
    private EvaluationServiceImpl evaluationService;

    @ResponseBody
    @PostMapping(path="/getEvaluationByGoodsName")
    public List<evaluation> getEvaluationByGoodsName(String goodsName) {
        return evaluationService.getEvaluationByGoodsName(goodsName);
    }

    @ResponseBody
    @PostMapping(path="/getOneEvaluation")
    public evaluation getOneEvaluation(String orderId,String openid) {
        return evaluationService.getOneEvaluation(orderId,openid );
    }

    @ResponseBody
    @PostMapping(path="/addEvaluation")
    public String addEvaluation(evaluation evaluation) {
        evaluationService.addEvaluation(evaluation);
        return "1";
    }
}
