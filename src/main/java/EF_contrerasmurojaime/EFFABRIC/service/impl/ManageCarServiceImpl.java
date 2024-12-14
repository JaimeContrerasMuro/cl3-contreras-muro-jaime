package EF_contrerasmurojaime.EFFABRIC.service.impl;

import EF_contrerasmurojaime.EFFABRIC.entity.Car;
import EF_contrerasmurojaime.EFFABRIC.service.ManageCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import EF_contrerasmurojaime.EFFABRIC.dto.CarDetailDto;
import EF_contrerasmurojaime.EFFABRIC.dto.CarDto;
import EF_contrerasmurojaime.EFFABRIC.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageCarServiceImpl implements ManageCarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear()));
        });
        return cars;

    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));

    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.cardId());
        return optional.map(car -> {
            car.setCarId(carDto.cardId());
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDetailDto.carId());
        if (optional.isEmpty()) {
            Car car = new Car();
            car.setCarId(carDetailDto.carId());
            car.setMake(carDetailDto.make());
            car.setModel(carDetailDto.model());
            car.setYear(carDetailDto.year());
            car.setVin(carDetailDto.vin());
            car.setLicensePlate(carDetailDto.licensePlate());
            car.setOwnerName(carDetailDto.ownerName());
            car.setOwnerContact(carDetailDto.ownerContact());
            car.setPurchaseDate(carDetailDto.purchaseDate());
            car.setMileage(carDetailDto.mileage());
            car.setEngineType(carDetailDto.engineType());
            car.setColor(carDetailDto.color());
            car.setInsuranceCompany(carDetailDto.insuranceCompany());
            car.setInsurancePolicyNumber(carDetailDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carDetailDto.registrationExpirationDate());
            car.setServiceDueDate(carDetailDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }
        return false;

    }

}