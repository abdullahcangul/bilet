package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.BiletRequestDto;
import com.cngl.bilet.dto.BiletResponseDto;
import com.cngl.bilet.dto.EngelliRotaResponseDto;
import com.cngl.bilet.entity.Bilet;
import com.cngl.bilet.repository.BiletRepository;
import com.cngl.bilet.repository.KoltukRepository;
import com.cngl.bilet.repository.MusteriRepository;
import com.cngl.bilet.repository.SeferRepository;
import com.cngl.bilet.service.BiletService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class BiletServiceImpl implements BiletService {

    private final BiletRepository biletRepository;
    private final MusteriRepository musteriRepository;
    private final SeferRepository seferRepository;
    private final KoltukRepository koltukRepository;
    private final ModelMapper modelMapper;

    public BiletServiceImpl(
        BiletRepository biletRepository,
        MusteriRepository musteriRepository,
        SeferRepository seferRepository,
        KoltukRepository koltukRepository,
        ModelMapper modelMapper) {
            this.biletRepository=biletRepository;
            this.musteriRepository=musteriRepository;
            this.seferRepository=seferRepository;
            this.koltukRepository=koltukRepository;
            this.modelMapper = modelMapper;
    }

    public List<BiletResponseDto> tumunuGetir(){
        return modelMapper.map(biletRepository.findAll(),
            new TypeToken<List<EngelliRotaResponseDto>>() {}.getType());
    }
    
    public BiletResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(biletRepository.findById(id).orElseThrow(()-> new Exception("ff")), BiletResponseDto.class);
    }

    public BiletResponseDto pnrYeGoreGetir(String pnr) throws Exception {
        return modelMapper.
            map(biletRepository.findByPnr(pnr).orElseThrow(()-> new Exception("ff")), BiletResponseDto.class);
    }

    public BiletResponseDto kaydet(BiletRequestDto biletRequestDto) throws Exception{
        
        Bilet bilet=modelMapper.map(biletRequestDto,Bilet.class);
        bilet= biletBagimliliklariniAta(bilet,biletRequestDto);
        return modelMapper.map(biletRepository.
            save(bilet),BiletResponseDto.class);
    }

    public BiletResponseDto guncelle(BiletRequestDto biletRequestDto) throws Exception{
        
        Bilet bilet=biletRepository.findById(biletRequestDto.getId()).
            orElseThrow(()->new Exception("Güncellenecek bilet bulunamadı"));
        bilet= biletBagimliliklariniAta(bilet,biletRequestDto);
        return modelMapper.map(biletRepository.
            save(bilet),BiletResponseDto.class);
    }

    private Bilet biletBagimliliklariniAta(Bilet bilet,BiletRequestDto biletRequestDto) throws Exception{
        bilet.setMusteri(musteriRepository.findById(biletRequestDto.getMusteriId()).
            orElseThrow(()->new Exception("Musteri bulunamadı")));
        bilet.setSefer(seferRepository.findById(biletRequestDto.getSeferId()).
            orElseThrow(()->new Exception("Sefer bilgisine ulasılamadı")));
        bilet.setKoltuk(koltukRepository.findById(biletRequestDto.getKoltukId()).
            orElseThrow(()->new Exception("Koltuk bilgisine ulasılamadı")));
        return bilet;
    }

    public Boolean aktifPasifEt(Long id) throws Exception {
        Bilet bilet=biletRepository.findById(id).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı"));
        bilet.setAktifMi(bilet.getAktifMi()?false:true);
        return bilet.getAktifMi();
    }

}