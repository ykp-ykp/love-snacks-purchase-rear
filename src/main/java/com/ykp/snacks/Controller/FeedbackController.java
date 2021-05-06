package com.ykp.snacks.Controller;

import com.ykp.snacks.Service.Impl.FeedbackServiceImpl;
import com.ykp.snacks.domain.feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/FeedbackController")
public class FeedbackController {

    @Autowired
    private FeedbackServiceImpl feedbackService;

    @ResponseBody
    @PostMapping(path="/addFeedback")
    public String addFeedback(feedback feedback){
        feedbackService.addFeedback(feedback);
        return "1";
    }
}
