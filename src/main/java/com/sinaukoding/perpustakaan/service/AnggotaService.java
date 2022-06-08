package com.sinaukoding.perpustakaan.service;

import com.sinaukoding.perpustakaan.entity.Anggota;
import com.sinaukoding.perpustakaan.repository.AnggotaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaService {

    @Autowired
    AnggotaRepo anggotaRepo;

    // find by name
    public List<Anggota> findByNamaContaining(String nama) {
        return anggotaRepo.findByNamaContaining(nama);
    }

    //Create
    public Anggota createAnggota(Anggota anggota){
        return anggotaRepo.save(anggota);
    }

    //Read
    public List<Anggota> findAllAnggota(){
        return anggotaRepo.findAll();
    }

    // find by id
    public Anggota findById(Integer id){
        return anggotaRepo.findById(id).get();
    }

    // update
    public Anggota updateAnggotaById(Anggota anggota, int id) {
        Anggota reference = anggotaRepo.findById(id).get();
        reference.setNama(anggota.getNama()!=null?anggota.getNama():reference.getNama());
        reference.setAlamat(anggota.getAlamat()!=null?anggota.getAlamat():reference.getAlamat());
        reference.setNoTelp(anggota.getNoTelp()!=null?anggota.getNoTelp():reference.getNoTelp());
        reference.setTglLahir(anggota.getTglLahir()!=null?anggota.getTglLahir():reference.getTglLahir());
        reference.setJenisKelamin(anggota.getJenisKelamin()!=null?anggota.getJenisKelamin(): reference.getJenisKelamin());
        return anggotaRepo.save(reference);
    }

    //Delete
    public Boolean deleteAnggotaById(int id){
        Anggota reference = anggotaRepo.findById(id).orElse(null);
        if(reference != null){
            anggotaRepo.delete(reference);
            return true;
        }else{
            return false;
        }
    }

}
