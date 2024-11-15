package com.green.madang.common.model;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition( // swagger 화면의 이름을 수정하는 법
        info = @Info(
                title="마당서점",
                description = "Madang API",
                version = "v0.0.1"

        )

)
public class SwaggerConfiguration {

}
