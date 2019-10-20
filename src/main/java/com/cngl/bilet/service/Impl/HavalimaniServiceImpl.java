package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.HavalimaniRequestDto;
import com.cngl.bilet.dto.HavalimaniResponseDto;
import com.cngl.bilet.entity.Havalimani;
import com.cngl.bilet.repository.HavalimaniRepository;
import com.cngl.bilet.service.HavalimaniService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class HavalimaniServiceImpl implements HavalimaniService {

    private final HavalimaniRepository havalimaniRepository;
    private final ModelMapper modelMapper;

    public HavalimaniServiceImpl(HavalimaniRepository havalimaniRepository,ModelMapper modelMapper) {
        this.havalimaniRepository=havalimaniRepository;
        this.modelMapper = modelMapper;
    }

    public List<HavalimaniResponseDto> tumunuGetir(){
        return modelMapper.map(havalimaniRepository.findAll(),
            new TypeToken<List<HavalimaniResponseDto>>() {}.getType());
    }
    
    public HavalimaniResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(havalimaniRepository.findById(id).orElseThrow(()-> new Exception("ff")), HavalimaniResponseDto.class);
    }

    public HavalimaniResponseDto kaydet(HavalimaniRequestDto havalimaniRequestDto){
        return modelMapper.map(havalimaniRepository.
            save(modelMapper.map(havalimaniRequestDto,Havalimani.class)),HavalimaniResponseDto.class);
    }

    public HavalimaniResponseDto guncelle(HavalimaniRequestDto havalimaniRequestDto) throws Exception {
        Havalimani havalimani=havalimaniRepository.findById(havalimaniRequestDto.getId()).
            orElseThrow(()->new Exception());
        havalimani.setAdres(havalimaniRequestDto.getAdres());
        havalimani.setIsim(havalimaniRequestDto.getIsim());

        return modelMapper.map(havalimaniRepository.
            save(havalimani),HavalimaniResponseDto.class);
    }

    public Boolean aktifPasifEt(Long id) throws Exception {
        Havalimani havalimani=havalimaniRepository.findById(id).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı"));
        havalimani.setAktifMi(havalimani.getAktifMi()?true:false);
        return havalimani.getAktifMi();
        
    }
    
}