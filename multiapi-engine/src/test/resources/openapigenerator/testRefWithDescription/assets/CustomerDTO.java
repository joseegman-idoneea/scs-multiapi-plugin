package com.sngular.multifileplugin.refwithdescription.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonDeserialize(builder = CustomerDTO.CustomerDTOBuilder.class)
public class CustomerDTO {

  @JsonProperty(value ="name")
  private String name;
  @JsonProperty(value ="email")
  private String email;

  private CustomerDTO(CustomerDTOBuilder builder) {
    this.name = builder.name;
    this.email = builder.email;

  }

  public static CustomerDTO.CustomerDTOBuilder builder() {
    return new CustomerDTO.CustomerDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class CustomerDTOBuilder {

    private String name;
    private String email;

    public CustomerDTO.CustomerDTOBuilder name(String name) {
      this.name = name;
      return this;
    }

    public CustomerDTO.CustomerDTOBuilder email(String email) {
      this.email = email;
      return this;
    }

    public CustomerDTO build() {
      CustomerDTO customerDTO = new CustomerDTO(this);
      return customerDTO;
    }
  }

  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Schema(name = "email", required = false)
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTO customerDTO = (CustomerDTO) o;
    return Objects.equals(this.name, customerDTO.name) && Objects.equals(this.email, customerDTO.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("CustomerDTO{");
    sb.append(" name:").append(name).append(",");
    sb.append(" email:").append(email);
    sb.append("}");
    return sb.toString();
  }


}
