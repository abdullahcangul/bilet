package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.UcakRequestDto;
import com.cngl.bilet.dto.UcakResponseDto;
import com.cngl.bilet.service.impl.UcakServiceImpl;

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
@RequestMapping("/ucak")
public class UcakController {

    private final UcakServiceImpl ucakServiceImpl;

    public UcakController(UcakServiceImpl ucakServiceImpl) {
        this.ucakServiceImpl=ucakServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<UcakResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(ucakServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<UcakResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(ucakServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<UcakResponseDto> kaydet(@RequestBody @Valid UcakRequestDto entity) {
        return ResponseEntity.ok(ucakServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<UcakResponseDto> guncelle(@RequestBody @Valid UcakRequestDto entity) throws Exception {
        return ResponseEntity.ok(ucakServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        ucakServiceImpl.sil(id);
        return ResponseEntity.ok(true);
    }  
}