package com.cngl.bilet.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeferSorguRequestDto {
    @NotNull(message = "Kalkis havalimani secmelisiniz")
    private Long kalkisHavalimaniId;
    @NotNull(message = "inis havalimani secmelisiniz")
    private Long inishavalimaniId;

    @NotNull(message = "Kalkis havalimani girmelisiniz") 
    private LocalDateTime kalkisZamanı;
}