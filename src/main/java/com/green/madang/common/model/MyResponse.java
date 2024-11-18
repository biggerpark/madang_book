package com.green.madang.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RestController;

//응답할 때 사용하는 객체
@Getter
@Setter
@AllArgsConstructor // private 한 멤버필드에 값을 넣어주는 생성자 생성(모든 argument 에, final 이 붙었던 안 붙었던)
@ToString
public class MyResponse<T> {
    private String resultMessage;
    private T data;
}
