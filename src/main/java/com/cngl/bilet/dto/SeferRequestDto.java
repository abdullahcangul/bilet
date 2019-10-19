package com.cngl.bilet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeferRequestDto {

    private Long id;
    @Size(max = 50, min = 2, message = "{SeferRequestDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @NotNull
    private Float km;
    private Integer kapiNo;

    private Long kalkisHavalimaniId;
    private Long inishavalimaniId;
    private Long havayoluId;
    private Long ucakId;
    private Long TakvimId;
}