package com.cngl.bilet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="kuponlar")
@AllArgsConstructor
@NoArgsConstructor
public class Kupon {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    private String isim;
    private Float indirimMiktari;
    //Todo: bunun için bir tablo olusturulsunmu
    private Boolean yuzdeliIndirimMi;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "takvim_id")
    private Havayolu havayolu;

}