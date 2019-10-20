package com.cngl.bilet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="engelli_rotalar")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EngelliRotaPk.class)
public class EngelliRota {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    //Todo: 2 kere aynı hava alanı girilemez

    private Long GidisHavaAlaniId;

    private Long GonusHavaAlaniId;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Havayolu> havayollari;
    
}