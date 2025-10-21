package io.github.rumplesteelskin.springboottutorials.main.ntierresponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("location")
public class AddressController {
    @GetMapping("getAddress/{id}")
    public AddressDTO getAddress(@PathVariable("id") String personId) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setProvinceName("İstanbul");
        addressDTO.setDistrictName("Fatih");
        return addressDTO;
    }
}
