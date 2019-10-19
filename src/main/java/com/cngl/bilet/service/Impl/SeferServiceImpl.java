package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.HavalimaniResponseDto;
import com.cngl.bilet.dto.SeferRequestDto;
import com.cngl.bilet.dto.SeferResponseDto;
import com.cngl.bilet.entity.Sefer;
import com.cngl.bilet.repository.SeferRepository;
import com.cngl.bilet.service.SeferService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class SeferServiceImpl implements SeferService {

    
    private final SeferRepository seferRepository;
    private final ModelMapper modelMapper;

    public SeferServiceImpl(SeferRepository seferRepository,ModelMapper modelMapper) {
        this.seferRepository=seferRepository;
        this.modelMapper = modelMapper;
    }

    public List<SeferResponseDto> tumunuGetir(){
        return modelMapper.map(seferRepository.findAll(),
            new TypeToken<List<HavalimaniResponseDto>>() {}.getType());
    }
    
    public SeferResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(seferRepository.findById(id).orElseThrow(()-> new Exception("ff")), SeferResponseDto.class);
    }

    public SeferResponseDto kaydetVeyaGuncelle(SeferRequestDto seferRequestDto){
        return modelMapper.map(seferRepository.
            save(modelMapper.map(seferRequestDto,Sefer.class)),SeferResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        seferRepository.delete(
            seferRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
}