package com.cngl.bilet.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name="ucaklar")
@AllArgsConstructor
@NoArgsConstructor
public class Ucak implements Serializable {

    private static final long serialVersionUID = 6289420356421141744L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @Size(max = 50, min = 2)
    @NotEmpty()
    private String isim;
    @NotNull
    @Column(name = "pilot_sayisi")
    private Integer pilotSayisi;
    @NotNull
    @Column(name = "hostes_sayisi")
    private Integer hostesSayisi;
    @NotNull
    @Column(name = "km_basina_bakim_maliyeti")
    private BigDecimal kmBasinaBakimMaliyeti;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "ucak",
        orphanRemoval = true
    ) 
    private List<Sefer> seferler;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "ucak",
        orphanRemoval = true
    )
    private List<Koltuk> koltuklar;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Urun> urunler;
    
}