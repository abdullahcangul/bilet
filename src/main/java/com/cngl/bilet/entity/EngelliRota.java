package com.cngl.bilet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
//@IdClass(EngelliRotaPk.class)
public class EngelliRota implements Serializable {

    private static final long serialVersionUID = -8677757423276079783L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    //Todo: 2 kere aynı hava alanı girilemez

    private Long kalkisHavaAlaniId;

    private Long varisHavaAlaniId;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Havayolu> havayollari;
    
}