package com.sngular.multifileplugin.testnestedexternalref.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
public class Service_typeDTO {

  @JsonProperty(value ="type_code")
  private Integer type_code;

  @JsonProperty(value ="type_name")
  private String type_name;


  @Builder
  @Jacksonized
  private Service_typeDTO(Integer type_code, String type_name) {
    this.type_code = type_code;
    this.type_name = type_name;

  }

}
