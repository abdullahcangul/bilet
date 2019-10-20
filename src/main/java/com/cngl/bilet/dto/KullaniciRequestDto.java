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
public class KullaniciRequestDto {

    private Long id;
    @Size(max = 20, min = 3, message = "{KullaniciRequestDto.sifre.invalid}")
    @NotEmpty(message = "Lutfen sifre girin")
    private String sifre;

    private List<Long> RolId;
}