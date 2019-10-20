package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.TakvimRequestDto;
import com.cngl.bilet.dto.TakvimResponseDto;
import com.cngl.bilet.entity.Takvim;
import com.cngl.bilet.repository.TakvimRepository;
import com.cngl.bilet.service.TakvimService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class TakvimServiceImpl implements TakvimService {

    
    private final TakvimRepository takvimRepository;
    private final ModelMapper modelMapper;

    public TakvimServiceImpl(TakvimRepository takvimRepository,ModelMapper modelMapper) {
        this.takvimRepository=takvimRepository;
        this.modelMapper = modelMapper;
    }

    public List<TakvimResponseDto> tumunuGetir(){
        return modelMapper.map(takvimRepository.findAll(),
            new TypeToken<List<TakvimResponseDto>>() {}.getType());
    }
    
    public TakvimResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(takvimRepository.findById(id).orElseThrow(()-> new Exception("ff")), TakvimResponseDto.class);
    }

    public TakvimResponseDto kaydet(TakvimRequestDto takvimRequestDto){
        return modelMapper.map(takvimRepository.
            save(modelMapper.map(takvimRequestDto,Takvim.class)),TakvimResponseDto.class);
    }

    public TakvimResponseDto guncelle(TakvimRequestDto takvimRequestDto) throws Exception {
       Takvim takvim=takvimRepository.findById(takvimRequestDto.getId()).orElseThrow(()-> new Exception("ff"));
       takvim.setKalkisZamanı(takvimRequestDto.getKalkisZamanı());
       takvim.setVarisZamani(takvimRequestDto.getVarisZamani());
       return modelMapper.map(takvimRepository.
            save(modelMapper.map(takvimRequestDto,Takvim.class)),TakvimResponseDto.class);
    }

    public Boolean aktifPasifEt(Long id) throws Exception {
        Takvim takvim=takvimRepository.findById(id).
            orElseThrow(()->new Exception("Takvim bilgisi bulanamadı"));
        takvim.setAktifMi(takvim.getAktifMi()?true:false);
        return takvim.getAktifMi();
    }
}