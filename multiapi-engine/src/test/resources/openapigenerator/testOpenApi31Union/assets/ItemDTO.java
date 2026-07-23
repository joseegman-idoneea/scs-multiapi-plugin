package com.sngular.multifileplugin.openapi31union.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonDeserialize(builder = ItemDTO.ItemDTOBuilder.class)
public class ItemDTO {

  @JsonProperty(value ="id")
  private String id;
  @JsonProperty(value ="code")
  private String code;
  @JsonProperty(value ="note")
  private Object note;

  private ItemDTO(ItemDTOBuilder builder) {
    this.id = builder.id;
    this.code = builder.code;
    this.note = builder.note;

  }

  public static ItemDTO.ItemDTOBuilder builder() {
    return new ItemDTO.ItemDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class ItemDTOBuilder {

    private String id;
    private String code;
    private Object note;

    public ItemDTO.ItemDTOBuilder id(String id) {
      this.id = id;
      return this;
    }

    public ItemDTO.ItemDTOBuilder code(String code) {
      this.code = code;
      return this;
    }

    public ItemDTO.ItemDTOBuilder note(Object note) {
      this.note = note;
      return this;
    }

    public ItemDTO build() {
      ItemDTO itemDTO = new ItemDTO(this);
      return itemDTO;
    }
  }

  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  @Schema(name = "code", required = false)
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  @Schema(name = "note", required = false)
  public Object getNote() {
    return note;
  }
  public void setNote(Object note) {
    this.note = note;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemDTO itemDTO = (ItemDTO) o;
    return Objects.equals(this.id, itemDTO.id) && Objects.equals(this.code, itemDTO.code) && Objects.equals(this.note, itemDTO.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, note);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ItemDTO{");
    sb.append(" id:").append(id).append(",");
    sb.append(" code:").append(code).append(",");
    sb.append(" note:").append(note);
    sb.append("}");
    return sb.toString();
  }


}
