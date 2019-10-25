package com.cngl.bilet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="seferler")
@AllArgsConstructor
@NoArgsConstructor
public class Sefer implements Serializable {

    private static final long serialVersionUID = 3616359874086638009L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @Size(max = 50, min = 2)
    @NotEmpty()
    private String isim;
    @NotNull
    private Float km;
    @Column(name = "kapi_No",nullable = false)
    private Integer kapiNo;

    private Boolean aktifPasifEt=true;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "Kalkis_havalimani_id")
    private Havalimani kalkisHavalimani;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "Inis_havalimani_id")
    private Havalimani InisHavalimani;

    //beraber primery key

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "havayolu_id")
    private Havayolu havayolu;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "ucak_id")
    private Ucak ucak;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "takvim_id")
    private Takvim takvim;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "sefer",
        orphanRemoval = true
    )
    private List<Bilet> biletler;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "sefer"
    )
    private List<Koltuk> koltuklar;
}