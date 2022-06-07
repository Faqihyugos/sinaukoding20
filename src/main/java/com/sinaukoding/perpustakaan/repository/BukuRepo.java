package com.sinaukoding.perpustakaan.repository;

import com.sinaukoding.perpustakaan.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BukuRepo extends JpaRepository<Buku, Integer> {
    List<Buku> findByJudulContainingAndPenulisContaining(String judul, String penulis);
}
