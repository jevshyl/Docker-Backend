package com.example.demo.domain.list;

import com.example.demo.core.generic.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.UUID;

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

    // todo: @PrePersist and @PostPersist logs
}
