package se.disabledsecurity.policealert.rest.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.disabledsecurity.policealert.rest.domain.Alert;
import se.disabledsecurity.policealert.rest.service.AlertService;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1")
@Tag(name = "alert", description = "Get information about current police events")
public class AlertController {

    private AlertService service;


    @Operation(summary = "Get all available alerts",  tags = { "alert" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Alert.class)))) })
    @GetMapping("alerts")
    ResponseEntity<List<Alert>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/alerts/{alertId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Alert> single(@PathVariable Long alertId) {
        return ResponseEntity.ok(service.findById(alertId));
    }

}
