package com.example.demo.domain.listelement.dto;

import com.example.demo.core.generic.AbstractMapper;
import com.example.demo.domain.list.List;
import com.example.demo.domain.listelement.ListElement;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListElementMapper extends AbstractMapper<ListElement, ListElementDTO> {
    @Mapping(target = "list", source = "listId") // UUID -> List
    ListElement fromListElementCreateDTO(@Valid ListElementCreateDTO listElementCreateDTO);

    @Mapping(target = "id", source = "list.id")
    ListElementDTO toDTO(ListElement listElement);

    default List map(UUID id) {
        if (id == null) return null; // todo: exception handling
        List list = new List();
        list.setId(id);
        return list;
    }
}