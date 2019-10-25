package com.cngl.bilet.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    private List<SeferRequestDto> seferler;
    private List<KuponRequestDto> kuponlar;
    private List<EngelliRotaRequestDto> engelliRotalar;
}