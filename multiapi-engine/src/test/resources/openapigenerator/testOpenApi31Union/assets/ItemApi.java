package com.sngular.multifileplugin.openapi31union;

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

import com.sngular.multifileplugin.openapi31union.model.ItemDTO;

public interface ItemApi {

  /**
   * GET /item: Get the item
   * @return  The requested item; (status code 200)
   */

  @Operation(
    operationId = "getItem",
    summary = "Get the item",
    tags = {"item"},
    responses = {
      @ApiResponse(responseCode = "200", description = "The requested item", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItemDTO.class)))
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/item",
    produces = {"application/json"}
  )

  default ResponseEntity<ItemDTO> getItem() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
