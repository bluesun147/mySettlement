package com.haechan.member.global.feign;

import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    // https://velog.io/@mrcocoball2/Spring-Cloud-Spring-Cloud-OpenFeign-기본-개념-및-활용
    // Ribbon 로드 밸런서를 사용하는 것이 기본값이라 이 부분을 null로 처리
    // 처리하지 않을 경우 아래의 오류 메시지 출력
    // No Feign Client for loadBalancing defined. Did you forget to include spring-cloud-starter-loadbalancer?
    @Bean
    public Client feignClient() {
        return new Client.Default(null, null);
    }
}