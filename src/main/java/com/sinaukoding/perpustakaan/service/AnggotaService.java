package com.sinaukoding.perpustakaan.service;

import com.sinaukoding.perpustakaan.entity.Anggota;
import com.sinaukoding.perpustakaan.entity.dto.AnggotaDTO;
import com.sinaukoding.perpustakaan.entity.mapper.AnggotaMapper;
import com.sinaukoding.perpustakaan.entity.mapper.BukuMapper;
import com.sinaukoding.perpustakaan.repository.AnggotaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaService {

    @Autowired
    AnggotaRepo anggotaRepo;

    // find by name
    public List<AnggotaDTO> findByNamaContaining(String nama) {
        return AnggotaMapper.INSTANCE.toDtoList(anggotaRepo.findByNamaContaining(nama));
    }

    //Create
    public AnggotaDTO createAnggota(AnggotaDTO anggotaDTO){
        Anggota anggota = anggotaRepo.save(AnggotaMapper.INSTANCE.toEntity(anggotaDTO));
        return AnggotaMapper.INSTANCE.toDto(anggota);
    }

    //Read
    public List<AnggotaDTO> findAllAnggota(){
        return AnggotaMapper.INSTANCE.toDtoList(anggotaRepo.findAll());
    }

    // find by id
    public AnggotaDTO findById(Integer id){
        return AnggotaMapper.INSTANCE.toDto(anggotaRepo.findById(id).get());
    }

    // update
    public AnggotaDTO updateAnggotaById(AnggotaDTO anggota, int id) {
        Anggota reference = anggotaRepo.findById(id).get();
        reference.setNama(anggota.getNama()!=null?anggota.getNama():reference.getNama());
        reference.setAlamat(anggota.getAlamat()!=null?anggota.getAlamat():reference.getAlamat());
        reference.setNoTelp(anggota.getNoTelp()!=null?anggota.getNoTelp():reference.getNoTelp());
        reference.setTglLahir(anggota.getTglLahir()!=null?anggota.getTglLahir():reference.getTglLahir());
        reference.setJenisKelamin(anggota.getJenisKelamin()!=null?anggota.getJenisKelamin(): reference.getJenisKelamin());
        return AnggotaMapper.INSTANCE.toDto(anggotaRepo.save(reference));

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
