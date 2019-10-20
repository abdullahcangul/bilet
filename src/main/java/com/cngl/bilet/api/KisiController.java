package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.KisiRequestDto;
import com.cngl.bilet.dto.KisiResponseDto;
import com.cngl.bilet.service.impl.KisiServiceImpl;

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
@RequestMapping("/kisi")
public class KisiController {

    private final KisiServiceImpl kisiServiceImpl;

    public KisiController(KisiServiceImpl kisiServiceImpl) {
        this.kisiServiceImpl=kisiServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<KisiResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(kisiServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<KisiResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(kisiServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<KisiResponseDto> kaydet(@RequestBody @Valid KisiRequestDto entity) {
        return ResponseEntity.ok(kisiServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<KisiResponseDto> guncelle(@RequestBody @Valid KisiRequestDto entity) throws Exception {
        return ResponseEntity.ok(kisiServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> aktifPasifEt(@PathVariable(value="id") Long id) throws Exception {
        return ResponseEntity.ok(kisiServiceImpl.aktifPasifEt(id));
    } 
}