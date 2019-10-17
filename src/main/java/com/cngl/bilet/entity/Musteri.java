package com.cngl.bilet.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="musteriler")
@AllArgsConstructor
@NoArgsConstructor
public class Musteri {

    @Id
    private Long id;
    @Column(unique=true)
    private String pnr;
    //Todo:cinsiyeti düzenle
    private Boolean cinsiyet;

    @OneToOne
    @MapsId
    private Kisi kisi; 

    @ManyToMany(
        fetch = FetchType.LAZY,
        mappedBy="musteri"
    )
    private List<Sefer> sefeler;
}