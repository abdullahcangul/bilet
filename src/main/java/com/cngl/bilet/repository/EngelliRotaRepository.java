package com.cngl.bilet.repository;

import java.util.Optional;

import com.cngl.bilet.entity.EngelliRota;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EngelliRotaRepository extends JpaRepository<EngelliRota,Long>{

    Optional<EngelliRota> findByKalkisHavaAlaniIdAndVarisHavaAlaniId(Long gidisHavaAlaniId,Long kalkisHavaAlaniId);
}