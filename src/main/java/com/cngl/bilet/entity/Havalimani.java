package com.cngl.bilet.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="havalimanlari")
@AllArgsConstructor
@NoArgsConstructor
public class Havalimani {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @Size(max = 50, min = 3, message = "{Havayolu.isim.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String isim;
    @Size(max = 200, min = 3, message = "{Havayolu.adres.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String adres;
    @Size(max = 50, min = 3, message = "{Havayolu.sehir.invalid}")
    @NotEmpty(message = "Lutfen isim girin")
    private String sehir;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "kalkisHavalimani",
        orphanRemoval = true
    )
    private List<Sefer> kalkishavalimaniSeferleri;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "InisHavalimani",
        orphanRemoval = true
    )
    private List<Sefer> inishavalimaniSeferleri;


}