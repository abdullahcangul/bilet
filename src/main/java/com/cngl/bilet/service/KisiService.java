package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.KisiRequestDto;
import com.cngl.bilet.dto.KisiResponseDto;

public interface KisiService {

    public List<KisiResponseDto> tumunuGetir();
    public KisiResponseDto idYeGoreGetir(Long id) throws Exception;
    public KisiResponseDto kaydet(KisiRequestDto kisiRequestDto);
    public KisiResponseDto guncelle(KisiRequestDto kisiRequestDto) throws Exception;
    public Boolean aktifPasifEt(Long id) throws Exception;

}