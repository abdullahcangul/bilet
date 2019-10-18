package com.cngl.bilet.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EngelliRotaRequestDto {

    private Long id;
    @NotNull(message="Kalkis havalimani boş gecilemez")
    private Long kalkısHavaAlaniId;
    @NotNull(message="Kalkis havalimani boş gecilemez")
    private Long inisHavaAlaniId; 
}