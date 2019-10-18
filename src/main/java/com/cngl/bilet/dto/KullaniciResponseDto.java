package com.cngl.bilet.dto;

import java.util.List;

import com.cngl.bilet.entity.Kisi;
import com.cngl.bilet.entity.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciResponseDto {

    private Long id;
 
    private Kisi kisi;

    private List<Rol> roller;
}