package com.cngl.bilet.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cngl.bilet.entity.EngelliRota;
import com.cngl.bilet.entity.Kupon;
import com.cngl.bilet.entity.Sefer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HavayoluResponseDto {

    private long id;
    @Size(max = 50, min = 3, message = "{HavayoluResponseDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;

    private List<Sefer> seferler;
    private List<Kupon> kuponlar;
    private List<EngelliRota> engelliRotalar;
}