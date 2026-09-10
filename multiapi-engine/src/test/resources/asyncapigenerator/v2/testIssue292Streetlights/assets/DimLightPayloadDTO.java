package com.sngular.scsplugin.streetlights.model.event;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.sngular.scsplugin.streetlights.model.event.customvalidator.MaxInteger;
import com.sngular.scsplugin.streetlights.model.event.customvalidator.MinInteger;

@JsonDeserialize(builder = DimLightPayloadDTO.DimLightPayloadDTOBuilder.class)
public class DimLightPayloadDTO {

  @JsonProperty(value ="sentAt")
  private Object sentAt;
  @JsonProperty(value ="percentage")
  @MinInteger(minimum = "0", exclusive = false)
  @MaxInteger(maximum = "100", exclusive = false)
  private Integer percentage;

  private DimLightPayloadDTO(DimLightPayloadDTOBuilder builder) {
    this.sentAt = builder.sentAt;
    this.percentage = builder.percentage;

  }

  public static DimLightPayloadDTO.DimLightPayloadDTOBuilder builder() {
    return new DimLightPayloadDTO.DimLightPayloadDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class DimLightPayloadDTOBuilder {

    private Object sentAt;
    private Integer percentage;

    public DimLightPayloadDTO.DimLightPayloadDTOBuilder sentAt(Object sentAt) {
      this.sentAt = sentAt;
      return this;
    }

    public DimLightPayloadDTO.DimLightPayloadDTOBuilder percentage(Integer percentage) {
      this.percentage = percentage;
      return this;
    }

    public DimLightPayloadDTO build() {
      DimLightPayloadDTO dimLightPayloadDTO = new DimLightPayloadDTO(this);
      return dimLightPayloadDTO;
    }
  }

  @Schema(name = "sentAt", required = false)
  public Object getSentAt() {
    return sentAt;
  }
  public void setSentAt(Object sentAt) {
    this.sentAt = sentAt;
  }

  @Schema(name = "percentage", required = false, description = "Percentage to which the light should be dimmed to.")
  public Integer getPercentage() {
    return percentage;
  }
  public void setPercentage(Integer percentage) {
    this.percentage = percentage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DimLightPayloadDTO dimLightPayloadDTO = (DimLightPayloadDTO) o;
    return Objects.equals(this.sentAt, dimLightPayloadDTO.sentAt) && Objects.equals(this.percentage, dimLightPayloadDTO.percentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sentAt, percentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("DimLightPayloadDTO{");
    sb.append(" sentAt:").append(sentAt).append(",");
    sb.append(" percentage:").append(percentage);
    sb.append("}");
    return sb.toString();
  }


}
