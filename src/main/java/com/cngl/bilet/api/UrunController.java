package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.UrunRequestDto;
import com.cngl.bilet.dto.UrunResponseDto;
import com.cngl.bilet.service.impl.UrunServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/urun")
public class UrunController {

    
    private final UrunServiceImpl urunServiceImpl;

    public UrunController(UrunServiceImpl urunServiceImpl) {
        this.urunServiceImpl=urunServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<UrunResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(urunServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<UrunResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(urunServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<UrunResponseDto> kaydet(@RequestBody @Valid UrunRequestDto entity)throws Exception {
        return ResponseEntity.ok(urunServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<UrunResponseDto> guncelle(@RequestBody @Valid UrunRequestDto entity)throws Exception {
        return ResponseEntity.ok(urunServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        urunServiceImpl.sil(id);
        return ResponseEntity.ok(true);
    } 
}