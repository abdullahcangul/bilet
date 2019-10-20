package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.RolRequestDto;
import com.cngl.bilet.dto.RolResponseDto;

public interface RolService {

    public List<RolResponseDto> tumunuGetir();
    public RolResponseDto idYeGoreGetir(Long id) throws Exception;
    public RolResponseDto kaydet(RolRequestDto rolRequestDto);
    public RolResponseDto guncelle(RolRequestDto rolRequestDto)throws Exception;
    public void sil(Long id) throws Exception;    
}