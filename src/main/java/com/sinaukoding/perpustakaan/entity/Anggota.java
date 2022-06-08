package com.sinaukoding.perpustakaan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "anggota")
@Getter
@Setter
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anggota")
    private Integer idAnggota;

    @Column(name="nama")
    private String nama;

    @Column(name="alamat")
    private String alamat;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "tgl_lahir")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglLahir;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @OneToMany(mappedBy = "anggota")
    private List<Pinjam> pinjamList = new ArrayList<>();

}
