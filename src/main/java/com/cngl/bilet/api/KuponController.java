package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.KuponRequestDto;
import com.cngl.bilet.dto.KuponResponseDto;
import com.cngl.bilet.service.impl.KuponServiceImpl;

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
@RequestMapping("/kupon")
public class KuponController {

    private final KuponServiceImpl kuponServiceImpl;

    public KuponController(KuponServiceImpl kuponServiceImpl) {
        this.kuponServiceImpl=kuponServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<KuponResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(kuponServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<KuponResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(kuponServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<KuponResponseDto> kaydet(@RequestBody @Valid KuponRequestDto entity)throws Exception {
        return ResponseEntity.ok(kuponServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<KuponResponseDto> guncelle(@RequestBody @Valid KuponRequestDto entity)throws Exception {
        return ResponseEntity.ok(kuponServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        kuponServiceImpl.sil(id);
        return ResponseEntity.ok(true);
    }  
}