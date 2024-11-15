package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateReq {
    private int bookId;
    private String bookName;
    private String publisher;
    private Integer price;
    /*
    실제 책 가격을 0으로 수정하고 싶었음. 그러면 쿼리스트링에 추가했을것.

    책 가격을 수정하고 싶지 않았음(현상 유지). 쿼리스트링에 추가안함 price=0 이 됏을것.


    그래서 Integer로 해주면 값이 안들어오면 null로 유지되기 때문에 dynamic update문을 사용하면 현상 유지가 가능해진다.
     */


}
