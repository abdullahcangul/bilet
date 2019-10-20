package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.UcakRequestDto;
import com.cngl.bilet.dto.UcakResponseDto;

public interface UcakService {

    public List<UcakResponseDto> tumunuGetir();
    public UcakResponseDto idYeGoreGetir(Long id) throws Exception;
    public UcakResponseDto kaydet(UcakRequestDto ucakRequestDto);
    public UcakResponseDto guncelle(UcakRequestDto ucakRequestDto)throws Exception;
    public void sil(Long id) throws Exception;
    
}