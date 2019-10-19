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
    @Column(name = "koltuk_no",nullable = false)
    private Integer koltukNo;

    @OneToOne
    @MapsId
    private Kisi kisi; 

    @ManyToMany(
        fetch = FetchType.LAZY,
        mappedBy="musteriler"
    )
    private List<Sefer> sefeler;
}