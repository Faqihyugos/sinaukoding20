package com.sinaukoding.perpustakaan.service;

import com.sinaukoding.perpustakaan.entity.Buku;
import com.sinaukoding.perpustakaan.repository.BukuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {

    @Autowired
    BukuRepo bukuRepo;

    // find by judul and penulis
    public List<Buku> findByJudulContainingAndPenulisContaining(String judul, String penulis) {
        return bukuRepo.findByJudulContainingAndPenulisContaining(judul, penulis);
    }

    // create
    public Buku createBuku(Buku buku) {
        return bukuRepo.save(buku);
    }

    // read
    public List<Buku> findAllBuku() {
        return bukuRepo.findAll();
    }

    // find by id
    public Buku findById(Integer id){
        return bukuRepo.findById(id).get();
    }

    //update
    public Buku updateBukuById(Buku buku, int id) {
        Buku reference = bukuRepo.findById(id).get();
        reference.setJudul(buku.getJudul()!=null?buku.getJudul():reference.getJudul());
        reference.setPenulis(buku.getPenulis()!=null?buku.getPenulis():reference.getPenulis());
        reference.setPenerbit(buku.getPenerbit()!=null?buku.getPenerbit():reference.getPenerbit());
        reference.setTahunTerbit(buku.getTahunTerbit()!=null?buku.getTahunTerbit():reference.getTahunTerbit());
        reference.setJenisBuku(buku.getJenisBuku()!=null?buku.getJenisBuku():reference.getJenisBuku());
        return bukuRepo.save(reference);
    }

    // delete
    public Boolean deleteBukuById(int id) {
        Buku reference = bukuRepo.findById(id).orElse(null);

        if(reference != null){
            bukuRepo.delete(reference);
            return true;
        }else{
            return false;
        }

    }
}
