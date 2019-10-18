package com.cngl.bilet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HavayoluRequestDto {

    private long id;
    @Size(max = 50, min = 3, message = "{HavayoluRequestDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;

    private Long engelliRotaId;
    private Long kuponId;
}