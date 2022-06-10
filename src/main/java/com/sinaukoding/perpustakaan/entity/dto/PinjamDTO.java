package com.sinaukoding.perpustakaan.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sinaukoding.perpustakaan.entity.Anggota;
import com.sinaukoding.perpustakaan.entity.Buku;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PinjamDTO {
    private Integer idPinjam;
    @JsonIgnoreProperties(value = {"pinjamList","handler","hibernateLazyInitializer"},allowSetters = true)
    private Buku buku;
    @JsonIgnoreProperties(value = {"pinjamList","handler","hibernateLazyInitializer"},allowSetters = true)
    private Anggota anggota;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglPinjam;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglKembali;
}
