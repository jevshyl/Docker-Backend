package com.example.demo.domain.listelement;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.constraints.Length;
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
    @Column(name = "title", nullable = false)
    @NotBlank(message = "The title element cannot be empty")
    @Length(max = 254, message = "The title can't be longer than 254 characters")
    private String title;

    @Column(name = "text", nullable = false)
    @NotBlank(message = "The list element cannot be empty")
    private String text;

    @Column (name = "importance", nullable = false)
    @Enumerated(EnumType.STRING)
    private Importance importance;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User owner;

    public ListElement(UUID id, String title, String text, Importance importance) {
        super(id);
        this.title = title;
        this.text = text;
        this.importance = importance;
        this.creationDate = LocalDate.now();
    }

    @PostPersist
    public void logNewUserAdded(){
        log.info("Created list element '{}' with ID: {}", text, super.getId());
    }
}
