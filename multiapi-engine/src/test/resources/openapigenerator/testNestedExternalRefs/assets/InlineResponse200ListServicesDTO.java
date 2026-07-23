package com.sngular.multifileplugin.testnestedexternalref.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
public class InlineResponse200ListServicesDTO {

  @JsonProperty(value ="service_id")
  private String service_id;

  @JsonProperty(value ="service_type")
  private Service_typeDTO service_type;


  @Builder
  @Jacksonized
  private InlineResponse200ListServicesDTO(String service_id, Service_typeDTO service_type) {
    this.service_id = service_id;
    this.service_type = service_type;

  }

}
