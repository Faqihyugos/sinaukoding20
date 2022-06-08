package com.sinaukoding.perpustakaan.controller;

import com.sinaukoding.perpustakaan.entity.Pinjam;
import com.sinaukoding.perpustakaan.service.PinjamService;
import com.sinaukoding.perpustakaan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pinjam")
public class PinjamController {

    @Autowired
    PinjamService pinjamService;

    @PostMapping
    public Response createPinjam(@RequestBody Pinjam pinjam){
        return new Response(pinjamService.createPinjam(pinjam), "Create successfully", HttpStatus.CREATED);

    }
}
