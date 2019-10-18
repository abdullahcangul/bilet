package com.cngl.bilet.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cngl.bilet.entity.Sefer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HavalimaniResponseDto {


    private Long id;
    @Size(max = 50, min = 3, message = "{HavalimaniResponseDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @Size(max = 200, min = 3, message = "{HavalimaniResponseDto.adres.invalid}")
    @NotEmpty(message = "Lutfen adres girin")
    private String adres;
    @Size(max = 50, min = 3, message = "{HavalimaniResponseDto.sehir.invalid}")
    @NotEmpty(message = "Lutfen sehir girin")
    private String sehir;

    private List<Sefer> kalkishavalimaniSeferleri;
    private List<Sefer> inishavalimaniSeferleri;
}