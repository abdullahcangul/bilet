package com.cngl.bilet.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="biletler",indexes = {@Index(name="bilet_pnr_index",columnList = "pnr",unique=true)})
@AllArgsConstructor
@NoArgsConstructor
public class Bilet implements Serializable {

    private static final long serialVersionUID = -9181015684860393170L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;

    @Column(nullable =false)
    private String pnr;
    @Column(name = "koltuk_no",nullable = false)
    private Integer koltukNo;
    @Column(name = "toplam_tutar")
    private BigDecimal toplamTutar;

    private Boolean ödendiMi=Boolean.FALSE;
    private Boolean aktifMi=Boolean.TRUE;

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "musteri_id")
    private Musteri musteri=new Musteri();

    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        optional = false
    )
    @JoinColumn(name = "sefer_id")
    private Sefer sefer=new Sefer();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "koltuk_id", referencedColumnName = "id")
    private Koltuk koltuk;
}