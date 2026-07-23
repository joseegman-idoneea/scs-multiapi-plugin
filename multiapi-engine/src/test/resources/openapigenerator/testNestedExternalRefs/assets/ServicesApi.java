package com.sngular.multifileplugin.testnestedexternalref;

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

import com.sngular.multifileplugin.testnestedexternalref.model.InlineResponse200ListServicesDTO;

public interface ServicesApi {

  /**
   * GET /services: List all services
   * @return  A list of services; (status code 200)
   */

  @Operation(
    operationId = "listServices",
    summary = "List all services",
    tags = {"services"},
    responses = {
      @ApiResponse(responseCode = "200", description = "A list of services", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200ListServicesDTO.class)))
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/services",
    produces = {"application/json"}
  )

  default ResponseEntity<InlineResponse200ListServicesDTO> listServices() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
