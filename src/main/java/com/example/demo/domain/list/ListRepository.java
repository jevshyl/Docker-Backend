package com.example.demo.domain.list;

import com.example.demo.core.generic.AbstractRepository;
import com.example.demo.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListRepository extends AbstractRepository<List> {

}
