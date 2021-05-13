package org.mariusz;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@Getter
@Builder
public class Person extends Human {

    private final String name;
    private final String surname;
    private final int age;
    @Nullable
    private final Company company;

    public String getCity() {
        return Optional.ofNullable(company)
                .map(Company::getAddress)
                .map(Address::getCity)
                .orElse("");
    }
}

