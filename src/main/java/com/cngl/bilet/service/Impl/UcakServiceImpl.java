package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.UcakRequestDto;
import com.cngl.bilet.dto.UcakResponseDto;
import com.cngl.bilet.entity.Ucak;
import com.cngl.bilet.repository.UcakRepository;
import com.cngl.bilet.service.UcakService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class UcakServiceImpl implements UcakService {

    private final UcakRepository ucakRepository;
    private final ModelMapper modelMapper;

    public UcakServiceImpl(UcakRepository ucakRepository,ModelMapper modelMapper) {
        this.ucakRepository=ucakRepository;
        this.modelMapper = modelMapper;
    }

    public List<UcakResponseDto> tumunuGetir(){
        return modelMapper.map(ucakRepository.findAll(),
            new TypeToken<List<UcakResponseDto>>() {}.getType());
    }
    
    public UcakResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(ucakRepository.findById(id).orElseThrow(()-> new Exception("ff")), UcakResponseDto.class);
    }

    public UcakResponseDto kaydetVeyaGuncelle(UcakRequestDto ucakRequestDto){
        return modelMapper.map(ucakRepository.
            save(modelMapper.map(ucakRequestDto,Ucak.class)),UcakResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        ucakRepository.delete(
            ucakRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
   
}