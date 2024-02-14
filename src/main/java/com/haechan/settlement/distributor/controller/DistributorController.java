package com.haechan.settlement.distributor.controller;

import com.haechan.settlement.distributor.dto.DistributorDto;
import com.haechan.settlement.distributor.service.DistributorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distributor")
@RequiredArgsConstructor
public class DistributorController {

    private final DistributorService distributorService;

    @PostMapping("/")
    public void register(@RequestBody DistributorDto distributorDto) {
        distributorService.register(distributorDto);
    }
}
