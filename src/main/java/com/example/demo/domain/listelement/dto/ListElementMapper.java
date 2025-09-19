package com.example.demo.domain.listelement.dto;

import com.example.demo.core.generic.AbstractMapper;
import com.example.demo.domain.listelement.ListElement;
import com.example.demo.domain.user.User;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListElementMapper extends AbstractMapper<ListElement, ListElementDTO> {
    @Mapping(target = "owner", source = "userId") // UUID -> List
    ListElement fromListElementCreateDTO(@Valid ListElementCreateDTO listElementCreateDTO);

    @Mapping(target = "id", source = "owner.id")
    ListElementDTO toDTO(ListElement listElement);

    default User map(UUID id) {
        if (id == null) return null; // todo: exception handling
        User user = new User();
        user.setId(id);
        return user;
    }
}