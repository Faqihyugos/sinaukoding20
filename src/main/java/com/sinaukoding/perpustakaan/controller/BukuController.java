package com.sinaukoding.perpustakaan.controller;


import com.sinaukoding.perpustakaan.entity.dto.BukuDTO;
import com.sinaukoding.perpustakaan.service.BukuService;
import com.sinaukoding.perpustakaan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buku")
public class BukuController {
    @Autowired
    BukuService bukuService;

    // create
    @PostMapping()
    public Response createBuku(@RequestBody BukuDTO buku) {
         return new Response("Create successfully", HttpStatus.CREATED, bukuService.createBuku(buku));
    }

    // Read
    @GetMapping()
    public Response findAllBuku() {
        return new Response("Get Buku success", HttpStatus.OK ,bukuService.findAllBuku());
    }

    @GetMapping(value = "/find-by-judul")
    public Response findByJudulContainingAndPenulisContaining(
            @RequestParam(value = "judul") String judul,
            @RequestParam(value = "penulis", required = false) String penulis) {
        return new Response("Get Successfuly", HttpStatus.OK ,bukuService.findByJudulContainingAndPenulisContaining(judul, penulis));
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id) {
        return new Response("Get Successfuly", HttpStatus.OK,bukuService.findById(id));
    }

    // update
    @PutMapping(value = "/{id}")
    public Response updateBukuById(@RequestBody BukuDTO buku, @PathVariable int id) {
        return new Response("update Successfuly", HttpStatus.OK ,bukuService.updateBukuById(buku, id));
    }

    //Delete
    @DeleteMapping(value = "/{id}")
    public String deleteBukuById(@PathVariable int id){
        if(bukuService.deleteBukuById(id)){
            return "Data berhasil dihapus";
        }else{
            return "Data gagal dihapus";
        }
    }


}
