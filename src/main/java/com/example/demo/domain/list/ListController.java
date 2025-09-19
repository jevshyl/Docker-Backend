package com.example.demo.domain.list;

import com.example.demo.domain.list.dto.ListDTO;
import com.example.demo.domain.list.dto.ListMapper;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.dto.UserDTO;
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

  @GetMapping("")
  public ResponseEntity<java.util.List<ListDTO>> retrieveAll() {
    List<com.example.demo.domain.list.List> lists = listService.findAll();
    return new ResponseEntity<>(listMapper.toDTOs(lists), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ListDTO> retrieveById(@PathVariable UUID id) {
    com.example.demo.domain.list.List list = listService.findById(id);
    return ResponseEntity.ok(listMapper.toDTO(list));
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAuthority('USER_MODIFY') && @userPermissionEvaluator.exampleEvaluator(authentication.principal.user,#id)")
  public ResponseEntity<ListDTO> updateById(@PathVariable UUID id, @Valid @RequestBody ListDTO listDTO) {
    com.example.demo.domain.list.List list = listService.updateById(id, listMapper.fromDTO(listDTO));
    return new ResponseEntity<>(listMapper.toDTO(list), HttpStatus.OK);
  }


}
