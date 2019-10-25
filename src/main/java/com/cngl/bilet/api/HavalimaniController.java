package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.HavalimaniRequestDto;
import com.cngl.bilet.dto.HavalimaniResponseDto;
import com.cngl.bilet.service.impl.HavalimaniServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/havalimani")
@CrossOrigin(origins="*")
public class HavalimaniController {

    private final HavalimaniServiceImpl havalimaniServiceImpl;

    public HavalimaniController(HavalimaniServiceImpl havalimaniServiceImpl) {
        this.havalimaniServiceImpl=havalimaniServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<HavalimaniResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(havalimaniServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<HavalimaniResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(havalimaniServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<HavalimaniResponseDto> kaydet(@RequestBody @Valid HavalimaniRequestDto entity) {
        return ResponseEntity.ok(havalimaniServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<HavalimaniResponseDto> guncelle(@RequestBody @Valid HavalimaniRequestDto entity)throws Exception {
        return ResponseEntity.ok(havalimaniServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> aktifPAsifEt(@PathVariable(value="id") Long id) throws Exception {
        return ResponseEntity.ok(havalimaniServiceImpl.aktifPasifEt(id));
    }
}