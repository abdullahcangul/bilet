package com.cngl.bilet.service.impl;

import java.util.List;

import com.cngl.bilet.dto.KuponRequestDto;
import com.cngl.bilet.dto.KuponResponseDto;
import com.cngl.bilet.entity.Kupon;
import com.cngl.bilet.repository.HavayoluRepository;
import com.cngl.bilet.repository.KuponRepository;
import com.cngl.bilet.service.KuponService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KuponServiceImpl implements KuponService {

    private final KuponRepository kuponRepository;
    private final HavayoluRepository havayoluRepository;
    private final ModelMapper modelMapper;

    public KuponServiceImpl(
        KuponRepository kuponRepository,
        HavayoluRepository havayoluRepository,
        ModelMapper modelMapper) {
        this.kuponRepository=kuponRepository;
        this.havayoluRepository=havayoluRepository;
        this.modelMapper = modelMapper;
    }

    public List<KuponResponseDto> tumunuGetir(){
        return modelMapper.map(kuponRepository.findAll(),
            new TypeToken<List<KuponResponseDto>>() {}.getType());
    }
    
    public KuponResponseDto idYeGoreGetir(Long id) throws Exception {
        return modelMapper.
            map(kuponRepository.findById(id).orElseThrow(()-> new Exception("ff")), KuponResponseDto.class);
    }

    public KuponResponseDto kaydet(KuponRequestDto kuponRequestDto)throws Exception{
        Kupon kupon=modelMapper.map(kuponRequestDto,Kupon.class);
        kupon=kuponBagimlilikAta(kuponRequestDto,kupon);
        return modelMapper.map(kuponRepository.
            save(kupon),KuponResponseDto.class);
    }

    public KuponResponseDto guncelle(KuponRequestDto kuponRequestDto)throws Exception{
        Kupon kupon=kuponRepository.findById(kuponRequestDto.getId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı"));
        kupon=kuponBagimlilikAta(kuponRequestDto,kupon);
        return modelMapper.map(kuponRepository.
            save(kupon),KuponResponseDto.class);
    }

    private Kupon kuponBagimlilikAta(KuponRequestDto kuponRequestDto,Kupon kupon)throws Exception{
        kupon.setHavayolu(havayoluRepository.findById(kuponRequestDto.getHavayoluId()).
            orElseThrow(()->new Exception("Engelli Rota bulanamadı")));
        return kupon;
    }

    public void sil(Long id) throws Exception {
        kuponRepository.delete(
            kuponRepository.findById(id).orElseThrow(()->new Exception("Kupon bulanamadı"))
        );
    }
    
}