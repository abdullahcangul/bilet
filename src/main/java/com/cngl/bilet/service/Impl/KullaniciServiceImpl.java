package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.KullaniciRequestDto;
import com.cngl.bilet.dto.KullaniciResponseDto;
import com.cngl.bilet.entity.Kullanici;
import com.cngl.bilet.repository.KullaniciRepository;
import com.cngl.bilet.service.KullaniciService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KullaniciServiceImpl implements KullaniciService {

    private final KullaniciRepository kullaniciRepository;
    private final ModelMapper modelMapper;

    public KullaniciServiceImpl(KullaniciRepository kullaniciRepository,ModelMapper modelMapper) {
        this.kullaniciRepository=kullaniciRepository;
        this.modelMapper = modelMapper;
    }

    public List<KullaniciResponseDto> tumunuGetir(){
        return modelMapper.map(kullaniciRepository.findAll(),
            new TypeToken<List<KullaniciResponseDto>>() {}.getType());
    }
    
    public KullaniciResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(kullaniciRepository.findById(id).orElseThrow(()-> new Exception("ff")), KullaniciResponseDto.class);
    }

    public KullaniciResponseDto kaydetVeyaGuncelle(KullaniciRequestDto kullaniciRequestDto){
        return modelMapper.map(kullaniciRepository.
            save(modelMapper.map(kullaniciRequestDto,Kullanici.class)),KullaniciResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        kullaniciRepository.delete(
            kullaniciRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
}