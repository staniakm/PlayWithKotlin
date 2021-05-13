package org.mariusz;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {

    private String city;
    private String street;

}
