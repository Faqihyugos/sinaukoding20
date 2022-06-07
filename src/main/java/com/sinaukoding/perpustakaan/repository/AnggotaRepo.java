package com.sinaukoding.perpustakaan.repository;

import com.sinaukoding.perpustakaan.entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnggotaRepo extends JpaRepository<Anggota, Integer> {
    List<Anggota> findByNamaContaining(String nama);
}
