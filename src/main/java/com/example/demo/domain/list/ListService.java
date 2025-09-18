package com.example.demo.domain.list;

import com.example.demo.core.generic.AbstractService;
import com.example.demo.domain.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ListService extends UserDetailsService, AbstractService<List> {

}
