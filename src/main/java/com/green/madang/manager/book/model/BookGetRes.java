package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookGetRes {
    @Schema(title="")
    private int bookId;
    private String bookName;
    private String publisher;
    private int price;
}
