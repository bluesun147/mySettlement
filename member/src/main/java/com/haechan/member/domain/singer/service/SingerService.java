package com.haechan.member.domain.singer.service;

import com.haechan.feign.dto.SingerFeignResponse;
import com.haechan.member.domain.singer.dto.SingerDto;
import com.haechan.member.domain.singer.dto.SingerHtmlSelectDto;
import com.haechan.member.domain.singer.entity.Singer;
import com.haechan.member.domain.singer.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SingerService {

    private final SingerRepository singerRepository;

    public Long register(SingerDto singerDto) {

        Singer singer = Singer.builder()
                .name(singerDto.getName())
                .build();

        return singerRepository.save(singer).getId();
    }

    public List<SingerHtmlSelectDto> getSingerList() {
        List<Singer> singerList = singerRepository.findAll();
        List<SingerHtmlSelectDto> singerDtoList = singerList.stream()
                .map(singer -> SingerHtmlSelectDto.builder()
                        .id(singer.getId())
                        .name(singer.getName())
                        .build()
                )
                .collect(Collectors.toList());
        return singerDtoList;
    }

    // ost등 다른 서버에서 singer 정보 API 통해 가져와야 함
    public SingerFeignResponse findSingerById(Long singerId) {
        Singer singer = singerRepository.findById(singerId).orElseThrow();
        return new SingerFeignResponse(singer.getId(), singer.getName());
    }

    public List<SingerFeignResponse> findAll() {
        List<Singer> singerList = singerRepository.findAll();

        List<SingerFeignResponse> singerFeignList = singerList.stream()
                .map(singer -> new SingerFeignResponse(singer.getId(), singer.getName()))
                .collect(Collectors.toList());

        return singerFeignList;
    }
}
