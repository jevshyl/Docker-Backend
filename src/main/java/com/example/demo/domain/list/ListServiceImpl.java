package com.example.demo.domain.list;

import com.example.demo.core.generic.AbstractServiceImpl;
import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleRepository;
import com.example.demo.domain.role.RoleService;
import com.example.demo.domain.user.User;
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
public class ListServiceImpl extends AbstractServiceImpl<List> implements ListService {

    @Autowired
    public ListServiceImpl(ListRepository repository) {
        super(repository);
    }

    @Override
    public List save(List entity) {
        return null;
    }

    @Override
    public List updateById(UUID id, List entity) throws NoSuchElementException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
