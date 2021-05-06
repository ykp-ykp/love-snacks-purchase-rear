package com.ykp.snacks.Service;

import com.ykp.snacks.domain.feedback;

import java.util.List;

public interface FeedbackService {
    public void addFeedback(feedback feedback);
    public List<feedback> getAllFeedback();
}

