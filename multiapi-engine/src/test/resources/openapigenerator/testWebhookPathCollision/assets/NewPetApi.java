package com.sngular.multifileplugin.webhookpathcollision;

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

import com.sngular.multifileplugin.webhookpathcollision.model.PetDTO;

public interface NewPetApi {

  /**
   * GET /newPet: Get the latest new pet
   * @return  The latest new pet; (status code 200)
   */

  @Operation(
    operationId = "getNewPet",
    summary = "Get the latest new pet",
    tags = {"pet"},
    responses = {
      @ApiResponse(responseCode = "200", description = "The latest new pet", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PetDTO.class)))
    }
  )
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/newPet",
    produces = {"application/json"}
  )

  default ResponseEntity<PetDTO> getNewPet() {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
