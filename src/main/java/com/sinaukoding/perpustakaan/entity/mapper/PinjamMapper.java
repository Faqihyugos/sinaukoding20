package com.sinaukoding.perpustakaan.entity.mapper;

import com.sinaukoding.perpustakaan.entity.Pinjam;
import com.sinaukoding.perpustakaan.entity.dto.PinjamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PinjamMapper {
    PinjamMapper INSTANCE = Mappers.getMapper(PinjamMapper.class);

    PinjamDTO toDto(Pinjam pinjam);
    List<PinjamDTO> toDtoList(List<Pinjam> pinjam);
    Pinjam toEntity(PinjamDTO pinjamDTO);
}
