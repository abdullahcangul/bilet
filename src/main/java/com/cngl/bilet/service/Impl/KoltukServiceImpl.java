package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.KoltukRequestDto;
import com.cngl.bilet.dto.KoltukResponseDto;
import com.cngl.bilet.entity.Koltuk;
import com.cngl.bilet.repository.KoltukRepository;
import com.cngl.bilet.repository.UcakRepository;
import com.cngl.bilet.service.KoltukService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KoltukServiceImpl implements KoltukService {

    private final KoltukRepository koltukRepository;
    private final UcakRepository ucakRepository;
    private final ModelMapper modelMapper;

    public KoltukServiceImpl(
        KoltukRepository koltukRepository,
        UcakRepository ucakRepository,
        ModelMapper modelMapper) {
            this.koltukRepository=koltukRepository;
            this.ucakRepository=ucakRepository;
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
        koltuk=koltugaUcakAta(koltuk,kullaniciRequestDto);
        return modelMapper.map(koltukRepository.
            save(modelMapper.map(kullaniciRequestDto,Koltuk.class)),KoltukResponseDto.class);
    }

    public KoltukResponseDto guncelle(KoltukRequestDto kullaniciRequestDto) throws Exception {
        Koltuk koltuk= koltukRepository.findById(kullaniciRequestDto.getId())
            .orElseThrow(()->new Exception(""));
        koltuk=koltugaUcakAta(koltuk,kullaniciRequestDto);
        return modelMapper.map(koltukRepository.
            save(modelMapper.map(kullaniciRequestDto,Koltuk.class)),KoltukResponseDto.class);
    }

    private Koltuk koltugaUcakAta(Koltuk koltuk,KoltukRequestDto kullaniciRequestDto)throws Exception{
        koltuk.setUcak(ucakRepository.findById(kullaniciRequestDto.getUcakId()).
            orElseThrow(()->new Exception("")));
        return koltuk;
    }

    public void sil(Long id) throws Exception {
        koltukRepository.delete(
            koltukRepository.findById(id).orElseThrow(()->new Exception("Engelli Rota bulanamadı"))
        );
    }
    
}