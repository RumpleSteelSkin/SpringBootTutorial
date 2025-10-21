package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.client;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.address.ResponseAddressDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AddressClient {
    private final ModelMapper modelMapper;

    public ResponseAddressDTO getAddress(String personId) {
        RestTemplate restTemplate = new RestTemplate();
        return modelMapper.map(restTemplate.getForObject(Urls.Address.GET + personId, ResponseAddressDTO.class), ResponseAddressDTO.class);
    }
}
