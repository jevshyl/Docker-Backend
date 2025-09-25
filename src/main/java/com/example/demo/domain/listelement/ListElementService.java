package com.example.demo.domain.listelement;

import com.example.demo.core.generic.AbstractService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ListElementService extends UserDetailsService, AbstractService<ListElement> {
}
