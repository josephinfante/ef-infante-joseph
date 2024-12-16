package pe.edu.cibertec.ef_joseph_infante.response;

import pe.edu.cibertec.ef_joseph_infante.dto.CarAllDto;

import java.util.List;

public record ApiFindAllResponse(String code,
                                 String error,
                                 List<CarAllDto> cars) {
}
