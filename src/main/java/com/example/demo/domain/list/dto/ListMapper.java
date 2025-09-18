package com.example.demo.domain.list.dto;

import com.example.demo.core.generic.AbstractMapper;
import com.example.demo.domain.list.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListMapper extends AbstractMapper<List, ListDTO> {

}
