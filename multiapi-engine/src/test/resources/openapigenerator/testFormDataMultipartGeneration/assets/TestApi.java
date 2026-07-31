package com.sngular.multifileplugin.testformdatamultipartgeneration;

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
import org.springframework.web.multipart.MultipartFile;


public interface TestApi {

  /**
   * GET /test
   * @param someFile @param someFiles @param someString (required)
   * @return  OK; (status code 200)
   */

  @Operation(
    operationId = "testMultipart",
    tags = {"test"},
    responses = {
      @ApiResponse(responseCode = "200", description = "OK")
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/test",
    produces = {"application/json"},
    consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
  )

  default ResponseEntity<Void> testMultipart(@Parameter(name = "someFile", required = false, schema = @Schema(description = "")) @RequestPart(value = "someFile", required = false) MultipartFile someFile , @Parameter(name = "someFiles", required = false, schema = @Schema(description = "")) @RequestPart(value = "someFiles", required = false) List<MultipartFile> someFiles , @Parameter(name = "someString", required = false, schema = @Schema(description = "")) @RequestPart(value = "someString", required = false) String someString) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
