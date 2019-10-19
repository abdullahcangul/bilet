package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.MusteriRequestDto;
import com.cngl.bilet.dto.MusteriResponseDto;

public interface MusteriService {
    
    public List<MusteriResponseDto> tumunuGetir();
    public MusteriResponseDto idYeGoreGetir(Long id) throws Exception;
    public MusteriResponseDto kaydetVeyaGuncelle(MusteriRequestDto musteriRequestDto);
    public void sil(Long id) throws Exception;

}