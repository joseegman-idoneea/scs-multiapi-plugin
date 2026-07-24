package com.sngular.multifileplugin.openapi31completeness.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonDeserialize(builder = PersonDTO.PersonDTOBuilder.class)
public class PersonDTO {

  @JsonProperty(value ="name")
  private String name;

  private PersonDTO(PersonDTOBuilder builder) {
    this.name = builder.name;

  }

  public static PersonDTO.PersonDTOBuilder builder() {
    return new PersonDTO.PersonDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class PersonDTOBuilder {

    private String name;

    public PersonDTO.PersonDTOBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PersonDTO build() {
      PersonDTO personDTO = new PersonDTO(this);
      return personDTO;
    }
  }

  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonDTO personDTO = (PersonDTO) o;
    return Objects.equals(this.name, personDTO.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("PersonDTO{");
    sb.append(" name:").append(name);
    sb.append("}");
    return sb.toString();
  }


}
