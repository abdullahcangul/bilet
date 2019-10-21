package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.HavayoluRequestDto;
import com.cngl.bilet.dto.HavayoluResponseDto;
import com.cngl.bilet.dto.KisiResponseDto;
import com.cngl.bilet.entity.Havayolu;
import com.cngl.bilet.repository.EngelliRotaRepository;
import com.cngl.bilet.repository.HavayoluRepository;
import com.cngl.bilet.service.HavayoluService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class HavayoluServiceImpl implements HavayoluService {

    private final HavayoluRepository havayoluRepository;
    private final EngelliRotaRepository engelliRotaRepository;
    private final ModelMapper modelMapper;

    public HavayoluServiceImpl(
        HavayoluRepository havayoluRepository,
        EngelliRotaRepository engelliRotaRepository,
        ModelMapper modelMapper
        ) {
        this.havayoluRepository=havayoluRepository;
        this.engelliRotaRepository=engelliRotaRepository;
        this.modelMapper = modelMapper;
    }

    public List<HavayoluResponseDto> tumunuGetir(){
        return modelMapper.map(havayoluRepository.findAll(),
            new TypeToken<List<KisiResponseDto>>() {}.getType());
    }
    
    public HavayoluResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(havayoluRepository.findById(id).orElseThrow(()-> new Exception("ff")), HavayoluResponseDto.class);
    }

    public HavayoluResponseDto kaydet(HavayoluRequestDto havayoluRequestDto){
        Havayolu havayolu=modelMapper.map(havayoluRequestDto,Havayolu.class);
        if(!havayoluRequestDto.getEngelliRotaId().isEmpty())
        havayolu.setEngelliRotalar(engelliRotaRepository.findAllById(havayoluRequestDto.getEngelliRotaId()));
        //Todo:Composite Key e bak
        return modelMapper.map(havayoluRepository.
            save(havayolu),HavayoluResponseDto.class);
    }

    public HavayoluResponseDto guncelle(HavayoluRequestDto havayoluRequestDto) throws Exception {
        Havayolu havayolu=havayoluRepository.findById(havayoluRequestDto.getId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı"));    
        havayolu.setEngelliRotalar(engelliRotaRepository.findAllById(havayoluRequestDto.getEngelliRotaId()));
        havayolu.setIsim(havayoluRequestDto.getIsim());
        return modelMapper.map(havayoluRepository.
            save(havayolu),HavayoluResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        havayoluRepository.delete(
            havayoluRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
    
}