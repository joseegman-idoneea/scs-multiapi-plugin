package com.sngular.scsplugin.streetlights.model.event;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.sngular.scsplugin.streetlights.model.event.customvalidator.MinInteger;

@JsonDeserialize(builder = LightMeasuredPayloadDTO.LightMeasuredPayloadDTOBuilder.class)
public class LightMeasuredPayloadDTO {

  @JsonProperty(value ="sentAt")
  private Object sentAt;
  @JsonProperty(value ="lumens")
  @MinInteger(minimum = "0", exclusive = false)
  private Integer lumens;

  private LightMeasuredPayloadDTO(LightMeasuredPayloadDTOBuilder builder) {
    this.sentAt = builder.sentAt;
    this.lumens = builder.lumens;

  }

  public static LightMeasuredPayloadDTO.LightMeasuredPayloadDTOBuilder builder() {
    return new LightMeasuredPayloadDTO.LightMeasuredPayloadDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class LightMeasuredPayloadDTOBuilder {

    private Object sentAt;
    private Integer lumens;

    public LightMeasuredPayloadDTO.LightMeasuredPayloadDTOBuilder sentAt(Object sentAt) {
      this.sentAt = sentAt;
      return this;
    }

    public LightMeasuredPayloadDTO.LightMeasuredPayloadDTOBuilder lumens(Integer lumens) {
      this.lumens = lumens;
      return this;
    }

    public LightMeasuredPayloadDTO build() {
      LightMeasuredPayloadDTO lightMeasuredPayloadDTO = new LightMeasuredPayloadDTO(this);
      return lightMeasuredPayloadDTO;
    }
  }

  @Schema(name = "sentAt", required = false)
  public Object getSentAt() {
    return sentAt;
  }
  public void setSentAt(Object sentAt) {
    this.sentAt = sentAt;
  }

  @Schema(name = "lumens", required = false, description = "Light intensity measured in lumens.")
  public Integer getLumens() {
    return lumens;
  }
  public void setLumens(Integer lumens) {
    this.lumens = lumens;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LightMeasuredPayloadDTO lightMeasuredPayloadDTO = (LightMeasuredPayloadDTO) o;
    return Objects.equals(this.sentAt, lightMeasuredPayloadDTO.sentAt) && Objects.equals(this.lumens, lightMeasuredPayloadDTO.lumens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sentAt, lumens);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("LightMeasuredPayloadDTO{");
    sb.append(" sentAt:").append(sentAt).append(",");
    sb.append(" lumens:").append(lumens);
    sb.append("}");
    return sb.toString();
  }


}
