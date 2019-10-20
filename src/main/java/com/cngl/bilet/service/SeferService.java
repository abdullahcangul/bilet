package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.SeferRequestDto;
import com.cngl.bilet.dto.SeferResponseDto;

public interface SeferService {

    public List<SeferResponseDto> tumunuGetir();
    public SeferResponseDto idYeGoreGetir(Long id) throws Exception;
    public SeferResponseDto kaydet(SeferRequestDto seferRequestDto)throws Exception;
    public SeferResponseDto guncelle(SeferRequestDto seferRequestDto)throws Exception;
    public Boolean aktifPasifEt(Long id) throws Exception ;   
}