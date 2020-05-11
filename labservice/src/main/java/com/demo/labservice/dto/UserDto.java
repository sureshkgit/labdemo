package com.demo.labservice.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class UserDto  implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Long countryId;
    private Long stateId;

}
