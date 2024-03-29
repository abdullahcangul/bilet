package com.cngl.bilet.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="kuponlar")
@AllArgsConstructor
@NoArgsConstructor
public class Kupon implements Serializable {
    
    private static final long serialVersionUID = 605650770120560302L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @Size(max = 50, min = 2)
    @NotEmpty()
    private String isim;
    private Float indirimMiktari;
    //Todo: bunun için bir tablo olusturulsunmu
    private Boolean yuzdeliIndirimMi;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "havayolu_id")
    private Havayolu havayolu;

}