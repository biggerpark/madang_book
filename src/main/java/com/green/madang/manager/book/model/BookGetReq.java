package com.green.madang.manager.book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


// 프론트에서 url 을 통해 받은 값을 객체화 시켜 SELECT 의 매개변수로 이용할 것이다.
@Getter
@Setter
public class BookGetReq {
    private int page; // 실제 받는 값
    private int size; // 실제 받는 값
    private String searchText; //
    @JsonIgnore //swagger 문서에서 멤버필드가 안나오게 하고 싶으면 이 애노테이션을 붙이면 된다.
    private int startIdx; // 계산되는 값( (page-1)*size  )

}
