package com.example.demo.domain.listelement.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.list.List;
import com.example.demo.domain.listelement.Importance;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ListElementCreateDTO extends AbstractDTO {
    @Column(name = "text", nullable = false)
    @NotBlank(message = "The list element cannot be empty")
    private String text;

    @Column (name = "importance", nullable = false)
    @Enumerated(EnumType.STRING)
    private Importance importance;

    @JoinColumn(name = "list_id", nullable = false)
    @ManyToOne
    private List listId;

    public ListElementCreateDTO(UUID id, String text, Importance importance) {
        super(id);
        this.text = text;
        this.importance = importance;
    }
}
