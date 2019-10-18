package com.cngl.bilet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HavalimaniRequestDto {

    private Long id;
    @Size(max = 50, min = 3, message = "{HavalimaniRequestDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @Size(max = 200, min = 3, message = "{HavalimaniRequestDto.adres.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String adres;
    @Size(max = 50, min = 3, message = "{HavalimaniRequestDto.sehir.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String sehir;
    
}