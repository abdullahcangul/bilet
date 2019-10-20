package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.KullaniciRequestDto;
import com.cngl.bilet.dto.KullaniciResponseDto;

public interface KullaniciService {

    public List<KullaniciResponseDto> tumunuGetir();
    public KullaniciResponseDto idYeGoreGetir(Long id) throws Exception;
    public KullaniciResponseDto kaydet(KullaniciRequestDto kullaniciRequestDto);
    public KullaniciResponseDto guncelle(KullaniciRequestDto kullaniciRequestDto) throws Exception;
    public void sil(Long id) throws Exception;
    
}