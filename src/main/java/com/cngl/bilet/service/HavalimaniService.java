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
    public HavalimaniResponseDto kaydet(HavalimaniRequestDto havalimaniRequestDto);
    public HavalimaniResponseDto guncelle(HavalimaniRequestDto havalimaniRequestDto)throws Exception;
    public Boolean aktifPasifEt(Long id) throws Exception;
}