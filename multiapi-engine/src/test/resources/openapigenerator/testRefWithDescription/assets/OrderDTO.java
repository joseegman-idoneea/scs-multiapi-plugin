package com.sngular.multifileplugin.refwithdescription.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonDeserialize(builder = OrderDTO.OrderDTOBuilder.class)
public class OrderDTO {

  @JsonProperty(value ="id")
  private String id;
  @JsonProperty(value ="customer")
  private CustomerDTO customer;
  @JsonProperty(value ="shippingAddress")
  private AddressDTO shippingAddress;

  private OrderDTO(OrderDTOBuilder builder) {
    this.id = builder.id;
    this.customer = builder.customer;
    this.shippingAddress = builder.shippingAddress;

  }

  public static OrderDTO.OrderDTOBuilder builder() {
    return new OrderDTO.OrderDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class OrderDTOBuilder {

    private String id;
    private CustomerDTO customer;
    private AddressDTO shippingAddress;

    public OrderDTO.OrderDTOBuilder id(String id) {
      this.id = id;
      return this;
    }

    public OrderDTO.OrderDTOBuilder customer(CustomerDTO customer) {
      this.customer = customer;
      return this;
    }

    public OrderDTO.OrderDTOBuilder shippingAddress(AddressDTO shippingAddress) {
      this.shippingAddress = shippingAddress;
      return this;
    }

    public OrderDTO build() {
      OrderDTO orderDTO = new OrderDTO(this);
      return orderDTO;
    }
  }

  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  @Schema(name = "customer", required = false, description = "The customer that placed the order")
  public CustomerDTO getCustomer() {
    return customer;
  }
  public void setCustomer(CustomerDTO customer) {
    this.customer = customer;
  }

  @Schema(name = "shippingAddress", required = false, description = "Where the order is shipped")
  public AddressDTO getShippingAddress() {
    return shippingAddress;
  }
  public void setShippingAddress(AddressDTO shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDTO orderDTO = (OrderDTO) o;
    return Objects.equals(this.id, orderDTO.id) && Objects.equals(this.customer, orderDTO.customer) && Objects.equals(this.shippingAddress, orderDTO.shippingAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, shippingAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("OrderDTO{");
    sb.append(" id:").append(id).append(",");
    sb.append(" customer:").append(customer).append(",");
    sb.append(" shippingAddress:").append(shippingAddress);
    sb.append("}");
    return sb.toString();
  }


}
