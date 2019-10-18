package com.cngl.bilet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KuponRequestDto {

    private Long id;
    @Size(max = 20, min = 3, message = "{KuponRequestDto.isim.invalid}")
    @NotEmpty(message = "Lutfen sifre girin")
    private String isim;
    private Float indirimMiktari;
    private Boolean yuzdeliIndirimMi;

    private Long havayoluId;
}