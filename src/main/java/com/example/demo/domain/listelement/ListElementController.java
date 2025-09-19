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
  public ResponseEntity<ListElementDTO> retrieveById(@PathVariable UUID id) {
      ListElement listElement = listElementService.findById(id);
      return new ResponseEntity<>(listElementMapper.toDTO(listElement), HttpStatus.OK);
  }

  @PostMapping()
  @PreAuthorize("hasAuthority('LIST_ELEMENT_CREATE') && @userPermissionEvaluator.exampleEvaluator(authentication.principal.user,#id)") // todo
  @Operation(summary = "Create list element", description = "Creates a new list element in a existing list")
  public ResponseEntity<ListElementDTO> register(@Valid @RequestBody ListElementCreateDTO listElementCreateDTO) {
      ListElement listElement = listElementService.create(listElementMapper.fromListElementCreateDTO(listElementCreateDTO));
      return new ResponseEntity<>(listElementMapper.toDTO(listElement), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAuthority('LIST_ELEMENT_MODIFY') && @userPermissionEvaluator.exampleEvaluator(authentication.principal.user,#id)") // todo
  @Operation(summary = "Update a list element", description = "Finds and updates a certain list element by id")
  public ResponseEntity<ListElementDTO> updateById(@PathVariable UUID id, @Valid @RequestBody ListElementDTO listElementDTO) {
      ListElement listElement = listElementService.updateById(id, listElementMapper.fromDTO(listElementDTO));
      return new ResponseEntity<>(listElementMapper.toDTO(listElement), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAuthority('LIST_ELEMENT_DELETE')") // todo
  @Operation(summary = "Delete a list element", description = "Finds and deletes a certain list element by id")
  public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
      listElementService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
