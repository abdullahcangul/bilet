package com.cngl.bilet.api;

import java.util.List;

import com.cngl.bilet.dto.EngelliRotaRequestDto;
import com.cngl.bilet.dto.EngelliRotaResponseDto;
import com.cngl.bilet.service.Impl.EngelliRotaServiceImpl;

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
@RequestMapping("/engellirota")
public class EngelliRotaController {

    private final EngelliRotaServiceImpl engelliRotaService;

    public EngelliRotaController(EngelliRotaServiceImpl engelliRotaService) {
        this.engelliRotaService=engelliRotaService;
    }

    @GetMapping
    public ResponseEntity<List<EngelliRotaResponseDto>> get(){
        return ResponseEntity.ok(engelliRotaService.getAll());
    }

    @GetMapping("/id")
    public ResponseEntity<EngelliRotaResponseDto> getOne(@PathVariable(value="id") Long id) throws Exception{
        return ResponseEntity.ok(engelliRotaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EngelliRotaResponseDto> save(@RequestBody EngelliRotaRequestDto entity) {
        return ResponseEntity.ok(engelliRotaService.saveOrUpdate(entity));
    }

    @PutMapping
    public ResponseEntity<EngelliRotaResponseDto> update(@RequestBody EngelliRotaRequestDto entity) {
        return ResponseEntity.ok(engelliRotaService.saveOrUpdate(entity));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> delete(@PathVariable(value="id") Long id){
        return ResponseEntity.ok(true);
    }
}