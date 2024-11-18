package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("manager/customer")
@Tag(name="고객",description="고객 관리")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary="고객등록")
    public MyResponse<Integer> insCustomer(@RequestBody CustomerPostReq p){

        int result=service.insCustomer(p);

        MyResponse<Integer> response=new MyResponse<>("고객 등록 완료",result);

        return response;
    }

    @GetMapping // select 하는데, 검색타입으로 정렬하고, Limit 도 활용
    @Operation(summary="고객정보 출력")
    //@ParameterObject 이거는 swagger를 위한 에노테이션이다.
    public MyResponse<List<CustomerGetRes>> selCustomerList(@ParameterObject @ModelAttribute CustomerGetReq p){
        List<CustomerGetRes> result=service.selCustomerList(p);

        return new MyResponse<>("고객 정보 출력 완료",result);
    }


    //RequestParam을 이용한 GetMapping
    @GetMapping("/param")
    @Operation(summary = "고객 리스트2", description = "검색할 내용이 있을 시 검색타입, 검색내용을 모두 보내주어야 한다.")
    public MyResponse<List<CustomerGetRes>> getCustomerList2( @RequestParam(required = true) int page
            , @RequestParam int size
            , @RequestParam(name="search_type", required = false) String searchType // required=false 가 의미하는건, 프론트에서 데이터가 무조건 들어와야 하는건 아니다.
            , @RequestParam(name="search_text", required = false) String searchText) {
        CustomerGetReq p = new CustomerGetReq();
        p.setPage(page);
        p.setSize(size);
        p.setSearchType(searchType);
        p.setSearchText(searchText);

        log.info("get-req: {}", p);
        List<CustomerGetRes> res = service.selCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }





    @PutMapping
    @Operation(summary="고객정보 수정")
    public MyResponse<Integer> upCustomer(@RequestBody CustomerPutReq p){

        int response=service.upCustomer(p);

        return new MyResponse<>("고객 정보 수정 완료",response);
    }

    @DeleteMapping
    @Operation(summary="고객정보 삭제")
    public MyResponse<Integer> delCustomer(@ParameterObject CustomerDelReq p){
        int response=service.delCustomer(p);

        return new MyResponse<>(p.getCustId()+"고객 정보 삭제 완료",response);

    }


}
