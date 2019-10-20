package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.KoltukRequestDto;
import com.cngl.bilet.dto.KoltukResponseDto;
import com.cngl.bilet.service.impl.KoltukServiceImpl;

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
@RequestMapping("/koltuktur")
public class KoltukController {

    private final KoltukServiceImpl koltukServiceImpl;

    public KoltukController(KoltukServiceImpl koltukServiceImpl) {
        this.koltukServiceImpl=koltukServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<KoltukResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(koltukServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<KoltukResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(koltukServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<KoltukResponseDto> kaydet(@RequestBody @Valid KoltukRequestDto entity) throws Exception {
        return ResponseEntity.ok(koltukServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<KoltukResponseDto> guncelle(@RequestBody @Valid KoltukRequestDto entity) throws Exception {
        return ResponseEntity.ok(koltukServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        koltukServiceImpl.sil(id);
        return ResponseEntity.ok(true);
    } 
    
}