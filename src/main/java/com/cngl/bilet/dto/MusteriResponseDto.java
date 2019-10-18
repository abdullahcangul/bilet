package com.cngl.bilet.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.cngl.bilet.entity.Kisi;
import com.cngl.bilet.entity.Sefer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriResponseDto {

    private Long id;
    private String pnr;
    @NotNull
    private Boolean cinsiyet;

    private Kisi kisi; 
    private List<Sefer> sefeler;
}