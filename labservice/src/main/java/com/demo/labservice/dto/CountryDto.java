package com.demo.labservice.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class CountryDto  implements Serializable {

    private Long id;
    private String countryName;
    private String iso;

}
