package org.acme;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Path("/countries")
public class CountriesController {

    @RestClient
    @Inject
    CountriesApiClient client;


    @GET
    @Path("/search/history")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountrySearchHistoryEntity> getSearchHistory(){
        return CountrySearchHistoryEntity.listAll();
    }


    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public BaseCountry findByName(@PathParam("name") String name){
        BaseCountry country =  client.fetchCountryDetails(name, true);
        CountrySearchHistoryEntity countrySearchHistoryEntity = new CountrySearchHistoryEntity();
        countrySearchHistoryEntity.setName(country.getName().getCommon());
        countrySearchHistoryEntity.setCreatedOn(new SimpleDateFormat("DD-MM-YYYY HH:MM:SS").format(new Date()));
        CountrySearchHistoryEntity.persist(countrySearchHistoryEntity);
        return country;
    }


}
