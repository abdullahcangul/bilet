package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.EngelliRotaRequestDto;
import com.cngl.bilet.dto.EngelliRotaResponseDto;
import com.cngl.bilet.service.impl.EngelliRotaServiceImpl;

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
@RequestMapping("/engellirota")
public class EngelliRotaController {

    private final EngelliRotaServiceImpl engelliRotaService;

    public EngelliRotaController(EngelliRotaServiceImpl engelliRotaService) {
        this.engelliRotaService=engelliRotaService;
    }

    @GetMapping
    public ResponseEntity<List<EngelliRotaResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(engelliRotaService.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<EngelliRotaResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(engelliRotaService.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<EngelliRotaResponseDto> kaydet(@RequestBody @Valid EngelliRotaRequestDto entity) {
        return ResponseEntity.ok(engelliRotaService.kaydetVeyaGuncelle(entity));
    }

    @PutMapping
    public ResponseEntity<EngelliRotaResponseDto> guncelle(@RequestBody @Valid EngelliRotaRequestDto entity) {
        return ResponseEntity.ok(engelliRotaService.kaydetVeyaGuncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        engelliRotaService.sil(id);
        return ResponseEntity.ok(true);
    }
}