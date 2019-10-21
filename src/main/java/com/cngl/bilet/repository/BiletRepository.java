package com.cngl.bilet.repository;

import java.util.Optional;

import com.cngl.bilet.entity.Bilet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BiletRepository extends JpaRepository<Bilet, Long> {

    public Optional<Bilet> findByPnr(String pnr);

}