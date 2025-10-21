package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAddressDTO {
    private String provinceName;
    private String districtName;
}
