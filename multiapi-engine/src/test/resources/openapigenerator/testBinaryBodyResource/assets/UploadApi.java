package com.sngular.multifileplugin.testbinarybodyresource;

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
import org.springframework.core.io.Resource;


public interface UploadApi {

  /**
   * POST /upload
   * @param resource (required)
   * @return  OK; (status code 200)
   */

  @Operation(
    operationId = "uploadBinary",
    tags = {"test"},
    responses = {
      @ApiResponse(responseCode = "200", description = "OK")
    }
  )
  @RequestMapping(
    method = RequestMethod.POST,
    value = "/upload",
    produces = {"application/json"}
  )

  default ResponseEntity<Void> uploadBinary(@Parameter(name = "resource", description = "", required = true, schema = @Schema(description = "")) @Valid @RequestBody Resource resource) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
