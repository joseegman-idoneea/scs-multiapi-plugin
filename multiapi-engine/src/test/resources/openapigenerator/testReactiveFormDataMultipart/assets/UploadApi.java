package com.sngular.multifileplugin.testreactiveformdatamultipart;

import java.util.List;
import java.util.Map;
import java.nio.charset.StandardCharsets;
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
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import springfox.documentation.annotations.ApiIgnore;
import org.springframework.http.codec.multipart.FilePart;


public interface UploadApi {

  /**
   * POST /upload
   * @param someFile, someFiles, someString (required)
   * @return  OK; (status code 200)
   * @throws WebClientResponseException if an error occurs while attempting to invoke the API
   */
  @Operation(
     operationId = "uploadMultipart",
     tags = {"test"},
     responses = {
       @ApiResponse(responseCode = "200", description = "OK")
     }
  )
  @RequestMapping(
    method = RequestMethod.POST,
    value = "/upload",
    produces = {"application/json"},
    consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
  )
  default ResponseEntity<Void> uploadMultipart(@Parameter(name = "someFile", required = false, schema = @Schema(description = "")) @RequestPart(value = "someFile", required = false) FilePart someFile, @Parameter(name = "someFiles", required = false, schema = @Schema(description = "")) @RequestPart(value = "someFiles", required = false) Flux<FilePart> someFiles, @Parameter(name = "someString", required = false, schema = @Schema(description = "")) @RequestPart(value = "someString", required = false) String someString, @ApiIgnore final ServerWebExchange exchange) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}