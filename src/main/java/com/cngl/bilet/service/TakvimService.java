package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.TakvimRequestDto;
import com.cngl.bilet.dto.TakvimResponseDto;

public interface TakvimService {

    public List<TakvimResponseDto> tumunuGetir();
    public TakvimResponseDto idYeGoreGetir(Long id) throws Exception;
    public TakvimResponseDto kaydet(TakvimRequestDto takvimRequestDto);
    public TakvimResponseDto guncelle(TakvimRequestDto takvimRequestDto)throws Exception;
    public Boolean aktifPasifEt(Long id) throws Exception;
}