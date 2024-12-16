package pe.edu.cibertec.ef_joseph_infante.service;

import pe.edu.cibertec.ef_joseph_infante.dto.CarAllDto;
import pe.edu.cibertec.ef_joseph_infante.dto.CarDetailDto;
import pe.edu.cibertec.ef_joseph_infante.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {
    boolean addCar(CarDto carDto) throws Exception;
    boolean updateCar(int id, CarDto carDto) throws Exception;
    boolean deleteCarById(int id) throws Exception;
    Optional<CarDetailDto> getCarById(int id) throws  Exception;
    List<CarAllDto> getAllCars() throws Exception;
}
