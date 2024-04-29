package com.MashuMashu.springbootlibrary.Service;

import com.MashuMashu.springbootlibrary.dao.BookRepository;
import com.MashuMashu.springbootlibrary.dao.ReviewRespository;
import com.MashuMashu.springbootlibrary.entity.Review;
import com.MashuMashu.springbootlibrary.requestmodels.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;


@Service
@Transactional
public class ReviewService {

    private BookRepository bookRepository;

    private ReviewRespository reviewRespository;

    @Autowired
    public ReviewService(BookRepository bookRepository, ReviewRespository reviewRespository) {
        this.bookRepository = bookRepository;
        this.reviewRespository = reviewRespository;
    }

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
        Review validateReview = reviewRespository.findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());

        if(validateReview != null) {
            throw new Exception("Review already created!");
        }

        Review review = new Review();
        review.setBookId(reviewRequest.getBookId());
        review.setRating(reviewRequest.getRating());
        review.setUserEmail(userEmail);

        if(reviewRequest.getReviewDescription().isPresent()) {
            review.setReviewDescription(reviewRequest.getReviewDescription().map(Object::toString).orElse(null));
        }

        review.setDate(Date.valueOf(LocalDate.now()));
        reviewRespository.save(review);
    }

}
