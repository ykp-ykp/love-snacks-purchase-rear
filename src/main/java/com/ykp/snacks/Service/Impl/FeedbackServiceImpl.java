package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.FeedbackDao;
import com.ykp.snacks.Service.FeedbackService;
import com.ykp.snacks.domain.feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public void addFeedback(feedback feedback) {
        feedbackDao.addFeedback(feedback);
    }
}
