package com.sngular.multifileplugin.webhookpathcollision.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonDeserialize(builder = PetDTO.PetDTOBuilder.class)
public class PetDTO {

  @JsonProperty(value ="name")
  private String name;
  @JsonProperty(value ="id")
  private Long id;

  private PetDTO(PetDTOBuilder builder) {
    this.name = builder.name;
    this.id = builder.id;

  }

  public static PetDTO.PetDTOBuilder builder() {
    return new PetDTO.PetDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class PetDTOBuilder {

    private String name;
    private Long id;

    public PetDTO.PetDTOBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PetDTO.PetDTOBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public PetDTO build() {
      PetDTO petDTO = new PetDTO(this);
      return petDTO;
    }
  }

  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PetDTO petDTO = (PetDTO) o;
    return Objects.equals(this.name, petDTO.name) && Objects.equals(this.id, petDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("PetDTO{");
    sb.append(" name:").append(name).append(",");
    sb.append(" id:").append(id);
    sb.append("}");
    return sb.toString();
  }


}
