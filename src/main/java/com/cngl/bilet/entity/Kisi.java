package com.cngl.bilet.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="kisiler")
@AllArgsConstructor
@NoArgsConstructor
public class Kisi {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Size(max = 20, min = 3, message = "{Kisi.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @Size(max = 20, min = 3, message = "{Kisi.isim.invalid}")
    @NotEmpty(message = "Lutfen soyisim girin")
    private String soyisim;
    //Todo:tc validasyonu yapılacak
    private String tc;
    @Email(message="lütfen gecerli bir eposta girin")
    private String email;
    @Column(length=10)
    @NotEmpty(message = "Lütfen telefon numarası girin")
    private String tel;
    @PastOrPresent
    @Column(name = "dogum_tarihi")
    private LocalDate dogumTarihi;
    
    @OneToOne(mappedBy = "kisi", cascade = CascadeType.ALL)
    private Kullanici kullanici;

    @OneToOne(mappedBy = "kisi", cascade = CascadeType.ALL)
    private Musteri musteri;


}