package com.sinaukoding.perpustakaan.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinaukoding.perpustakaan.entity.Pinjam;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class AnggotaDTO {
    private Integer idAnggota;
    private String nama;
    private String alamat;
    private String noTelp;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglLahir;
    private String jenisKelamin;
    private List<Pinjam> pinjamList = new ArrayList<>();
}
