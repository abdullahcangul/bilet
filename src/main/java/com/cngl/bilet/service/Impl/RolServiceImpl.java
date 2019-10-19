package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.HavalimaniResponseDto;
import com.cngl.bilet.dto.RolRequestDto;
import com.cngl.bilet.dto.RolResponseDto;
import com.cngl.bilet.entity.Rol;
import com.cngl.bilet.repository.RolRepository;
import com.cngl.bilet.service.RolService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final ModelMapper modelMapper;

    public RolServiceImpl(RolRepository rolRepository,ModelMapper modelMapper) {
        this.rolRepository=rolRepository;
        this.modelMapper = modelMapper;
    }

    public List<RolResponseDto> tumunuGetir(){
        return modelMapper.map(rolRepository.findAll(),
            new TypeToken<List<HavalimaniResponseDto>>() {}.getType());
    }
    
    public RolResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(rolRepository.findById(id).orElseThrow(()-> new Exception("ff")), RolResponseDto.class);
    }

    public RolResponseDto kaydetVeyaGuncelle(RolRequestDto rolRequestDto){
        return modelMapper.map(rolRepository.
            save(modelMapper.map(rolRequestDto,Rol.class)),RolResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        rolRepository.delete(
            rolRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
}