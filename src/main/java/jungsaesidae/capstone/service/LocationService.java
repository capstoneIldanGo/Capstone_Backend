package jungsaesidae.capstone.service;

import jungsaesidae.capstone.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<String> findAllCity() {
        List<String> result = locationRepository.findAllCity();
        List<String> city = result.stream()
                .filter(t -> t != null).collect(Collectors.toList());
//        List<String> city = result.stream().filter(t -> Objects.nonNull(t)).collect(Collectors.toList());

        return city;
    }

    public List<String> findAllStateByCity(String city) {
        return locationRepository.findAllStateByCity(city);
    }

}
