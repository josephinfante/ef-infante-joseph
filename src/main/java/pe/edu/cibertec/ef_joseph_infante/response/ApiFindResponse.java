package pe.edu.cibertec.ef_joseph_infante.response;

import pe.edu.cibertec.ef_joseph_infante.dto.CarDetailDto;

public record ApiFindResponse(String code,
                              String error,
                              CarDetailDto car) {
}
