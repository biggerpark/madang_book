package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
public class BookPostReq {
    @Schema(title="도서이름",description = "설명할 거 있으면 적으면 된다",example = "학교종이 땡땡땡",requiredMode =Schema.RequiredMode.REQUIRED)
//    private int bookId; 프론트에서 bookId를 관여하지 않는다. 그래서 프론트에서 받을 내용이 아니기 때문에 bookId는 멤버필드로 적지않는다.
    private String bookName;
    @Schema(title="출판사이름",example = "한빛출판사",requiredMode = Schema.RequiredMode.REQUIRED) //멤버필드 위에 Schema 에노테이션쪽에
    // requiredMode = Schema.RequiredMode.REQUIRED 이 붙으면
    private String publisher;
    @Schema(title="도서가격",example = "12000",requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;
}
