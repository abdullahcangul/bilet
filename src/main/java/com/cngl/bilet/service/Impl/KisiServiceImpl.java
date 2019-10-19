package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.KisiRequestDto;
import com.cngl.bilet.dto.KisiResponseDto;
import com.cngl.bilet.entity.Kisi;
import com.cngl.bilet.repository.KisiRepository;
import com.cngl.bilet.service.KisiService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KisiServiceImpl implements KisiService{

    private final KisiRepository kisiRepository;
    private final ModelMapper modelMapper;

    public KisiServiceImpl(KisiRepository kisiRepository,ModelMapper modelMapper) {
        this.kisiRepository=kisiRepository;
        this.modelMapper = modelMapper;
    }

    public List<KisiResponseDto> tumunuGetir(){
        return modelMapper.map(kisiRepository.findAll(),
            new TypeToken<List<KisiResponseDto>>() {}.getType());
    }
    
    public KisiResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(kisiRepository.findById(id).orElseThrow(()-> new Exception("ff")), KisiResponseDto.class);
    }

    public KisiResponseDto kaydetVeyaGuncelle(KisiRequestDto kisiRequestDto){
        return modelMapper.map(kisiRepository.
            save(modelMapper.map(kisiRequestDto,Kisi.class)),KisiResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        kisiRepository.delete(
            kisiRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
    
}