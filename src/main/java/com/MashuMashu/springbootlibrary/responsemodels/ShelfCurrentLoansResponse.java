package com.MashuMashu.springbootlibrary.responsemodels;

import com.MashuMashu.springbootlibrary.entity.Book;
import lombok.Data;

@Data
public class ShelfCurrentLoansResponse {
    public ShelfCurrentLoansResponse(Book book, int dayLeft) {
        this.book = book;
        this.dayLeft = dayLeft;
    }

    private Book book;
    private int dayLeft;
}
