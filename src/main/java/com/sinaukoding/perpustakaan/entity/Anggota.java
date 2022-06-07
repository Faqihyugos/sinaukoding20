package com.sinaukoding.perpustakaan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "anggota")
@Getter
@Setter
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anggota")
    private int idAnggota;

    @Column(name="nama")
    private String nama;

    @Column(name="alamat")
    private String alamat;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "tgl_lahir")
    private Date tglLahir;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

}
