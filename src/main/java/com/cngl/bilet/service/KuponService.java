package com.cngl.bilet.service;

import java.util.List;

import com.cngl.bilet.dto.KuponRequestDto;
import com.cngl.bilet.dto.KuponResponseDto;

public interface KuponService {
    
    public List<KuponResponseDto> tumunuGetir();
    public KuponResponseDto idYeGoreGetir(Long id) throws Exception;
    public KuponResponseDto kaydet(KuponRequestDto kuponRequestDto)throws Exception;
    public KuponResponseDto guncelle(KuponRequestDto kuponRequestDto)throws Exception;
    public void sil(Long id) throws Exception;
    
}