package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.EngelliRotaRequestDto;
import com.cngl.bilet.dto.EngelliRotaResponseDto;

import org.springframework.stereotype.Service;

@Service
public interface EngelliRotaService {

    public List<EngelliRotaResponseDto> tumunuGetir();
    public EngelliRotaResponseDto idYeGoreGetir(Long id) throws Exception;
    public EngelliRotaResponseDto kaydetVeyaGuncelle(EngelliRotaRequestDto engelliRotaRequestDto);
    public void sil(Long id) throws Exception;
}