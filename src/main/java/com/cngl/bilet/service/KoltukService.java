package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.KoltukRequestDto;
import com.cngl.bilet.dto.KoltukResponseDto;

public interface KoltukService {

    public List<KoltukResponseDto> tumunuGetir();
    public KoltukResponseDto idYeGoreGetir(Long id) throws Exception;
    public KoltukResponseDto kaydet(KoltukRequestDto koltukRequestDto)throws Exception;
    public KoltukResponseDto guncelle(KoltukRequestDto koltukRequestDto)throws Exception;
    public void sil(Long id) throws Exception;

}