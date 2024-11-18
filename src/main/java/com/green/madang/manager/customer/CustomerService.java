package com.green.madang.manager.customer;

import com.green.madang.manager.customer.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper mapper;

    public int insCustomer(CustomerPostReq p){
        return mapper.insCustomer(p);
    }
    public List<CustomerGetRes> selCustomerList(CustomerGetReq p){

        p.setStartIdx((p.getPage()-1)*p.getSize());

        return mapper.selCustomerList(p);
    }

    public int upCustomer(CustomerPutReq p){
        return mapper.upCustomer(p);
    }

    public int delCustomer(CustomerDelReq p){
        return mapper.delCustomer(p);
    }
}
