package com.sngular.multifileplugin.testmodelpackagedefault.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonDeserialize(builder = Thing.ThingBuilder.class)
public class Thing {

  @JsonProperty(value ="name")
  private String name;
  @JsonProperty(value ="count")
  private Integer count;

  private Thing(ThingBuilder builder) {
    this.name = builder.name;
    this.count = builder.count;

  }

  public static Thing.ThingBuilder builder() {
    return new Thing.ThingBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class ThingBuilder {

    private String name;
    private Integer count;

    public Thing.ThingBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Thing.ThingBuilder count(Integer count) {
      this.count = count;
      return this;
    }

    public Thing build() {
      Thing thing = new Thing(this);
      return thing;
    }
  }

  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Schema(name = "count", required = false)
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Thing thing = (Thing) o;
    return Objects.equals(this.name, thing.name) && Objects.equals(this.count, thing.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Thing{");
    sb.append(" name:").append(name).append(",");
    sb.append(" count:").append(count);
    sb.append("}");
    return sb.toString();
  }


}
