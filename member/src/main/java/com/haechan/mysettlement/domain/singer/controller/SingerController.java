package com.haechan.mysettlement.domain.singer.controller;

import com.haechan.mysettlement.domain.producer.feign.ProducerFeignResponse;
import com.haechan.mysettlement.domain.singer.dto.SingerDto;
import com.haechan.mysettlement.domain.singer.feign.SingerFeignResponse;
import com.haechan.mysettlement.domain.singer.service.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/singer")
@RequiredArgsConstructor
public class SingerController {

    private final SingerService singerService;

    @PostMapping("/")
    public void register(@RequestBody SingerDto singerDto) {
        singerService.register(singerDto);
    }

    // ost등 다른 서버에서 producer 정보 API 통해 가져와야 함
    // memberId와 singerId가 다를 수 있다고 가정 (지금은 같음)
    @GetMapping
    public SingerFeignResponse findSingerById(@RequestParam("memberId") Long memberId) {
        return singerService.findSingerById(memberId);
    }
}
