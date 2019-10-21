package com.cngl.bilet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="roller")
@AllArgsConstructor
@NoArgsConstructor
public class Rol implements Serializable {

    private static final long serialVersionUID = -510215468574428445L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;
    @Size(max = 50, min = 2)
    @NotEmpty()
    private String isim;

    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "roller")
    private List<Kullanici> kulanicilar; 
}