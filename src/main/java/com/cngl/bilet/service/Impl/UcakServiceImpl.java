package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.UcakRequestDto;
import com.cngl.bilet.dto.UcakResponseDto;
import com.cngl.bilet.entity.Ucak;
import com.cngl.bilet.repository.UcakRepository;
import com.cngl.bilet.repository.UrunRepository;
import com.cngl.bilet.service.UcakService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class UcakServiceImpl implements UcakService {

    private final UcakRepository ucakRepository;
    private final UrunRepository urunRepository;
    private final ModelMapper modelMapper;

    public UcakServiceImpl(
        UcakRepository ucakRepository,
        UrunRepository urunRepository,
        ModelMapper modelMapper
        ) {
        this.ucakRepository=ucakRepository;
        this.urunRepository=urunRepository;
        this.modelMapper = modelMapper;
    }

    public List<UcakResponseDto> tumunuGetir(){
        return modelMapper.map(ucakRepository.findAll(),
            new TypeToken<List<UcakResponseDto>>() {}.getType());
    }
    
    public UcakResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(ucakRepository.findById(id).orElseThrow(()-> new Exception("ff")), UcakResponseDto.class);
    }

    public UcakResponseDto kaydet(UcakRequestDto ucakRequestDto){

        Ucak ucak=modelMapper.map(ucakRequestDto, Ucak.class) ;
        if(!ucakRequestDto.getUrunId().isEmpty())
        ucak.setUrunler(urunRepository.findAllById(ucakRequestDto.getUrunId()));
  
        return modelMapper.map(ucakRepository.save(ucak), UcakResponseDto.class);
    }

    public UcakResponseDto guncelle(UcakRequestDto ucakRequestDto) throws Exception{

        Ucak ucak=ucakRepository.findById(ucakRequestDto.getId()).
                orElseThrow(()->new Exception("id' li urun bulunamadı"));
        ucak.setUrunler(urunRepository.findAllById(ucakRequestDto.getUrunId()));
        ucak.setIsim(ucakRequestDto.getIsim());
        ucak.setHostesSayisi(ucakRequestDto.getHostesSayisi());
        ucak.setKmBasinaBakimMaliyeti(ucakRequestDto.getKmBasinaBakimMaliyeti());
        ucak.setPilotSayisi(ucakRequestDto.getPilotSayisi());
        return modelMapper.map(ucakRepository.save(ucak), UcakResponseDto.class);
    }

    public void sil(Long id) throws Exception {
        ucakRepository.delete(
            ucakRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
   
}