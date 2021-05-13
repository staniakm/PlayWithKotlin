package org.mariusz;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Builder
public class Company {
   private final String name;
   private final String longName;
   private final int numberOfCars;
   private Address address;
}
