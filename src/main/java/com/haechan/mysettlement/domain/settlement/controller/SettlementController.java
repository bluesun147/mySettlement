package com.haechan.mysettlement.domain.settlement.controller;

import com.haechan.mysettlement.domain.distributor.dto.DistributorHtmlSelectDto;
import com.haechan.mysettlement.domain.distributor.service.DistributorService;
import com.haechan.mysettlement.domain.producer.dto.ProducerHtmlSelectDto;
import com.haechan.mysettlement.domain.producer.service.ProducerService;
import com.haechan.mysettlement.domain.settlement.dto.MemberType;
import com.haechan.mysettlement.domain.settlement.entity.Settlement;
import com.haechan.mysettlement.domain.settlement.service.SettlementService;
import com.haechan.mysettlement.domain.singer.dto.SingerHtmlSelectDto;
import com.haechan.mysettlement.domain.singer.service.SingerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.haechan.mysettlement.domain.settlement.dto.MemberType.*;

@Slf4j
//@RestController
@Controller
@RequestMapping("/settlement")
@RequiredArgsConstructor
public class SettlementController {

    private final SettlementService settlementService;
    private final DistributorService distributorService;
    private final SingerService singerService;
    private final ProducerService producerService;

    @GetMapping("/list")
    public String getSettlementList(Model model) {
        List<Settlement> settlementList = settlementService.getSettlementList();
        model.addAttribute("settlementList", settlementList);
        return "/settlement/settlementList";
    }

    @GetMapping("")
    public String index(Model model) {
        List<Integer> years = Arrays.asList(2020, 2021, 2022, 2023, 2024, 2025);
        List<Integer> months = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<MemberType> types = Arrays.asList(DISTRIBUTOR, SINGER, PRODUCER, COMPANY);
        List<String> memberIds = Arrays.asList("멤버선택");

        model.addAttribute("years", years);
        model.addAttribute("months", months);
        model.addAttribute("types", types);
        model.addAttribute("memberIds", memberIds);

        List<DistributorHtmlSelectDto> distributorList = distributorService.getDistributorList();
        List<Long> distributorIdList = distributorList.stream().map(DistributorHtmlSelectDto::getId).toList();

        List<SingerHtmlSelectDto> singerList = singerService.getSingerList();
        List<Long> singerIdList = singerList.stream().map(SingerHtmlSelectDto::getId).toList();

        List<ProducerHtmlSelectDto> producerList = producerService.getProducerList();
        List<Long> producerIdList = producerList.stream().map(ProducerHtmlSelectDto::getId).toList();

        model.addAttribute("distributorIdList", distributorIdList);
        model.addAttribute("singerIdList", singerIdList);
        model.addAttribute("producerIdList", producerIdList);

        return "/settlement/settlementIndex";
    }

    @PostMapping("/result")
    public String result(@RequestParam("year") int year, @RequestParam("month") String month, Model model) {
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        return "settlement/result";
    }

    // 특정월 특정 유통사의 수익
    @GetMapping("/member")
    public String getDistributorSettlement(
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("type") MemberType type,
            @RequestParam("memberId") Long memberId,
            Model model) {

        // 해당 월 정산금
        Double membersSettlement = settlementService.getMembersSettlement(year, month, type, memberId);
        log.info("membersSettlement = {}", membersSettlement);


        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("type", type);
        model.addAttribute("memberId", memberId);
        model.addAttribute("membersSettlement", membersSettlement);

        return "settlement/result";
    }
}