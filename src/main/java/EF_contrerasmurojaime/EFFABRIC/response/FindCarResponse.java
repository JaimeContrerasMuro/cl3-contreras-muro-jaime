package EF_contrerasmurojaime.EFFABRIC.response;

import EF_contrerasmurojaime.EFFABRIC.dto.CarDetailDto;
import EF_contrerasmurojaime.EFFABRIC.entity.Car;


public record FindCarResponse(String code,
                              String error,
                              CarDetailDto car) {

}
