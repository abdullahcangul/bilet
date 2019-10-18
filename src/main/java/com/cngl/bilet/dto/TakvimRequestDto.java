package com.cngl.bilet.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakvimRequestDto {

    private Long id;
    @NotNull
    private LocalDateTime kalkisZamanı;
    @NotNull
    private LocalDateTime varisZamani;
}