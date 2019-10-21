package com.cngl.bilet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.cngl.bilet.dto.SeferRequestDto;
import com.cngl.bilet.dto.SeferResponseDto;
import com.cngl.bilet.dto.SeferSorguRequestDto;
import com.cngl.bilet.entity.EngelliRota;
import com.cngl.bilet.entity.Sefer;
import com.cngl.bilet.repository.EngelliRotaRepository;
import com.cngl.bilet.repository.HavalimaniRepository;
import com.cngl.bilet.repository.HavayoluRepository;
import com.cngl.bilet.repository.SeferRepository;
import com.cngl.bilet.repository.TakvimRepository;
import com.cngl.bilet.repository.UcakRepository;
import com.cngl.bilet.service.SeferService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class SeferServiceImpl implements SeferService {

    
    private final SeferRepository seferRepository;
    private final HavayoluRepository havayoluRepository;
    private final HavalimaniRepository havalimaniRepository;
    private final TakvimRepository takvimRepository;
    private final UcakRepository ucakRepository;
    private final EngelliRotaRepository engelliRotaRepository;
    private final ModelMapper modelMapper;

    public SeferServiceImpl(
        SeferRepository seferRepository,
        HavayoluRepository havayoluRepository,
        HavalimaniRepository havalimaniRepository,
        TakvimRepository takvimRepository,
        UcakRepository ucakRepository,
        EngelliRotaRepository engelliRotaRepository,
        ModelMapper modelMapper) {
            this.seferRepository=seferRepository;
            this.modelMapper = modelMapper;
            this.havayoluRepository=havayoluRepository;
            this.havalimaniRepository=havalimaniRepository;
            this.takvimRepository=takvimRepository;
            this.engelliRotaRepository=engelliRotaRepository;
            this.ucakRepository=ucakRepository;
    }

    public List<SeferResponseDto> tumunuGetir(){
        return modelMapper.map(seferRepository.findAll(),
            new TypeToken<List<SeferResponseDto>>() {}.getType());
    }
    
    public SeferResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(seferRepository.findById(id).orElseThrow(()-> new Exception("ff")), SeferResponseDto.class);
    }

    public List<SeferResponseDto> seferFitresi(SeferSorguRequestDto seferSorguRequestDto){
        
        List<Sefer> seferler=seferRepository.findAll().stream().filter(x->{
            Boolean inisHavalimaniMi=x.getInisHavalimani().getId()==seferSorguRequestDto.getInishavalimaniId();
            Boolean kakisHavalimaniMi=x.getKalkisHavalimani().getId()==seferSorguRequestDto.getKalkisHavalimaniId();
            Boolean zamanAyniMi=x.getTakvim().getKalkisZamanı()==seferSorguRequestDto.getKalkisZamanı();
            return (inisHavalimaniMi && kakisHavalimaniMi && zamanAyniMi);

        }).collect(Collectors.toList()); 
        return modelMapper.map(seferler,new TypeToken<List<SeferResponseDto>>() {}.getType());
    }

    public SeferResponseDto kaydet(SeferRequestDto seferRequestDto) throws Exception {
        seferEngelliMiKontrol(seferRequestDto);
        Sefer sefer=modelMapper.map(seferRequestDto,Sefer.class);
        sefer=seferBagimlilikAta(seferRequestDto,sefer);
        return modelMapper.map(seferRepository.
            save(sefer),SeferResponseDto.class);
    }

    private void seferEngelliMiKontrol(SeferRequestDto seferRequestDto) throws Exception{
         engelliRotaRepository
            .findByKalkisHavaAlaniIdAndVarisHavaAlaniId(seferRequestDto.getKalkisHavalimaniId(),seferRequestDto.getInishavalimaniId())
            .orElseThrow(()->new Exception("Engelli Rota Bulundu"));
    }
        
    public SeferResponseDto guncelle(SeferRequestDto seferRequestDto) throws Exception {
        Sefer sefer=seferRepository.findById(seferRequestDto.getId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı"));
        sefer=seferBagimlilikAta(seferRequestDto,sefer);
        return modelMapper.map(seferRepository.
            save(modelMapper.map(seferRequestDto,Sefer.class)),SeferResponseDto.class);
    }

    private Sefer seferBagimlilikAta(SeferRequestDto seferRequestDto,Sefer sefer) throws Exception {
        sefer.setHavayolu(havayoluRepository.findById(seferRequestDto.getHavayoluId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı")));
        sefer.setInisHavalimani(havalimaniRepository.findById(seferRequestDto.getInishavalimaniId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı")));
        sefer.setKalkisHavalimani(havalimaniRepository.findById(seferRequestDto.getKalkisHavalimaniId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı")));
        sefer.setTakvim(takvimRepository.findById(seferRequestDto.getTakvimId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı")));
        sefer.setUcak(ucakRepository.findById(seferRequestDto.getUcakId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı")));
        return sefer;
    }

    public Boolean aktifPasifEt(Long id) throws Exception {

        Sefer sefer=seferRepository.findById(id)
            .orElseThrow(()->new Exception("Engelli Rota bulanamadı"));
        sefer.setAktifPasifEt(sefer.getAktifPasifEt()?false:true);
        return sefer.getAktifPasifEt();
    }
}