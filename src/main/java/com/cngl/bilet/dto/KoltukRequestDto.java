package com.cngl.bilet.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KoltukRequestDto {
    
    private Long id;
    @Size(max = 50, min = 2, message = "{KoltukTurRequestDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @NotNull
    private Integer koltukSayisi;
    @NotNull
    private BigDecimal koltukUcreti;

    @NotNull
    private Long seferId;
    
}