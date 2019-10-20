package com.cngl.bilet.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cngl.bilet.entity.Koltuk;
import com.cngl.bilet.entity.Sefer;
import com.cngl.bilet.entity.Urun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UcakResponseDto {


    private Long id;
    @Size(max = 50, min = 2, message = "{UcakResponseDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @NotNull
    private Integer pilotSayisi;
    @NotNull
    private Integer hostesSayisi;
    @NotNull
    private BigDecimal kmBasinaBakimMaliyeti;


    private List<Sefer> seferler;
    private List<Koltuk> koltuklar;
    private List<Urun> urunler;
}