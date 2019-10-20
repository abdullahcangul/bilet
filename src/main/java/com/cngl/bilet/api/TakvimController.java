package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.TakvimRequestDto;
import com.cngl.bilet.dto.TakvimResponseDto;
import com.cngl.bilet.service.impl.TakvimServiceImpl;

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
@RequestMapping("/takvim")
public class TakvimController {

    private final TakvimServiceImpl takvimServiceImpl;

    public TakvimController(TakvimServiceImpl takvimServiceImpl) {
        this.takvimServiceImpl=takvimServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<TakvimResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(takvimServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<TakvimResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(takvimServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<TakvimResponseDto> kaydet(@RequestBody @Valid TakvimRequestDto entity) {
        return ResponseEntity.ok(takvimServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<TakvimResponseDto> guncelle(@RequestBody @Valid TakvimRequestDto entity) throws Exception {
        return ResponseEntity.ok(takvimServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> aktifPasifEt(@PathVariable(value="id") Long id) throws Exception {
        return ResponseEntity.ok(takvimServiceImpl.aktifPasifEt(id));
    }  
    
}