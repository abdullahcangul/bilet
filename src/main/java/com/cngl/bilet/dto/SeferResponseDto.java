package com.cngl.bilet.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeferResponseDto {

    private Long id;
    @Size(max = 50, min = 2, message = "{SeferResponseDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @NotNull
    private Float km;
    private Integer kapiNo;


    private List<MusteriRequestDto> musteriler;
    private HavalimaniRequestDto kalkisHavalimani;
    private HavalimaniRequestDto InisHavalimani;
    private HavayoluRequestDto havayolu;
    private UcakRequestDto ucak;
    private TakvimRequestDto takvim;

}