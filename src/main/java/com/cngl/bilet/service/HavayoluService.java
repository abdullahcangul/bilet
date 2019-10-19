package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.HavayoluRequestDto;
import com.cngl.bilet.dto.HavayoluResponseDto;

public interface HavayoluService {

    public List<HavayoluResponseDto> tumunuGetir();
    public HavayoluResponseDto idYeGoreGetir(Long id) throws Exception;
    public HavayoluResponseDto kaydetVeyaGuncelle(HavayoluRequestDto havayoluRequestDto);
    public void sil(Long id) throws Exception;
}