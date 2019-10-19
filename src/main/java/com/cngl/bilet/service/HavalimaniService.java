package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.HavalimaniRequestDto;
import com.cngl.bilet.dto.HavalimaniResponseDto;

/**
 * HavalimaniService
 */
public interface HavalimaniService {

    public List<HavalimaniResponseDto> tumunuGetir();
    public HavalimaniResponseDto idYeGoreGetir(Long id) throws Exception;
    public HavalimaniResponseDto kaydetVeyaGuncelle(HavalimaniRequestDto havalimaniRequestDto);
    public void sil(Long id) throws Exception;
}