package com.example.demo.domain.listelement;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.list.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.UUID;

@Log4j2
@Entity
@Table(name = "list_element")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ListElement extends AbstractEntity {

    @Column(name = "text", nullable = false)
    @NotBlank(message = "The list element cannot be empty")
    private String text;

    @Column (name = "importance", nullable = false)
    @Enumerated(EnumType.STRING)
    private Importance importance;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @JoinColumn(name = "list_id", nullable = false)
    @ManyToOne
    private List listId;

    public ListElement(UUID id, String text, Importance importance, LocalDate creationDate) {
        super(id);
        this.text = text;
        this.importance = importance;
        this.creationDate = creationDate;
    }

    @PostPersist
    public void logNewUserAdded(){
        log.info("Created list element '" + text + "' with ID: " + super.getId());
    }
}
