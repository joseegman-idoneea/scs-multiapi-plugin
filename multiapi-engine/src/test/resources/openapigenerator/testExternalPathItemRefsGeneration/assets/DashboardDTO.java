package com.sngular.multifileplugin.externalpathitemref.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonDeserialize(builder = DashboardDTO.DashboardDTOBuilder.class)
public class DashboardDTO {

  @JsonProperty(value ="id")
  private String id;
  @JsonProperty(value ="title")
  private String title;
  @JsonProperty(value ="widgetCount")
  private Integer widgetCount;

  private DashboardDTO(DashboardDTOBuilder builder) {
    this.id = builder.id;
    this.title = builder.title;
    this.widgetCount = builder.widgetCount;

  }

  public static DashboardDTO.DashboardDTOBuilder builder() {
    return new DashboardDTO.DashboardDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class DashboardDTOBuilder {

    private String id;
    private String title;
    private Integer widgetCount;

    public DashboardDTO.DashboardDTOBuilder id(String id) {
      this.id = id;
      return this;
    }

    public DashboardDTO.DashboardDTOBuilder title(String title) {
      this.title = title;
      return this;
    }

    public DashboardDTO.DashboardDTOBuilder widgetCount(Integer widgetCount) {
      this.widgetCount = widgetCount;
      return this;
    }

    public DashboardDTO build() {
      DashboardDTO dashboardDTO = new DashboardDTO(this);
      return dashboardDTO;
    }
  }

  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  @Schema(name = "title", required = false)
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  @Schema(name = "widgetCount", required = false)
  public Integer getWidgetCount() {
    return widgetCount;
  }
  public void setWidgetCount(Integer widgetCount) {
    this.widgetCount = widgetCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardDTO dashboardDTO = (DashboardDTO) o;
    return Objects.equals(this.id, dashboardDTO.id) && Objects.equals(this.title, dashboardDTO.title) && Objects.equals(this.widgetCount, dashboardDTO.widgetCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, widgetCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("DashboardDTO{");
    sb.append(" id:").append(id).append(",");
    sb.append(" title:").append(title).append(",");
    sb.append(" widgetCount:").append(widgetCount);
    sb.append("}");
    return sb.toString();
  }


}
