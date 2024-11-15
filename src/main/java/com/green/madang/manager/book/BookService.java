package com.green.madang.manager.book;


import com.green.madang.manager.book.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper;

    public int insBook(BookPostReq p){
        return mapper.insBook(p);
    }

    public List<BookGetRes> selBookList(BookGetReq p){
//        int page=p.getPage();
//        int size=p.getSize();
//        int sIdx=(page-1)*size;
//        p.setSIdx(sIdx);
//        이 위의 4줄을 밑의 한줄로 처리 가능하다.
        p.setStartIdx((p.getPage()-1)*p.getSize()); // Service 클래스에서 최초로 로직 사용하는 예시, BookGetReq 객체의 멤버필드인 sIdx 값을 넣어주는것.


        return mapper.selBookList(p);
    }

    public int upDynBook(BookUpdateReq p){
        return mapper.upDynBook(p);
    }

    public int delBook(BookDeleteReq p){
        return mapper.delBook(p);
    }




}
