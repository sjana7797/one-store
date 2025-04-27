package dev.sanjayjana.one_store.controller;


import dev.sanjayjana.one_store.enums.route.OrganizationRoute;
import dev.sanjayjana.one_store.exceptions.BadRequestException;
import dev.sanjayjana.one_store.model.Organization;
import dev.sanjayjana.one_store.response.ApiResponse;
import dev.sanjayjana.one_store.response.ErrorApiResponse;
import dev.sanjayjana.one_store.response.SuccessApiResponse;
import dev.sanjayjana.one_store.services.organization.IOrganizationService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Organization", description = "Organization level APIs")
@RestController
@RequestMapping(OrganizationRoute.BASE_URL)
@Validated
public class OrganizationController {

    private final IOrganizationService organizationService;

    @Autowired
    public OrganizationController(IOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Organization found",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SuccessApiResponse.class)),
                    }

            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",
                    description = "Organization not found",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorApiResponse.class)),
                    }

            )
    })
    @GetMapping
    ResponseEntity<ApiResponse<Organization>> getOrganization(@RequestParam(name = "id") @NotBlank String id) {

        if (id.isEmpty()) {
            throw new BadRequestException("Id is required");
        }
        Organization organization = organizationService.getOrganization(id);

        ApiResponse<Organization> apiResponse = new SuccessApiResponse<Organization>(organization, "Organization retrieved successfully");

        return ResponseEntity.ok(apiResponse);


    }
}
