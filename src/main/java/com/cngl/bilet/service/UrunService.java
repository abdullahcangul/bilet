package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.UrunRequestDto;
import com.cngl.bilet.dto.UrunResponseDto;

public interface UrunService {
    
    public List<UrunResponseDto> tumunuGetir();
    public UrunResponseDto idYeGoreGetir(Long id) throws Exception;
    public UrunResponseDto kaydetVeyaGuncelle(UrunRequestDto urunRequestDto);
    public void sil(Long id) throws Exception;
    
}