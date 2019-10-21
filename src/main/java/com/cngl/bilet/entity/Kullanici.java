package com.cngl.bilet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="kullanicilar")
@AllArgsConstructor
@NoArgsConstructor
public class Kullanici implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2039683044214082286L;
    @Id
    private Long id;
    @Size(max = 20, min = 3)
    @NotEmpty()
    private String sifre;
    
    @OneToOne
    @MapsId
    private Kisi kisi;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Rol> roller;
}