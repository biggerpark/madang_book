package com.green.madang.manager.customer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPutReq {
    private int custId;
    @Schema(title="고객이름",example = "홍길동",requiredMode =Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(title="고객주소",example = "서울시 성북구 행당동 111-1",requiredMode =Schema.RequiredMode.REQUIRED)
    private String address;
    @Schema(title="고객 휴대폰 번호",description = "'-'를 반드시 입력해주세요", example = "010-0000-0000",requiredMode =Schema.RequiredMode.REQUIRED)
    private String phone;
}
