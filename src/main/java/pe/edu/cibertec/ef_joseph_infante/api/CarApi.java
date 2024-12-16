package pe.edu.cibertec.ef_joseph_infante.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ef_joseph_infante.dto.CarAllDto;
import pe.edu.cibertec.ef_joseph_infante.dto.CarDetailDto;
import pe.edu.cibertec.ef_joseph_infante.dto.CarDto;
import pe.edu.cibertec.ef_joseph_infante.response.ApiFindAllResponse;
import pe.edu.cibertec.ef_joseph_infante.response.ApiFindResponse;
import pe.edu.cibertec.ef_joseph_infante.response.ApiResponse;
import pe.edu.cibertec.ef_joseph_infante.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
public class CarApi {
    @Autowired
    CarService carService;

    @PostMapping
    public ApiResponse addCar(@RequestBody CarDto carDto) {
        try {
            if (carService.addCar(carDto)) return new ApiResponse("201", null);
            else return new ApiResponse("400", "An error occurred while creating a new car");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("500", "An error occurred, please try again");
        }
    }

    @PutMapping("/{id}")
    public ApiResponse updateCar(@PathVariable String id, @RequestBody CarDto carDto) {
        try {
            if (carService.updateCar(Integer.parseInt(id), carDto)) return new ApiResponse("200", null);
            else return new ApiResponse("404", "Car not found");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("500", "An error occurred, please try again");
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteCar(@PathVariable String id) {
        try {
            if (carService.deleteCarById(Integer.parseInt(id))) return new ApiResponse("200", null);
            else return new ApiResponse("404", "Car not found");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse("500", "An error occurred, please try again");
        }
    }

    @GetMapping("/{id}")
    public ApiFindResponse findCar(@PathVariable String id) {
        try {
            Optional<CarDetailDto> optional = carService.getCarById(Integer.parseInt(id));
            return optional.map(car ->
                    new ApiFindResponse("200", null, car)
            ).orElse(
                    new ApiFindResponse("404", "Car not found", null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiFindResponse("500", "An error occurred, please try again", null);
        }
    }

    @GetMapping
    public ApiFindAllResponse findCars() {
        try {
            List<CarAllDto> cars = carService.getAllCars();
            if (!cars.isEmpty()) return new ApiFindAllResponse("200", null, cars);
            else return new ApiFindAllResponse("400", "An error occurred while getting the cars", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiFindAllResponse("500", "An error occurred, please try again", null);
        }
    }
}
