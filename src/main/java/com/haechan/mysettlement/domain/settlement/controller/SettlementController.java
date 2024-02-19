package com.haechan.mysettlement.domain.settlement.controller;

import com.haechan.mysettlement.domain.settlement.service.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/settlement")
@RequiredArgsConstructor
public class SettlementController {

    private final SettlementService settlementService;

    // 특정달 수익에 대한 정산
    // 유통사 -> 가창자 -> 제작사 -> 본사 순
    @GetMapping("/{date}")
    public void calculate(@PathVariable(name="date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        settlementService.calculate(date);
    }

    // 특정월 특정 유통사의 수익
    @GetMapping("/member")
    public Double getDistributorSettlement(
            @RequestParam("type") Long type,
            @RequestParam("memberid") Long memberId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return settlementService.getDistributorSettlement(type, memberId, date);
    }
}