package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.BiletRequestDto;
import com.cngl.bilet.dto.BiletResponseDto;
import com.cngl.bilet.service.impl.BiletServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BiletController {

    
    private final BiletServiceImpl biletServiceImpl;

    public BiletController(BiletServiceImpl biletServiceImpl) {
        this.biletServiceImpl=biletServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<BiletResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(biletServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<BiletResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(biletServiceImpl.idYeGoreGetir(id));
    }
    @GetMapping("/pnr/no")
    public ResponseEntity<BiletResponseDto> idYeGoreGetir(@PathVariable(value="no") String pnr) throws Exception{
        return ResponseEntity.ok(biletServiceImpl.pnrYeGoreGetir(pnr));
    }

    @PostMapping
    public ResponseEntity<BiletResponseDto> kaydet(@RequestBody @Valid BiletRequestDto entity)throws Exception {
        return ResponseEntity.ok(biletServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<BiletResponseDto> guncelle(@RequestBody @Valid BiletRequestDto entity)throws Exception {
        return ResponseEntity.ok(biletServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        return ResponseEntity.ok(biletServiceImpl.aktifPasifEt(id));
    }
}