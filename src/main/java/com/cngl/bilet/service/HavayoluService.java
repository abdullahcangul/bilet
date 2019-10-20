package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.HavayoluRequestDto;
import com.cngl.bilet.dto.HavayoluResponseDto;

public interface HavayoluService {

    public List<HavayoluResponseDto> tumunuGetir();
    public HavayoluResponseDto kaydet(HavayoluRequestDto havayoluRequestDto);
    public HavayoluResponseDto guncelle(HavayoluRequestDto havayoluRequestDto) throws Exception;
    public void sil(Long id) throws Exception;
}