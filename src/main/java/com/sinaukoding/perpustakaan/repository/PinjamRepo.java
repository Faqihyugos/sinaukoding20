package com.sinaukoding.perpustakaan.repository;

import com.sinaukoding.perpustakaan.entity.Pinjam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PinjamRepo extends JpaRepository<Pinjam, Integer> {
}
