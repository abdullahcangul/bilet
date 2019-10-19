package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.KoltukTurRequestDto;
import com.cngl.bilet.dto.KoltukTurResponseDto;

public interface KoltukTurService {

    public List<KoltukTurResponseDto> tumunuGetir();
    public KoltukTurResponseDto idYeGoreGetir(Long id) throws Exception;
    public KoltukTurResponseDto kaydetVeyaGuncelle(KoltukTurRequestDto koltukTurRequestDto);
    public void sil(Long id) throws Exception;

}