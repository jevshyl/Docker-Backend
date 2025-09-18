package com.example.demo.domain.list;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.listelement.ListElement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.constraints.Length;

import java.util.Set;
import java.util.UUID;

@Log4j2
@Entity
@Table(name = "list")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class List extends AbstractEntity {

    public List(UUID id) {
        super(id);
    }

    @Column(nullable = false, length = 254)
    @NotBlank(message = "Title cannot be empty")
    @Length(max = 254, message = "The title can't be longer than 254 characters")
    private String title;

    @OneToMany(mappedBy = "list_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ListElement> listElements;

    public List(UUID id, String title, Set<ListElement> listElements) {
        super(id);
        this.title = title;
        this.listElements = listElements;
    }

    @PostPersist
    public void logNewUserAdded(){
        log.info("Created list '" + title + "' with ID: " + super.getId());
    }
}
