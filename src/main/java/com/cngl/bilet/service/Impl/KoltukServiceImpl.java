package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.KoltukRequestDto;
import com.cngl.bilet.dto.KoltukResponseDto;
import com.cngl.bilet.entity.Koltuk;
import com.cngl.bilet.repository.KoltukRepository;
import com.cngl.bilet.repository.SeferRepository;
import com.cngl.bilet.service.KoltukService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KoltukServiceImpl implements KoltukService {

    private final KoltukRepository koltukRepository;
    private final SeferRepository seferRepository;
    private final ModelMapper modelMapper;

    public KoltukServiceImpl(
        KoltukRepository koltukRepository,
        SeferRepository seferRepository,
        ModelMapper modelMapper) {
            this.koltukRepository=koltukRepository;
            this.seferRepository=seferRepository;
            this.modelMapper = modelMapper;
    }

    public List<KoltukResponseDto> tumunuGetir(){
        return modelMapper.map(koltukRepository.findAll(),
            new TypeToken<List<KoltukResponseDto>>() {}.getType());
    }
    
    public KoltukResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(koltukRepository.findById(id).orElseThrow(()-> new Exception("ff")), KoltukResponseDto.class);
    }

    public KoltukResponseDto kaydet(KoltukRequestDto kullaniciRequestDto) throws Exception {
    
        Koltuk koltuk= modelMapper.map(kullaniciRequestDto,Koltuk.class);
        koltuk=koltugaSeferAta(koltuk,kullaniciRequestDto);
        return modelMapper.map(koltukRepository.
            save(modelMapper.map(kullaniciRequestDto,Koltuk.class)),KoltukResponseDto.class);
    }

    public KoltukResponseDto guncelle(KoltukRequestDto kullaniciRequestDto) throws Exception {
        Koltuk koltuk= koltukRepository.findById(kullaniciRequestDto.getId())
            .orElseThrow(()->new Exception(""));
        koltuk=koltugaSeferAta(koltuk,kullaniciRequestDto);
        return modelMapper.map(koltukRepository.
            save(modelMapper.map(kullaniciRequestDto,Koltuk.class)),KoltukResponseDto.class);
    }

    private Koltuk koltugaSeferAta(Koltuk koltuk,KoltukRequestDto kullaniciRequestDto)throws Exception{
        koltuk.setSefer(seferRepository.findById(kullaniciRequestDto.getSeferId()).
            orElseThrow(()->new Exception("sefer atanamadı")));
        return koltuk;
    }

    public void sil(Long id) throws Exception {
        koltukRepository.delete(
            koltukRepository.findById(id).orElseThrow(()->new Exception("koltuk bulunamadı"))
        );
    }
    
}