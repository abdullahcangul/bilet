package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.BiletRequestDto;
import com.cngl.bilet.dto.BiletResponseDto;

public interface BiletService {

    public List<BiletResponseDto> tumunuGetir();
    public BiletResponseDto idYeGoreGetir(Long id) throws Exception;
    public BiletResponseDto kaydet(BiletRequestDto biletRequestDto)throws Exception;
    public BiletResponseDto guncelle(BiletRequestDto biletRequestDto)throws Exception;
    public Boolean aktifPasifEt(Long id) throws Exception;
}