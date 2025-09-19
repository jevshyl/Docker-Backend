package com.example.demo.domain.listelement;

import com.example.demo.core.generic.AbstractServiceImpl;
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

    @Override
    public ListElement create(Object o) {
        return null;
    }
}

/*
  @Autowired
  public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, RoleService roleService) {
    super(repository);
    this.passwordEncoder = passwordEncoder;
      this.roleService = roleService;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return ((UserRepository) repository).findByEmail(email)
                                        .map(UserDetailsImpl::new)
                                        .orElseThrow(() -> new UsernameNotFoundException(email));
  }

  @Override
  public User register(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    Role defaultRole=roleService.findById(UUID.fromString("d29e709c-0ff1-4f4c-a7ef-09f656c390f1"));//Default role
    user.setRoles(Set.of(defaultRole));
    return save(user);
  }
  @Override
  //This Method can be used for development and testing. the Password for the user will be set to "1234"
  public User registerUser(User user){
    user.setPassword(passwordEncoder.encode("1234"));
    return save(user);
  }

}
*/