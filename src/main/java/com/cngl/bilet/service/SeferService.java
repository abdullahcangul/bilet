package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.SeferRequestDto;
import com.cngl.bilet.dto.SeferResponseDto;

public interface SeferService {

    public List<SeferResponseDto> tumunuGetir();
    public SeferResponseDto idYeGoreGetir(Long id) throws Exception;
    public SeferResponseDto kaydetVeyaGuncelle(SeferRequestDto seferRequestDto);
    public void sil(Long id) throws Exception;   
}