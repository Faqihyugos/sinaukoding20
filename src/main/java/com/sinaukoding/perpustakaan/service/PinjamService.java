package com.sinaukoding.perpustakaan.service;

import com.sinaukoding.perpustakaan.entity.Pinjam;
import com.sinaukoding.perpustakaan.repository.PinjamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinjamService {

    @Autowired
    PinjamRepo pinjamRepo;

    // create
    public Pinjam createPinjam(Pinjam param) {
        return pinjamRepo.save(param);
    }

    
}
