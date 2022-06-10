package com.sinaukoding.perpustakaan.controller;

import com.sinaukoding.perpustakaan.entity.dto.PinjamDTO;
import com.sinaukoding.perpustakaan.service.PinjamService;
import com.sinaukoding.perpustakaan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "pinjam")
public class PinjamController {

    @Autowired
    PinjamService pinjamService;

    @PostMapping
    public Response createPinjam(@RequestBody PinjamDTO pinjam){
        return new Response("Create successfully", HttpStatus.CREATED, pinjamService.createPinjam(pinjam));

    }

    // Read
    @GetMapping()
    public Response findAllBuku() {
        return new Response( "Get All success", HttpStatus.OK, pinjamService.findAll());
    }

    // find by id
    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id) {
        return new Response("Get Successfuly", HttpStatus.OK,pinjamService.findById(id));
    }

    // update
    @PutMapping(value = "/{id}")
    public Response updateBukuById(@RequestBody PinjamDTO pinjam, @PathVariable int id) {
        return new Response("update Successfuly", HttpStatus.OK,pinjamService.updatePinjamById(pinjam, id));
    }

    //Delete
    @DeleteMapping(value = "/{id}")
    public String deleteBukuById(@PathVariable int id){
        if(pinjamService.deletePinjamById(id)){
            return "Data berhasil dihapus";
        }else{
            return "Data gagal dihapus";
        }
    }
}
