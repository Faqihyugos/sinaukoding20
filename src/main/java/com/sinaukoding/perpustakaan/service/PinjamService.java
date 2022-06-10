package com.sinaukoding.perpustakaan.service;

import com.sinaukoding.perpustakaan.entity.Pinjam;
import com.sinaukoding.perpustakaan.entity.dto.PinjamDTO;
import com.sinaukoding.perpustakaan.entity.mapper.PinjamMapper;
import com.sinaukoding.perpustakaan.repository.PinjamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PinjamService {

    @Autowired
    PinjamRepo pinjamRepo;

    // create
    public PinjamDTO createPinjam(PinjamDTO pinjamDTO) {
        Pinjam pinjam = pinjamRepo.save(PinjamMapper.INSTANCE.toEntity(pinjamDTO));
        return PinjamMapper.INSTANCE.toDto(pinjam);
    }

    public List<PinjamDTO> findAll() {
        return PinjamMapper.INSTANCE.toDtoList(pinjamRepo.findAll());
    }

    // find by id
    public PinjamDTO findById(Integer id){
        return PinjamMapper.INSTANCE.toDto(pinjamRepo.findById(id).get());
    }

    //Update
    public PinjamDTO updatePinjamById(PinjamDTO pinjam, int id){
        Pinjam reference = pinjamRepo.findById(id).get();
        reference.setAnggota(pinjam.getAnggota()!=null?pinjam.getAnggota():reference.getAnggota());
        reference.setBuku(pinjam.getBuku()!=null?pinjam.getBuku():reference.getBuku());
        reference.setTglPinjam(pinjam.getTglPinjam()!=null?pinjam.getTglPinjam():reference.getTglPinjam());
        reference.setTglKembali(pinjam.getTglKembali()!=null?pinjam.getTglKembali():reference.getTglKembali());
        return PinjamMapper.INSTANCE.toDto(pinjamRepo.save(reference));
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
