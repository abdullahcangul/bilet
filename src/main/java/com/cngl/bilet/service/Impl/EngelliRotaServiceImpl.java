package com.cngl.bilet.service.Impl;

import java.util.List;

import com.cngl.bilet.dto.EngelliRotaRequestDto;
import com.cngl.bilet.dto.EngelliRotaResponseDto;
import com.cngl.bilet.entity.EngelliRota;
import com.cngl.bilet.repository.EngelliRotaRepository;
import com.cngl.bilet.service.EngelliRotaService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class EngelliRotaServiceImpl implements EngelliRotaService{
    
    private final EngelliRotaRepository engelliRotaRepository;
    private final ModelMapper modelMapper;

    public EngelliRotaServiceImpl(EngelliRotaRepository engelliRotaRepository,ModelMapper modelMapper) {
        this.engelliRotaRepository=engelliRotaRepository;
        this.modelMapper = modelMapper;
    }

    public List<EngelliRotaResponseDto> getAll(){
        return modelMapper.map(engelliRotaRepository.findAll(),
            new TypeToken<List<EngelliRotaResponseDto>>() {}.getType());
    }
    
    public EngelliRotaResponseDto findById(Long id) throws Exception {

        return modelMapper.
            map(engelliRotaRepository.findById(id).orElseThrow(()-> new Exception("ff")), EngelliRotaResponseDto.class);
    }

    public EngelliRotaResponseDto saveOrUpdate(EngelliRotaRequestDto engelliRotaRequestDto){
        return modelMapper.map(engelliRotaRepository.
            save(modelMapper.map(engelliRotaRequestDto,EngelliRota.class)),EngelliRotaResponseDto.class);
    }

    public void delete(Long id) throws Exception {
        engelliRotaRepository.delete(
            engelliRotaRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
   

}