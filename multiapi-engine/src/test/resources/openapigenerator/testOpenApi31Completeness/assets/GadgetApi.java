package com.sngular.multifileplugin.openapi31completeness;

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

import com.sngular.multifileplugin.openapi31completeness.model.GadgetDTO;

public interface GadgetApi {

  /**
   * GET /gadget: Get a gadget
   * @return  The requested gadget; (status code 200)
   */

  @Operation(
    operationId = "getGadget",
    summary = "Get a gadget",
    tags = {"gadget"},
    responses = {
      @ApiResponse(responseCode = "200", description = "The requested gadget", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GadgetDTO.class)))
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/gadget",
    produces = {"application/json"}
  )

  default ResponseEntity<GadgetDTO> getGadget() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
