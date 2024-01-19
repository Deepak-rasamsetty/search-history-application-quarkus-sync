package org.acme;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BaseCountry {

    private  NameVO name;
    private List<String> capital;
    private String cca3;
    private String region;

    private String subregion;
    private List<String> timezones;
    private List<String> continents;
    private Map<String, String> languages;
    private Boolean unMember;

    private List<String> borders;

    private Map<String , CurrencyVO> currencies;
}