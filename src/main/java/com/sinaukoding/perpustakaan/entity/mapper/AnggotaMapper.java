package com.sinaukoding.perpustakaan.entity.mapper;

import com.sinaukoding.perpustakaan.entity.Anggota;
import com.sinaukoding.perpustakaan.entity.dto.AnggotaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnggotaMapper {
    AnggotaMapper INSTANCE = Mappers.getMapper(AnggotaMapper.class);

    AnggotaDTO toDto(Anggota anggota);
    List<AnggotaDTO> toDtoList(List<Anggota> anggota);

    Anggota toEntity(AnggotaDTO anggotaDTO);
}
