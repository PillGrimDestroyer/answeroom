package com.example.answeroom.controller;

import com.example.answeroom.model.Page;
import com.example.answeroom.model.response.MaterialLossesResponse;
import com.example.answeroom.register.MaterialLossesRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/material-losses")
@RequiredArgsConstructor
public class MaterialLossesController {

    // region Autowired

    private final MaterialLossesRegister materialLossesRegister;

    // endregion

    @GetMapping("/list")
    public MaterialLossesResponse list(@RequestParam Page page) {
        return materialLossesRegister.loadPage(page);
    }

}
