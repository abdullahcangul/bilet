package com.cngl.bilet.dto;

import java.math.BigDecimal;
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
public class UcakRequestDto {

    private Long id;
    @Size(max = 50, min = 2, message = "{UcakRequestDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @NotNull
    private Integer pilotSayisi;
    @NotNull
    private Integer hostesSayisi;
    @NotNull
    private BigDecimal kmBasinaBakimMaliyeti;

    private Long havayoluId;

    private List<Long> urunId;
}