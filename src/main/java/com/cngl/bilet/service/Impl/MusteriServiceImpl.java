package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.HavalimaniResponseDto;
import com.cngl.bilet.dto.MusteriRequestDto;
import com.cngl.bilet.dto.MusteriResponseDto;
import com.cngl.bilet.entity.Musteri;
import com.cngl.bilet.repository.MusteriRepository;
import com.cngl.bilet.service.MusteriService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class MusteriServiceImpl implements MusteriService {
    
 private final MusteriRepository musteriRepository;
    private final ModelMapper modelMapper;

    public MusteriServiceImpl(MusteriRepository musteriRepository,ModelMapper modelMapper) {
        this.musteriRepository=musteriRepository;
        this.modelMapper = modelMapper;
    }

    public List<MusteriResponseDto> tumunuGetir(){
        return modelMapper.map(musteriRepository.findAll(),
            new TypeToken<List<HavalimaniResponseDto>>() {}.getType());
    }
    
    public MusteriResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(musteriRepository.findById(id).orElseThrow(()-> new Exception("ff")), MusteriResponseDto.class);
    }

    public MusteriResponseDto kaydetVeyaGuncelle(MusteriRequestDto musteriRequestDto){
        return modelMapper.map(musteriRepository.
            save(modelMapper.map(musteriRequestDto,Musteri.class)),MusteriResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        musteriRepository.delete(
            musteriRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
    
}