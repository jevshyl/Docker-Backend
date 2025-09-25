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
    @Mapping(target = "owner", source = "userId")
    ListElement fromListElementCreateDTO(@Valid ListElementCreateDTO listElementCreateDTO);

    ListElementDTO toDTO(ListElement listElement);

    default User map(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("UserId darf nicht null sein");
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}