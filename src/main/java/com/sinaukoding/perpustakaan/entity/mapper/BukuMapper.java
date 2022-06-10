package com.sinaukoding.perpustakaan.entity.mapper;

import com.sinaukoding.perpustakaan.entity.Buku;
import com.sinaukoding.perpustakaan.entity.dto.BukuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BukuMapper {
    BukuMapper INSTANCE = Mappers.getMapper(BukuMapper.class);

    BukuDTO toDto(Buku buku);
    List<BukuDTO> toDtoList(List<Buku> buku);

    Buku toEntity(BukuDTO bukuDTO);
}
