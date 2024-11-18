package com.green.madang.manager.book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


// 프론트에서 url 을 통해 받은 값을 객체화 시켜 SELECT 의 매개변수로 이용할 것이다.
@Getter
@Setter
public class BookGetReq {
//    @Parameter(description = "선택된 페이지값",example = "1",required = true) // required=true 는 프론트에서 무조건 값을 날려야한다는 표시를 swagger에 해준다.
    // 또한 프론트에서 이 값을 보내지 않을려고 하면 아에 진행조차 안된다.
    @Schema(description = "선택된 페이지값",example = "1",requiredMode =Schema.RequiredMode.REQUIRED) //Parameter 에노테이션은 get 방식에서 쿼리스트링으로 보낼때만 적용이 된다.
    // 그래서 Post 랑 동일하게 Schema 로 통일하면 된다.
    private int page; // 실제 받는 값
//    @Parameter(description = "한페이지당 보여질 아이템 수",example = "30",required = true)
    @Schema(description = "한페이지당 보여질 아이템 수",example = "30",requiredMode =Schema.RequiredMode.REQUIRED)
    private int size; // 실제 받는 값
//    @Parameter(description = "도서 제목에서 검색을 한다",example = "검색 텍스트")
    @Schema(description = "도서 제목에서 검색을 한다",example = "검색 텍스트",requiredMode =Schema.RequiredMode.REQUIRED)
    private String searchText; //
    @JsonIgnore //swagger 문서에서 멤버필드가 안나오게 하고 싶으면 이 애노테이션을 붙이면 된다.
    private int startIdx; // 계산되는 값( (page-1)*size  )

}
