package com.example.demo.domain.listelement.dto;

import com.example.demo.core.generic.AbstractMapper;
import com.example.demo.domain.list.List;
import com.example.demo.domain.listelement.ListElement;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.dto.UserDTO;
import com.example.demo.domain.user.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListElementMapper extends AbstractMapper<ListElement, ListElementDTO> {
    Object fromListElmentCreateDTO(@Valid ListElementCreateDTO listElementCreateDTO);
}