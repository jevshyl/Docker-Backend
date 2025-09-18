package com.example.demo.domain.listelement;

import com.example.demo.core.generic.AbstractServiceImpl;
import com.example.demo.domain.list.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Getter@Setter
@Service
public class ListElementServiceImpl extends AbstractServiceImpl<ListElement> implements ListElementService {

    @Autowired
    public ListElementServiceImpl(ListElementRepository repository) {
        super(repository);
    }

    @Override
    public ListElement save(ListElement entity) {
        return null;
    }

    @Override
    public ListElement updateById(UUID id, ListElement entity) throws NoSuchElementException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
