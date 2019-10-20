package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.HavalimaniResponseDto;
import com.cngl.bilet.dto.RolRequestDto;
import com.cngl.bilet.dto.RolResponseDto;
import com.cngl.bilet.entity.Rol;
import com.cngl.bilet.repository.KullaniciRepository;
import com.cngl.bilet.repository.RolRepository;
import com.cngl.bilet.service.RolService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final KullaniciRepository kullaniciRepository;
    private final ModelMapper modelMapper;

    public RolServiceImpl(
        RolRepository rolRepository,
        KullaniciRepository kullaniciRepository,
        ModelMapper modelMapper
        ) {
            this.kullaniciRepository=kullaniciRepository;
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

    public RolResponseDto kaydet(RolRequestDto rolRequestDto){

        Rol rol=modelMapper.map(rolRequestDto,Rol.class);
        if(!rolRequestDto.getKullaniciId().isEmpty())
        rol.setKulanicilar(kullaniciRepository.findAllById(rolRequestDto.getKullaniciId()));
        
        return modelMapper.map(rolRepository.save(rol), RolResponseDto.class);
    }

    public RolResponseDto guncelle(RolRequestDto rolRequestDto) throws Exception {

        Rol rol=rolRepository.findById(rolRequestDto.getId()).
                orElseThrow(()->new Exception("id' li urun bulunamadı"));
        rol.setKulanicilar(kullaniciRepository.findAllById(rolRequestDto.getKullaniciId()));
        rol.setIsim(rolRequestDto.getIsim());
        return modelMapper.map(rolRepository.save(rol), RolResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        rolRepository.delete(
            rolRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
}