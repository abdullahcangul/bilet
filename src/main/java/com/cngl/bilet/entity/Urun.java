package com.cngl.bilet.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="urunler")
@AllArgsConstructor
@NoArgsConstructor
public class Urun implements Serializable {

    private static final long serialVersionUID = 7155770918395873325L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @Size(max = 50, min = 2)
    @NotEmpty()
    private String isim;
    @NotNull
    private BigDecimal ucret;

    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "urunler")
    private List<Ucak> ucaklar;
    
}