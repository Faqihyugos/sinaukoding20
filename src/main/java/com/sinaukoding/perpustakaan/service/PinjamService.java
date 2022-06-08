package com.sinaukoding.perpustakaan.service;

import com.sinaukoding.perpustakaan.entity.Anggota;
import com.sinaukoding.perpustakaan.entity.Buku;
import com.sinaukoding.perpustakaan.entity.Pinjam;
import com.sinaukoding.perpustakaan.repository.PinjamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PinjamService {

    @Autowired
    PinjamRepo pinjamRepo;

    // create
    public Pinjam createPinjam(Pinjam param) {
        return pinjamRepo.save(param);
    }

    public List<Pinjam> findAll() {
        return pinjamRepo.findAll();
    }

    // find by id
    public Pinjam findById(Integer id){
        return pinjamRepo.findById(id).get();
    }

    //Update
    public Pinjam updatePinjamById(Pinjam pinjam, int id){
        Pinjam reference = pinjamRepo.findById(id).get();
        reference.setAnggota(pinjam.getAnggota()!=null?pinjam.getAnggota():reference.getAnggota());
        reference.setBuku(pinjam.getBuku()!=null?pinjam.getBuku():reference.getBuku());
        reference.setTglPinjam(pinjam.getTglPinjam()!=null?pinjam.getTglPinjam():reference.getTglPinjam());
        reference.setTglKembali(pinjam.getTglKembali()!=null?pinjam.getTglKembali():reference.getTglKembali());
        return pinjamRepo.save(reference);
    }

    //Delete
    public Boolean deletePinjamById(int id){
        Pinjam reference = pinjamRepo.findById(id).orElse(null);
        if(reference != null){
            pinjamRepo.delete(reference);
            return true;
        }else{
            return false;
        }
    }
}
