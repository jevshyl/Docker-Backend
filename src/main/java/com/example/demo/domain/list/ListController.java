package com.example.demo.domain.list;

import com.example.demo.domain.list.dto.ListMapper;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.user.dto.UserDTO;
import com.example.demo.domain.user.dto.UserMapper;
import com.example.demo.domain.user.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/list")
public class ListController {

  private final ListService listService;
  private final ListMapper listMapper;

  @Autowired
  public ListController(ListService listService, ListMapper listMapper) {
    this.listService = listService;
    this.listMapper = listMapper;
  }

}
