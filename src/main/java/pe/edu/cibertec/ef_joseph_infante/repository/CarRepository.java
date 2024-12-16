package pe.edu.cibertec.ef_joseph_infante.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.ef_joseph_infante.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
