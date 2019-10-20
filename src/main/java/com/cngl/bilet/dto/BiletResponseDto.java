package com.cngl.bilet.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cngl.bilet.entity.Koltuk;
import com.cngl.bilet.entity.Musteri;
import com.cngl.bilet.entity.Sefer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiletResponseDto {

    private Long id;

    private String pnr;
    private Integer koltukNo;

    private Musteri musteri;
    private Sefer sefer;
    private Koltuk koltuk;
}