package com.sngular.multifileplugin.refwithdescription;

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

import com.sngular.multifileplugin.refwithdescription.model.OrderDTO;

public interface OrderApi {

  /**
   * GET /order: Get an order
   * @return  The requested order; (status code 200)
   */

  @Operation(
    operationId = "getOrder",
    summary = "Get an order",
    tags = {"order"},
    responses = {
      @ApiResponse(responseCode = "200", description = "The requested order", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderDTO.class)))
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/order",
    produces = {"application/json"}
  )

  default ResponseEntity<OrderDTO> getOrder() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
