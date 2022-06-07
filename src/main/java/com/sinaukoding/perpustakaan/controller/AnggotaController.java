package com.sinaukoding.perpustakaan.controller;

import com.sinaukoding.perpustakaan.entity.Anggota;
import com.sinaukoding.perpustakaan.entity.Buku;
import com.sinaukoding.perpustakaan.service.AnggotaService;
import com.sinaukoding.perpustakaan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/anggota")
public class AnggotaController {

    @Autowired
    AnggotaService anggotaService;
    //Create
    @PostMapping
    public Response createAnggota(@RequestBody Anggota anggota){
        return new Response(anggotaService.createAnggota(anggota), "Create successfully", HttpStatus.CREATED);

    }

    //Read
    @GetMapping
    public Response findAllAnggota(){
        return new Response(anggotaService.findAllAnggota(), "Data berhasil ditampilkan", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-nama")
    public Response findByJudulContainingAndPenulisContaining(
            @RequestParam(value = "nama") String nama) {
        List<Anggota> findByNama = anggotaService.findByNamaContaining(nama);
        return new Response(findByNama, "Get Successfuly", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id) {
        return new Response(anggotaService.findById(id), "Get Successfuly", HttpStatus.OK);
    }

    // update
    @PutMapping(value = "/{id}")
    public Response updateAnggotaById(@RequestBody Anggota anggota, @PathVariable int id) {
        return new Response(anggotaService.updateAnggotaById(anggota, id), "update Successfuly", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteAnggotaById(@PathVariable int id){
        if(anggotaService.deleteAnggotaById(id)) {
            return "Data berhasil dihapus";
        }else{
            return "Data gagal dihapus";
        }
    }


}
