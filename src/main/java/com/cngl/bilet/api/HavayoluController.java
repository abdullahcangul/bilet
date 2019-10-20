package com.cngl.bilet.api;

import java.util.List;

import javax.validation.Valid;

import com.cngl.bilet.dto.HavayoluRequestDto;
import com.cngl.bilet.dto.HavayoluResponseDto;
import com.cngl.bilet.service.impl.HavayoluServiceImpl;

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
@RequestMapping("/havayolu")
public class HavayoluController {

    private final HavayoluServiceImpl havayoluServiceImpl;

    public HavayoluController(HavayoluServiceImpl havayoluServiceImpl) {
        this.havayoluServiceImpl=havayoluServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<HavayoluResponseDto>> tumunuGetir(){
        return ResponseEntity.ok(havayoluServiceImpl.tumunuGetir());
    }

    @GetMapping("/id")
    public ResponseEntity<HavayoluResponseDto> idYeGoreGetir(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(havayoluServiceImpl.idYeGoreGetir(id));
    }

    @PostMapping
    public ResponseEntity<HavayoluResponseDto> kaydet(@RequestBody @Valid HavayoluRequestDto entity) {
        return ResponseEntity.ok(havayoluServiceImpl.kaydet(entity));
    }

    @PutMapping
    public ResponseEntity<HavayoluResponseDto> guncelle(@RequestBody @Valid HavayoluRequestDto entity)
            throws Exception {
        return ResponseEntity.ok(havayoluServiceImpl.guncelle(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> sil(@PathVariable(value="id") Long id) throws Exception {
        havayoluServiceImpl.sil(id);
        return ResponseEntity.ok(true);
    } 
}