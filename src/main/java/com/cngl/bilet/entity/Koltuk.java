package com.cngl.bilet.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="koltuklar")
@AllArgsConstructor
@NoArgsConstructor
public class Koltuk implements Serializable {

    private static final long serialVersionUID = 1438429341740344780L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @Size(max = 50, min = 2 )
    @NotEmpty()
    private String isim;
    @NotNull
    private String sinif;
    @NotNull
    private BigDecimal koltukUcreti;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "ucak_id")
    private Ucak ucak;

    
    @OneToOne(mappedBy = "koltuk")
    private Bilet bilet;
}