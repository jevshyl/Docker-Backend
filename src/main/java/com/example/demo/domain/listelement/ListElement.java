package com.example.demo.domain.listelement;

import com.example.demo.core.generic.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

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
    @NotNull
    private Importance importance;

    @Column(name = "creation_date", nullable = false)
    @NotNull
    private LocalDate creationDate;

    @JoinColumn(name = "list_id", nullable = false)
    @ManyToOne
    @NotNull
    private Account list_id;

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
