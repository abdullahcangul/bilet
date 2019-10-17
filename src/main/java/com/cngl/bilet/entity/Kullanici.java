package com.cngl.bilet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="kullanicilar")
@AllArgsConstructor
@NoArgsConstructor
public class Kullanici {

    @Id
    private Long id;
    @Size(max = 20, min = 3, message = "{Kullanici.sifre.invalid}")
    @NotEmpty(message = "Lutfen sifre girin")
    private String sifre;
    
    @OneToOne
    @MapsId
    private Kisi kisi;
}