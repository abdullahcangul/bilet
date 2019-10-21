package com.cngl.bilet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiletRequestDto {

    private Long id;

    private String pnr;
    private Integer koltukNo;

    private Long seferId;
    private Long musteriId;
    private Long koltukId;
    
}