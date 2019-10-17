package com.cngl.bilet.repository;

import com.cngl.bilet.entity.Kullanici;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * KullaniciRepository
 */
public interface KullaniciRepository extends JpaRepository<Kullanici,Long>{

    
}