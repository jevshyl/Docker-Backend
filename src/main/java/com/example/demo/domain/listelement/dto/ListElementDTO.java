package com.example.demo.domain.listelement.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.listelement.Importance;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ListElementDTO extends AbstractDTO {

    @NotBlank(message = "The title element cannot be empty")
    @Length(max = 254, message = "The title can't be longer than 254 characters")
    private String title;

    @NotBlank(message = "The list element cannot be empty")
    private String text;

    @NotNull
    private Importance importance;

    @NotNull
    private LocalDate creationDate;

    public ListElementDTO(UUID id, String title, String text, Importance importance, LocalDate creationDate) {
        super(id);
        this.title = title;
        this.text = text;
        this.importance = importance;
        this.creationDate = creationDate;
    }
}
