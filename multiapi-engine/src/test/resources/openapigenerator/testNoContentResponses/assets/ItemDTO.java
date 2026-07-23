package com.sngular.multifileplugin.testnocontentresponses.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
public class ItemDTO {

  @JsonProperty(value ="name")
  private String name;

  @JsonProperty(value ="id")
  private Integer id;


  @Builder
  @Jacksonized
  private ItemDTO(String name, Integer id) {
    this.name = name;
    this.id = id;

  }

}
