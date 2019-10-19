package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.KuponRequestDto;
import com.cngl.bilet.dto.KuponResponseDto;
import com.cngl.bilet.entity.Kupon;
import com.cngl.bilet.repository.KuponRepository;
import com.cngl.bilet.service.KuponService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KuponServiceImpl implements KuponService {

    private final KuponRepository kuponRepository;
    private final ModelMapper modelMapper;

    public KuponServiceImpl(KuponRepository kuponRepository,ModelMapper modelMapper) {
        this.kuponRepository=kuponRepository;
        this.modelMapper = modelMapper;
    }

    public List<KuponResponseDto> tumunuGetir(){
        return modelMapper.map(kuponRepository.findAll(),
            new TypeToken<List<KuponResponseDto>>() {}.getType());
    }
    
    public KuponResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(kuponRepository.findById(id).orElseThrow(()-> new Exception("ff")), KuponResponseDto.class);
    }

    public KuponResponseDto kaydetVeyaGuncelle(KuponRequestDto kuponRequestDto){
        return modelMapper.map(kuponRepository.
            save(modelMapper.map(kuponRequestDto,Kupon.class)),KuponResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        kuponRepository.delete(
            kuponRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
    
}