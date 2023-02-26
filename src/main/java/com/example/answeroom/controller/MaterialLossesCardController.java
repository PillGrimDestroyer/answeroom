package com.example.answeroom.controller;

import com.example.answeroom.model.Page;
import com.example.answeroom.model.response.MaterialLossesCardResponse;
import com.example.answeroom.register.MaterialLossesCardRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/material-losses")
@RequiredArgsConstructor
public class MaterialLossesCardController {

    // region Autowired

    private final MaterialLossesCardRegister materialLossesCardRegister;

    // endregion

    @GetMapping("/list")
    public MaterialLossesCardResponse list(@RequestParam Page page) {
        return materialLossesCardRegister.loadPage(page);
    }

    @GetMapping("/detail")
    public void detail(@RequestParam String materialLossesCarId, @RequestParam String userId) {
        materialLossesCardRegister.loadDetail(materialLossesCarId, userId);
    }

}
