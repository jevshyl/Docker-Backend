package com.example.demo.domain.listelement;

import com.example.demo.core.generic.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Entity
@Table(name = "list_element")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ListElement extends AbstractEntity {


    public ListElement(UUID id) {
        super(id);
    }

    // todo: @PrePersist and @PostPersist logs

}
