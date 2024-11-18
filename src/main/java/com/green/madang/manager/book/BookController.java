package com.green.madang.manager.book;


import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // system.out.println 대신에 이 에노테이션을 붙여준다.
@RestController
@RequiredArgsConstructor // final 이 붙은 멤버필드만 생성자를 통해 DI를 받아준다.
@RequestMapping("manager/book")
@Tag(name="도서",description="도서 APT") // Tag 에노테이션은 Controller 에 기입해준다. 이렇게 따로 작성안해주면, swagger 의 기본값은 클래스명이 나온다.
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary="도서입고",description="도서 입고 처리 API <br> 보기 API") //Operation 에노테이션은 Controller 의 리턴메소드 위에 기입을 해준다.
    // tip) <br>태그는  html 에서 개행을 의미한다. 그래서 위에 <br>을 달아주면, swagger 에서 개행이 되어 표시된다.
    public MyResponse<Integer> insBook(@RequestBody BookPostReq p){
        // 위에 Slf4j 라는 에노테이션이 붙으면, 밑에 보이는 log 를 이용해서 원하는 데이터를 출력해주자.
        log.info("info----------{}",p); // p 변수에 들어가있는 데이터를 {}안에 넣어서 info 해준다. printf 랑 비슷하다고 보면 된다.
        log.info("dddd"); // 어떤 정보를 찍고싶을때
        log.warn("ward"); // 경고를 남기고 싶을때
        log.error("error"); // 에러메시지를 남기고 싶을때
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
