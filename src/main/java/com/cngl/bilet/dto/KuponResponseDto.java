package com.cngl.bilet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cngl.bilet.entity.Havayolu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KuponResponseDto {

    private Long id;
    @Size(max = 50, min = 2, message = "{KuponResponseDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    private Float indirimMiktari;
    private Boolean yuzdeliIndirimMi;

    private Havayolu havayolu;
    
}