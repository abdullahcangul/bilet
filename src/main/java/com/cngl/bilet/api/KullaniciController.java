package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.KullaniciRequestDto;
import com.cngl.bilet.dto.KullaniciResponseDto;
import com.cngl.bilet.service.impl.KullaniciServiceImpl;

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
@RequestMapping("/kullanici")
public class KullaniciController {

    private final KullaniciServiceImpl kullaniciServiceImpl;

    public KullaniciController(KullaniciServiceImpl kullaniciServiceImpl) {
        this.kullaniciServiceImpl=kullaniciServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<KullaniciResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(kullaniciServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<KullaniciResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(kullaniciServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<KullaniciResponseDto> kaydet(@RequestBody @Valid KullaniciRequestDto entity) {
        return ResponseEntity.ok(kullaniciServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<KullaniciResponseDto> guncelle(@RequestBody @Valid KullaniciRequestDto entity) throws Exception {
        return ResponseEntity.ok(kullaniciServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        kullaniciServiceImpl.sil(id);
        return ResponseEntity.ok(true);
    } 
}