package EF_contrerasmurojaime.EFFABRIC.service;

import EF_contrerasmurojaime.EFFABRIC.dto.CarDetailDto;
import EF_contrerasmurojaime.EFFABRIC.dto.CarDto;
import EF_contrerasmurojaime.EFFABRIC.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageCarService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;

}
