package com.MashuMashu.springbootlibrary.controller;

import com.MashuMashu.springbootlibrary.Service.ReviewService;
import com.MashuMashu.springbootlibrary.requestmodels.ReviewRequest;
import com.MashuMashu.springbootlibrary.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization") String token, @RequestBody ReviewRequest reviewRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if(userEmail == null) {
            throw new Exception("User email is missing!");
        }
        reviewService.postReview(userEmail, reviewRequest);
    }
}