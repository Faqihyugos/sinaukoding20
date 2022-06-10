package com.sinaukoding.perpustakaan.service;

import com.sinaukoding.perpustakaan.entity.Buku;
import com.sinaukoding.perpustakaan.entity.dto.BukuDTO;
import com.sinaukoding.perpustakaan.entity.mapper.BukuMapper;
import com.sinaukoding.perpustakaan.repository.BukuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {

    @Autowired
    BukuRepo bukuRepo;


    // find by judul and penulis
    public List<BukuDTO> findByJudulContainingAndPenulisContaining(String judul, String penulis) {
        return BukuMapper.INSTANCE.toDtoList(bukuRepo.findByJudulContainingAndPenulisContaining(judul, penulis));
    }

    // create
    public BukuDTO createBuku(BukuDTO bukuDTO) {
        Buku buku = bukuRepo.save(BukuMapper.INSTANCE.toEntity(bukuDTO));
        return BukuMapper.INSTANCE.toDto(buku);
    }

    // read
    public List<BukuDTO> findAllBuku() {
        return BukuMapper.INSTANCE.toDtoList(bukuRepo.findAll());
    }

    // find by id
    public BukuDTO findById(Integer id){
        return BukuMapper.INSTANCE.toDto(bukuRepo.findById(id).get());
    }

    //update
    public BukuDTO updateBukuById(BukuDTO bukuDTO, int id) {
        Buku reference = bukuRepo.findById(id).get();
        reference.setJudul(bukuDTO.getJudul()!=null?bukuDTO.getJudul():reference.getJudul());
        reference.setPenulis(bukuDTO.getPenulis()!=null?bukuDTO.getPenulis():reference.getPenulis());
        reference.setPenerbit(bukuDTO.getPenerbit()!=null?bukuDTO.getPenerbit():reference.getPenerbit());
        reference.setTahunTerbit(bukuDTO.getTahunTerbit()!=null?bukuDTO.getTahunTerbit():reference.getTahunTerbit());
        reference.setJenisBuku(bukuDTO.getJenisBuku()!=null?bukuDTO.getJenisBuku():reference.getJenisBuku());
        return BukuMapper.INSTANCE.toDto(bukuRepo.save(reference));
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
