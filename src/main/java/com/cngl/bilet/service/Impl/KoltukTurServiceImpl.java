package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.KoltukTurRequestDto;
import com.cngl.bilet.dto.KoltukTurResponseDto;
import com.cngl.bilet.dto.KullaniciResponseDto;
import com.cngl.bilet.entity.KoltukTur;
import com.cngl.bilet.repository.KoltukTurRepository;
import com.cngl.bilet.service.KoltukTurService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KoltukTurServiceImpl implements KoltukTurService {

    private final KoltukTurRepository koltukTurRepository;
    private final ModelMapper modelMapper;

    public KoltukTurServiceImpl(KoltukTurRepository koltukTurRepository,ModelMapper modelMapper) {
        this.koltukTurRepository=koltukTurRepository;
        this.modelMapper = modelMapper;
    }

    public List<KoltukTurResponseDto> tumunuGetir(){
        return modelMapper.map(koltukTurRepository.findAll(),
            new TypeToken<List<KullaniciResponseDto>>() {}.getType());
    }
    
    public KoltukTurResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(koltukTurRepository.findById(id).orElseThrow(()-> new Exception("ff")), KoltukTurResponseDto.class);
    }

    public KoltukTurResponseDto kaydetVeyaGuncelle(KoltukTurRequestDto kullaniciRequestDto){
        return modelMapper.map(koltukTurRepository.
            save(modelMapper.map(kullaniciRequestDto,KoltukTur.class)),KoltukTurResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        koltukTurRepository.delete(
            koltukTurRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
    
}