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
public class RolRequestDto {

    private Long id;
    @Size(max = 50, min = 2, message = "{RolRequestDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim; 

    private List<Long> kullaniciId;
}