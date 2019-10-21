package com.cngl.bilet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Havayollari")
@AllArgsConstructor
@NoArgsConstructor
public class Havayolu implements Serializable {

    private static final long serialVersionUID = -2108020073124239272L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private long id;
    @Size(max = 50, min = 3 )
    @NotEmpty()
    private String isim;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "havayolu",
        orphanRemoval = true
    )
    private List<Sefer> seferler;

    
    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "havayolu",
        orphanRemoval = true
    )
    private List<Kupon> kuponlar;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy="havayollari")
    private List<EngelliRota> engelliRotalar;
}