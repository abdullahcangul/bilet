package com.cngl.bilet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
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
public class Musteri implements Serializable {

    private static final long serialVersionUID = 6452770081784247197L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;

    @OneToOne
    @MapsId
    private Kisi kisi; 

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "musteri",
        orphanRemoval = true
    )
    private List<Bilet> biletler;
}