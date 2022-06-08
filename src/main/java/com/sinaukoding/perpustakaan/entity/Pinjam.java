package com.sinaukoding.perpustakaan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pinjam")
@Getter
@Setter
public class Pinjam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pinjam")
    private Integer idPinjam;

    @JsonIgnoreProperties(value = {"pinjamList","handler","hibernateLazyInitializer"},allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_buku")
    private Buku buku;

    @JsonIgnoreProperties(value = {"pinjamList","handler","hibernateLazyInitializer"},allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_anggota")
    private Anggota anggota;

    @Column(name = "tgl_pinjam")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglPinjam;

    @Column(name = "tgl_kembali")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglKembali;

}
