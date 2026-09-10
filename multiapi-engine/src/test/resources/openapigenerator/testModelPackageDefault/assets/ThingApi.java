package com.sngular.multifileplugin.testmodelpackagedefault;

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

import com.sngular.multifileplugin.testmodelpackagedefault.model.Thing;

public interface ThingApi {

  /**
   * GET /thing
   * @return  OK; (status code 200)
   */

  @Operation(
    operationId = "getThing",
    tags = {"test"},
    responses = {
      @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Thing.class)))
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/thing",
    produces = {"application/json"}
  )

  default ResponseEntity<Thing> getThing() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
