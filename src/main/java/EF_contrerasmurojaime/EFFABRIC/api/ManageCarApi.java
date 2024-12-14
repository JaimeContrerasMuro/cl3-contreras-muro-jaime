package EF_contrerasmurojaime.EFFABRIC.api;

import EF_contrerasmurojaime.EFFABRIC.dto.CarDetailDto;
import EF_contrerasmurojaime.EFFABRIC.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import EF_contrerasmurojaime.EFFABRIC.response.*;
import EF_contrerasmurojaime.EFFABRIC.service.ManageCarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageCarApi {

    @Autowired
    ManageCarService manageCarService;

    @GetMapping("/all")
    public FindCarsResponse findUsers() {

        try {
            List<CarDto> cars = manageCarService.getAllCars();
            if (!cars.isEmpty())
                return new FindCarsResponse("01", null, cars);
            else
                return new FindCarsResponse("02", "Users not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "An error ocurred, please try again", null);

        }

    }

    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "id", defaultValue = "0") String carId) {

        try {
            Optional<CarDetailDto> optional = manageCarService.getCarById(Integer.parseInt(carId));
            return optional.map(car ->
                    new FindCarResponse("01", null, car)
            ).orElse(
                    new FindCarResponse("02", "Car not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99", "An error ocurred, please try again", null);

        }

    }

    @PutMapping("/update")
    public UpdateCarResponse updateUser(@RequestBody CarDto carDto) {

        try {
            if (manageCarService.updateCar(carDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "Car not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "An error ocurred, please try again");

        }

    }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id) {

        try {
            if (manageCarService.deleteCarById(Integer.parseInt(id)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "Car not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error ocurred, please try again");

        }

    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarDetailDto carDetailDto) {

        try {
            if (manageCarService.addCar(carDetailDto))
                return new CreateCarResponse("01", null);
            else
                return new CreateCarResponse("02", "Car already exists");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error ocurred, please try again");

        }

    }

}
