package com.cngl.bilet.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cngl.bilet.entity.Havalimani;
import com.cngl.bilet.entity.Havayolu;
import com.cngl.bilet.entity.Musteri;
import com.cngl.bilet.entity.Takvim;
import com.cngl.bilet.entity.Ucak;

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


    private List<Musteri> musteriler;
    private Havalimani kalkisHavalimani;
    private Havalimani InisHavalimani;
    private Havayolu havayolu;
    private Ucak ucak;
    private Takvim takvim;

}