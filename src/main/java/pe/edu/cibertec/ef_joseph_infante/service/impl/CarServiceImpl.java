package pe.edu.cibertec.ef_joseph_infante.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ef_joseph_infante.dto.CarAllDto;
import pe.edu.cibertec.ef_joseph_infante.dto.CarDetailDto;
import pe.edu.cibertec.ef_joseph_infante.dto.CarDto;
import pe.edu.cibertec.ef_joseph_infante.entity.Car;
import pe.edu.cibertec.ef_joseph_infante.repository.CarRepository;
import pe.edu.cibertec.ef_joseph_infante.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Override
    public boolean addCar(CarDto carDto) throws Exception {
        Car car = new Car();

        car.setMake(carDto.make());
        car.setModel(carDto.model());
        car.setYear(carDto.year());
        car.setVin(carDto.vin());
        car.setLicensePlate(carDto.licensePlate());
        car.setOwnerName(carDto.ownerName());
        car.setOwnerContact(carDto.ownerContact());
        car.setPurchaseDate(carDto.purchaseDate());
        car.setMileage(carDto.mileage());
        car.setEngineType(carDto.engineType());
        car.setColor(carDto.color());
        car.setInsuranceCompany(carDto.insuranceCompany());
        car.setInsurancePolicyNumber(carDto.insurancePolicyNumber());
        car.setRegistrationExpirationDate(carDto.registrationExpirationDate());
        car.setServiceDueDate(carDto.serviceDueDate());

        carRepository.save(car);
        return true;
    }

    @Override
    public boolean updateCar(int id, CarDto carDto) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setVin(carDto.vin());
            car.setLicensePlate(carDto.licensePlate());
            car.setOwnerName(carDto.ownerName());
            car.setOwnerContact(carDto.ownerContact());
            car.setPurchaseDate(carDto.purchaseDate());
            car.setMileage(carDto.mileage());
            car.setEngineType(carDto.engineType());
            car.setColor(carDto.color());
            car.setInsuranceCompany(carDto.insuranceCompany());
            car.setInsurancePolicyNumber(carDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carDto.registrationExpirationDate());
            car.setServiceDueDate(carDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
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
    public List<CarAllDto> getAllCars() throws Exception {
        List<CarAllDto> cars = new ArrayList<CarAllDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarAllDto(car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getVin()));
        });
        return cars;
    }
}
