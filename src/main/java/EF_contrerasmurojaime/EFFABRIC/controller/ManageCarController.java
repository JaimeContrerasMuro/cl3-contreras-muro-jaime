package EF_contrerasmurojaime.EFFABRIC.controller;

import EF_contrerasmurojaime.EFFABRIC.dto.CarDto;
import EF_contrerasmurojaime.EFFABRIC.service.ManageCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import EF_contrerasmurojaime.EFFABRIC.dto.CarDto;
import EF_contrerasmurojaime.EFFABRIC.service.ManageCarService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageCarController {

    @Autowired
    ManageCarService manageService;

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<CarDto> cars = manageService.getAllCars();
            model.addAttribute("cars", cars);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los datos");

        }
        return "manage";

    }

}
