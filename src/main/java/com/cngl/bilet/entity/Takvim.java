package com.cngl.bilet.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="takvimler")
@AllArgsConstructor
@NoArgsConstructor
public class Takvim implements Serializable {

    private static final long serialVersionUID = -997522412727218642L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @NotNull
    private LocalDateTime kalkisZamanı;
    @NotNull
    private LocalDateTime varisZamani;

    private Boolean aktifMi=true;


    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "takvim",
        orphanRemoval = true
    )
    private List<Sefer> seferler=new ArrayList<Sefer>();
}