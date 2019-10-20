package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.MusteriRequestDto;
import com.cngl.bilet.dto.MusteriResponseDto;
import com.cngl.bilet.service.impl.MusteriServiceImpl;

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
@RequestMapping("/musteri")
public class MusteriController {

    private final MusteriServiceImpl musteriServiceImpl;

    public MusteriController(MusteriServiceImpl musteriServiceImpl) {
        this.musteriServiceImpl=musteriServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<MusteriResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(musteriServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<MusteriResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(musteriServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<MusteriResponseDto> kaydet(@RequestBody @Valid MusteriRequestDto entity) {
        return ResponseEntity.ok(musteriServiceImpl.kaydetVeyaGuncelle(entity));
    }

    @PutMapping
    public ResponseEntity<MusteriResponseDto> guncelle(@RequestBody @Valid MusteriRequestDto entity) {
        return ResponseEntity.ok(musteriServiceImpl.kaydetVeyaGuncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        musteriServiceImpl.sil(id);
        return ResponseEntity.ok(true);
    }  
}