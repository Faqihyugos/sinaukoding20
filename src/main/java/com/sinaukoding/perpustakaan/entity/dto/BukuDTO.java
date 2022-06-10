package com.sinaukoding.perpustakaan.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinaukoding.perpustakaan.entity.Pinjam;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class BukuDTO {
    private Integer idBuku;
    private String judul;
    private String penerbit;
    private String penulis;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tahunTerbit;
    private String jenisBuku;
    private List<Pinjam> pinjamList = new ArrayList<>();
}
