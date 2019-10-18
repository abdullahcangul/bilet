package com.cngl.bilet.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.cngl.bilet.entity.Sefer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakvimResponseDto {

    private Long id;
    @NotNull
    private LocalDateTime kalkisZamanı;
    @NotNull
    private LocalDateTime varisZamani;

    private List<Sefer> seferler;
}