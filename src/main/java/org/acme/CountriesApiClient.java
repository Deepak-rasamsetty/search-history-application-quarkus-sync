package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/")
@RegisterRestClient
public interface CountriesApiClient {

    @GET
    @Path("name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    BaseCountry fetchCountryDetails(@PathParam("name") String name,
                            @QueryParam("fullText") boolean fullText);


}
