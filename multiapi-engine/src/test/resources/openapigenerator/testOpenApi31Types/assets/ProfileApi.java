package com.sngular.multifileplugin.openapi31types;

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

import com.sngular.multifileplugin.openapi31types.model.ProfileDTO;

public interface ProfileApi {

  /**
   * GET /profile: Get the profile
   * @return  The requested profile; (status code 200)
   */

  @Operation(
    operationId = "getProfile",
    summary = "Get the profile",
    tags = {"profile"},
    responses = {
      @ApiResponse(responseCode = "200", description = "The requested profile", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileDTO.class)))
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/profile",
    produces = {"application/json"}
  )

  default ResponseEntity<ProfileDTO> getProfile() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
