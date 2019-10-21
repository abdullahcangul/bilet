package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.EngelliRotaRequestDto;
import com.cngl.bilet.dto.EngelliRotaResponseDto;
import com.cngl.bilet.entity.EngelliRota;
import com.cngl.bilet.repository.EngelliRotaRepository;
import com.cngl.bilet.repository.HavayoluRepository;
import com.cngl.bilet.service.EngelliRotaService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class EngelliRotaServiceImpl implements EngelliRotaService{
    
    private final EngelliRotaRepository engelliRotaRepository;
    private final HavayoluRepository havayoluRepository;
    private final ModelMapper modelMapper;

    public EngelliRotaServiceImpl(EngelliRotaRepository engelliRotaRepository,
    HavayoluRepository havayoluRepository,
    ModelMapper modelMapper) {
        this.engelliRotaRepository=engelliRotaRepository;
        this.havayoluRepository=havayoluRepository;
        this.modelMapper = modelMapper;
    }

    public List<EngelliRotaResponseDto> tumunuGetir(){
        return modelMapper.map(engelliRotaRepository.findAll(),
            new TypeToken<List<EngelliRotaResponseDto>>() {}.getType());
    }
    
    public EngelliRotaResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(engelliRotaRepository.findById(id).orElseThrow(()-> new Exception("ff")), EngelliRotaResponseDto.class);
    }
    

    public EngelliRotaResponseDto kaydetVeyaGuncelle(EngelliRotaRequestDto engelliRotaRequestDto){
        return modelMapper.map(engelliRotaRepository.
            save(modelMapper.map(engelliRotaRequestDto,EngelliRota.class)),EngelliRotaResponseDto.class);
    }

    public EngelliRotaResponseDto kaydet(EngelliRotaRequestDto engelliRotaRequestDto){
        EngelliRota engelliRota=modelMapper.map(engelliRotaRequestDto,EngelliRota.class);
        if(!engelliRotaRequestDto.getHavalimaniId().isEmpty())
        engelliRota.setHavayollari(havayoluRepository.findAllById(engelliRotaRequestDto.getHavalimaniId()));
        return modelMapper.map(engelliRotaRepository.save(engelliRota),EngelliRotaResponseDto.class);
    }

    public EngelliRotaResponseDto guncelle(EngelliRotaRequestDto engelliRotaRequestDto)throws Exception{
        EngelliRota engelliRota=engelliRotaRepository.findById(engelliRotaRequestDto.getId())
            .orElseThrow(()->new Exception("Engelli Rota bulanamadı"));
        engelliRota.setHavayollari(havayoluRepository.findAllById(engelliRotaRequestDto.getHavalimaniId()));
        return modelMapper.map(engelliRotaRepository.
            save(modelMapper.map(engelliRotaRequestDto,EngelliRota.class)),EngelliRotaResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        engelliRotaRepository.delete(
            engelliRotaRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }

}