package com.example.demo.domain.listelement;

import com.example.demo.domain.listelement.dto.ListElementCreateDTO;
import com.example.demo.domain.listelement.dto.ListElementDTO;
import com.example.demo.domain.listelement.dto.ListElementMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/list-element")
public class ListElementController {
  private final ListElementService listElementService;
  private final ListElementMapper listElementMapper;

  @Autowired
  public ListElementController(ListElementService listElementService, ListElementMapper listElementMapper) {
    this.listElementService = listElementService;
    this.listElementMapper = listElementMapper;
  }

  @GetMapping("/{id}")
  @Operation(summary = "Show a list element by id", description = "Find and show a certain list element by id")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<ListElementDTO> retrieveById(@PathVariable UUID id) {
      ListElement listElement = listElementService.findById(id);
      return new ResponseEntity<>(listElementMapper.toDTO(listElement), HttpStatus.OK);
  }

  @PostMapping()
  @Operation(summary = "Create list element", description = "Creates a new list element in a existing list")
  @PreAuthorize("hasAuthority('LIST_ELEMENT_CREATE') && @listElementPermissionEvaluator.canCreate(authentication.principal.user, #listElementCreateDTO.getUserId())")
  public ResponseEntity<ListElementDTO> create(@Valid @RequestBody ListElementCreateDTO listElementCreateDTO) {
      ListElement listElement = listElementService.save(listElementMapper.fromListElementCreateDTO(listElementCreateDTO));
      return new ResponseEntity<>(listElementMapper.toDTO(listElement), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update a list element", description = "Finds and updates a certain list element by id")
  @PreAuthorize("hasAuthority('LIST_ELEMENT_MODIFY') and (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'USER') and @listElementPermissionEvaluator.isOwner(authentication.principal.user, #id)) or (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'ADMIN') and @listElementPermissionEvaluator.isNotOwner(authentication.principal.user, #id))")
  public ResponseEntity<ListElementDTO> updateById(@PathVariable UUID id, @Valid @RequestBody ListElementDTO listElementDTO) {
      ListElement listElement = listElementService.updateById(id, listElementMapper.fromDTO(listElementDTO));
      return new ResponseEntity<>(listElementMapper.toDTO(listElement), HttpStatus.OK);
  }


  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a list element", description = "Finds and deletes a certain list element by id")
  @PreAuthorize("hasAuthority('LIST_ELEMENT_DELETE') and (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'USER') and @listElementPermissionEvaluator.isOwner(authentication.principal.user, #id)) or (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'ADMIN') and @listElementPermissionEvaluator.isNotOwner(authentication.principal.user, #id))")
  public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
      listElementService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
