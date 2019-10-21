package com.cngl.bilet.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Havalimani implements Serializable{


    private static final long serialVersionUID = 6370667069199410336L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @Size(max = 50, min = 3)
    @NotEmpty()
    private String isim;
    @Size(max = 200, min = 3)
    @NotEmpty()
    private String adres;
    @Size(max = 50, min = 3)
    @NotEmpty()
    private String sehir;

    private Boolean aktifMi=Boolean.TRUE;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "kalkisHavalimani",
        orphanRemoval = true
    )
    private List<Sefer> kalkishavalimaniSeferleri=new ArrayList<Sefer>();

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "InisHavalimani",
        orphanRemoval = true
    )
    private List<Sefer> inishavalimaniSeferleri=new ArrayList<Sefer>();


}