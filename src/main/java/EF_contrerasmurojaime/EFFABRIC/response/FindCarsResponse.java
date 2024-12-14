package EF_contrerasmurojaime.EFFABRIC.response;

import EF_contrerasmurojaime.EFFABRIC.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {

}
