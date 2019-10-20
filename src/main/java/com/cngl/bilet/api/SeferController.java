package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.SeferRequestDto;
import com.cngl.bilet.dto.SeferResponseDto;
import com.cngl.bilet.service.impl.SeferServiceImpl;

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
@RequestMapping("/sefer")
public class SeferController {

    private final SeferServiceImpl seferServiceImpl;

    public SeferController(SeferServiceImpl seferServiceImpl) {
        this.seferServiceImpl=seferServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<SeferResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(seferServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<SeferResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(seferServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<SeferResponseDto> kaydet(@RequestBody @Valid SeferRequestDto entity) throws Exception {
        return ResponseEntity.ok(seferServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<SeferResponseDto> guncelle(@RequestBody @Valid SeferRequestDto entity) throws Exception {
        return ResponseEntity.ok(seferServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> aktifPAsifEt(@PathVariable(value="id") Long id) throws Exception {    
        return ResponseEntity.ok( seferServiceImpl.aktifPasifEt(id));
    }  
}