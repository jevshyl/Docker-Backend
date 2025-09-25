package com.example.demo.domain.listelement;

import com.example.demo.core.generic.AbstractServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Getter@Setter
@Service
public class ListElementServiceImpl extends AbstractServiceImpl<ListElement> implements ListElementService {

    private final UserDetailsService userDetailsService;

    public ListElementServiceImpl(ListElementRepository repository, @Lazy @Qualifier("userServiceImpl") UserDetailsService userDetailsService) {
        super(repository);
        this.userDetailsService = userDetailsService;
    }

    @Override
    public ListElement updateById(UUID id, ListElement incoming) {
        ListElement existing = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format("List Element with ID '%s' could not be found", id)));
        existing.setTitle(incoming.getTitle());
        existing.setText(incoming.getText());
        existing.setImportance(incoming.getImportance());
        existing.setCreationDate(incoming.getCreationDate());
        return repository.save(existing);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsService.loadUserByUsername(username);
    }
}
