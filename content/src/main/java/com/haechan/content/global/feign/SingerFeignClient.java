package com.haechan.content.global.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// name : 통신할 서비스의 Eureka 등록 이름
// path : RequestMapping의 value와 동일'
// FeignClient끼리 name 같으면 contextId로 구분해야 함
@FeignClient(name = "member-service", contextId = "feignClientForSinger", path = "/singer")
public interface SingerFeignClient {

    // FeintClient 설정해주면 마치 자신의 API 인것처럼 정의 가능. 세부 구현은 x
    @GetMapping
    SingerFeignResponse findSingerById(@RequestParam(value = "memberId") Long memberId);
}