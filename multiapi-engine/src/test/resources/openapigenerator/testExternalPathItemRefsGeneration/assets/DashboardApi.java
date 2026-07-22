package com.sngular.multifileplugin.externalpathitemref;

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

import com.sngular.multifileplugin.externalpathitemref.model.DashboardDTO;

public interface DashboardApi {

  /**
   * GET /dashboard: Get the dashboard
   * @return  The requested dashboard; (status code 200)
   */

  @Operation(
    operationId = "getDashboard",
    summary = "Get the dashboard",
    tags = {"dashboard"},
    responses = {
      @ApiResponse(responseCode = "200", description = "The requested dashboard", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DashboardDTO.class)))
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/dashboard",
    produces = {"application/json"}
  )

  default ResponseEntity<DashboardDTO> getDashboard() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
