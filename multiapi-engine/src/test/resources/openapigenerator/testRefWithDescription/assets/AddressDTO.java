package com.sngular.multifileplugin.refwithdescription.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonDeserialize(builder = AddressDTO.AddressDTOBuilder.class)
public class AddressDTO {

  @JsonProperty(value ="city")
  private String city;
  @JsonProperty(value ="street")
  private String street;

  private AddressDTO(AddressDTOBuilder builder) {
    this.city = builder.city;
    this.street = builder.street;

  }

  public static AddressDTO.AddressDTOBuilder builder() {
    return new AddressDTO.AddressDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class AddressDTOBuilder {

    private String city;
    private String street;

    public AddressDTO.AddressDTOBuilder city(String city) {
      this.city = city;
      return this;
    }

    public AddressDTO.AddressDTOBuilder street(String street) {
      this.street = street;
      return this;
    }

    public AddressDTO build() {
      AddressDTO addressDTO = new AddressDTO(this);
      return addressDTO;
    }
  }

  @Schema(name = "city", required = false)
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }

  @Schema(name = "street", required = false)
  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressDTO addressDTO = (AddressDTO) o;
    return Objects.equals(this.city, addressDTO.city) && Objects.equals(this.street, addressDTO.street);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, street);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("AddressDTO{");
    sb.append(" city:").append(city).append(",");
    sb.append(" street:").append(street);
    sb.append("}");
    return sb.toString();
  }


}
