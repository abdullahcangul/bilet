package com.cngl.bilet.dto;


import com.cngl.bilet.entity.Kisi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriResponseDto {

    private Long id;
    private String pnr;
    private Integer koltukNo;

    private Kisi kisi; 
}