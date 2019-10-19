package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.UrunRequestDto;
import com.cngl.bilet.dto.UrunResponseDto;
import com.cngl.bilet.entity.Urun;
import com.cngl.bilet.repository.UrunRepository;
import com.cngl.bilet.service.UrunService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class UrunServiceImpl implements UrunService {

    private final UrunRepository urunRepository;
    private final ModelMapper modelMapper;

    public UrunServiceImpl(UrunRepository urunRepository, ModelMapper modelMapper) {
        this.urunRepository = urunRepository;
        this.modelMapper = modelMapper;
    }

    public List<UrunResponseDto> tumunuGetir() {
        return modelMapper.map(urunRepository.findAll(), new TypeToken<List<UrunResponseDto>>() {
        }.getType());
    }

    public UrunResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.map(urunRepository.findById(id).orElseThrow(() -> new Exception("ff")),
                UrunResponseDto.class);
    }

    public UrunResponseDto kaydetVeyaGuncelle(UrunRequestDto urunRequestDto) {
        return modelMapper.map(urunRepository.save(modelMapper.map(urunRequestDto, Urun.class)), UrunResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        urunRepository.delete(urunRepository.findById(id).orElseThrow(() -> new Exception("Engelli Rota bulanamadı")));
    }
    
}