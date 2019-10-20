package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.RolRequestDto;
import com.cngl.bilet.dto.RolResponseDto;
import com.cngl.bilet.service.impl.RolServiceImpl;

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
@RequestMapping("/rol")
public class RolController {
 
    private final RolServiceImpl rolServiceImpl;

    public RolController(RolServiceImpl rolServiceImpl) {
        this.rolServiceImpl=rolServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<RolResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(rolServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<RolResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(rolServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<RolResponseDto> kaydet(@RequestBody @Valid RolRequestDto entity) {
        return ResponseEntity.ok(rolServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<RolResponseDto> guncelle(@RequestBody @Valid RolRequestDto entity) throws Exception {
        return ResponseEntity.ok(rolServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        rolServiceImpl.sil(id);
        return ResponseEntity.ok(true);
    }  
    
}