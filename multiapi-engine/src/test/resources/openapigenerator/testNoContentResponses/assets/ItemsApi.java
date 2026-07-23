package com.sngular.multifileplugin.testnocontentresponses;

import java.util.Optional;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import com.sngular.multifileplugin.testnocontentresponses.model.ItemDTO;

public interface ItemsApi {

  /**
   * GET /items: List items
   * @return  Successful response; (status code 200)  No content; (status code 204)  Unauthorized access; (status code 401)
   */

  @Operation(
    operationId = "listItems",
    summary = "List items",
    tags = {"items"},
    responses = {
      @ApiResponse(responseCode = "200", description = "Successful response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class))),
      @ApiResponse(responseCode = "204", description = "No content"),
      @ApiResponse(responseCode = "401", description = "Unauthorized access")
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/items",
    produces = {"application/json"}
  )

  default ResponseEntity<List<ItemDTO>> listItems() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
  /**
   * DELETE /items/{itemId}: Delete item
   * @return  No content; (status code 204)  Resource not found; (status code 404)
   */

  @Operation(
    operationId = "deleteItem",
    summary = "Delete item",
    tags = {"items"},
    responses = {
      @ApiResponse(responseCode = "204", description = "No content"),
      @ApiResponse(responseCode = "404", description = "Resource not found")
    }
  )
  @RequestMapping(
    method = RequestMethod.DELETE,
    value = "/items/{itemId}",
    produces = {"application/json"}
  )

  default ResponseEntity<Void> deleteItem() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
