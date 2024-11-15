package com.green.madang.manager.book;


import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final 이 붙은 멤버필드만 생성자를 통해 DI를 받아준다.
@RequestMapping("manager/book")
@Tag(name="도서",description="도서 APT")
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary="도서입고",description="도서 입고 처리 API")
    public MyResponse<Integer> insBook(@RequestBody BookPostReq p){
        int result=service.insBook(p);

        // MyResponse<Integer> 객체 생성하자
        MyResponse<Integer> response=new MyResponse<>("책등록 완료",result); // GENERIC 은 이런식으로 생성자를 통해 멤버필드에 값을 넣을 수 있다.
        return response;
    }

    @GetMapping
    public MyResponse<List<BookGetRes>> selBookList(@ParameterObject @ModelAttribute BookGetReq p){

        List<BookGetRes> list=service.selBookList(p);

        return new MyResponse<>(p.getPage()+"페이지데이터",list);

    }

    @PutMapping
    public MyResponse<Integer> updateBook(@RequestBody BookUpdateReq p){
        int result=service.upDynBook(p);
        MyResponse<Integer> response=new MyResponse<>("책 업데이트 완료",result);

        return response;
    }

    @DeleteMapping
    public MyResponse<Integer> delBook(@ParameterObject @ModelAttribute BookDeleteReq p){
        int result=service.delBook(p);

        MyResponse<Integer> response=new MyResponse<>("삭제완료",result);
        return response;
    }
}
