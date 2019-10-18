package com.cngl.bilet.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.cngl.bilet.entity.Kullanici;
import com.cngl.bilet.entity.Musteri;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KisiResponseDto {

    private Long id;
    @Size(max = 20, min = 3, message = "{KisiResponseDto.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @Size(max = 20, min = 3, message = "{KisiResponseDto.isim.invalid}")
    @NotEmpty(message = "Lutfen soyisim girin")
    private String soyisim;
    //Todo:tc validasyonu yapılacak
    private String tc;
    @Email(message="lütfen gecerli bir eposta girin")
    private String email;
    @NotEmpty(message = "Lütfen telefon numarası girin")
    private String tel;
    @PastOrPresent
    @Column(name = "dogum_tarihi")
    private LocalDate dogumTarihi;

    private Kullanici kullanici;
    private Musteri musteri;    
}