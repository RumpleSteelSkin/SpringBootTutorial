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
    RestTemplate restTemplate = new RestTemplate();

    public ResponseAddressDTO getAddress(String personId) {
        return modelMapper.map(restTemplate.getForObject(Urls.Address.GET + personId, ResponseAddressDTO.class), ResponseAddressDTO.class);
    }
}
