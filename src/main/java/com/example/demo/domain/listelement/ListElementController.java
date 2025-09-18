package com.example.demo.domain.listelement;

import com.example.demo.domain.list.ListService;
import com.example.demo.domain.list.dto.ListMapper;
import com.example.demo.domain.listelement.dto.ListElementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
