package com.sinaukoding.perpustakaan.controller;

import com.sinaukoding.perpustakaan.entity.Buku;
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
    public Response createBuku(@RequestBody Buku buku) {
         return new Response(bukuService.createBuku(buku), "Create successfully", HttpStatus.CREATED);
    }

    // Read
    @GetMapping()
    public Response findAllBuku() {
        return new Response(bukuService.findAllBuku(), "Get Buku success", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-judul")
    public Response findByJudulContainingAndPenulisContaining(
            @RequestParam(value = "judul") String judul,
            @RequestParam(value = "penulis", required = false) String penulis) {
        List<Buku> findByJudul = bukuService.findByJudulContainingAndPenulisContaining(judul, penulis);
        return new Response(findByJudul, "Get Successfuly", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id) {
        return new Response(bukuService.findById(id), "Get Successfuly", HttpStatus.OK);
    }

    // update
    @PutMapping(value = "/{id}")
    public Response updateBukuById(@RequestBody Buku buku, @PathVariable int id) {
        return new Response(bukuService.updateBukuById(buku, id), "update Successfuly", HttpStatus.OK);
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
