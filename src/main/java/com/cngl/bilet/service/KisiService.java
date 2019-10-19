package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.KisiRequestDto;
import com.cngl.bilet.dto.KisiResponseDto;

public interface KisiService {

    public List<KisiResponseDto> tumunuGetir();
    public KisiResponseDto idYeGoreGetir(Long id) throws Exception;
    public KisiResponseDto kaydetVeyaGuncelle(KisiRequestDto kisiRequestDto);
    public void sil(Long id) throws Exception;

}