package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.KullaniciRequestDto;
import com.cngl.bilet.dto.KullaniciResponseDto;
import com.cngl.bilet.entity.Kullanici;
import com.cngl.bilet.repository.KullaniciRepository;
import com.cngl.bilet.repository.RolRepository;
import com.cngl.bilet.service.KullaniciService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KullaniciServiceImpl implements KullaniciService {

    private final KullaniciRepository kullaniciRepository;
    private final RolRepository rolRepository;
    private final ModelMapper modelMapper;

    public KullaniciServiceImpl(KullaniciRepository kullaniciRepository,ModelMapper modelMapper,RolRepository rolRepository) {
        this.kullaniciRepository=kullaniciRepository;
        this.rolRepository=rolRepository;
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

    public KullaniciResponseDto kaydet(KullaniciRequestDto kullaniciRequestDto){

        Kullanici kullanici=modelMapper.map(kullaniciRequestDto,Kullanici.class);
        if(!kullaniciRequestDto.getRolId().isEmpty())
        kullanici.setRoller(rolRepository.findAllById(kullaniciRequestDto.getRolId()));
        
        return modelMapper.map(kullaniciRepository.save(kullanici), KullaniciResponseDto.class);
    }

    public KullaniciResponseDto guncelle(KullaniciRequestDto kullaniciRequestDto) throws Exception {

        Kullanici kullanici=kullaniciRepository.findById(kullaniciRequestDto.getId()).
                orElseThrow(()->new Exception("id' li urun bulunamadı"));
        kullanici.setRoller(rolRepository.findAllById(kullaniciRequestDto.getRolId()));
        kullanici.setSifre(kullaniciRequestDto.getSifre());
        return modelMapper.map(kullaniciRepository.save(kullanici), KullaniciResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        kullaniciRepository.delete(
            kullaniciRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
}