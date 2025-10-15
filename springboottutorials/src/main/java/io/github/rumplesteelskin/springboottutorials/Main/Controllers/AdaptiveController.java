package io.github.rumplesteelskin.springboottutorials.Main.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adaptive")
public class AdaptiveController {
    @GetMapping("/square/{number}")
    public double GetSquare(@PathVariable(name = "number") double quantity) {
        return quantity * quantity;
    }

    @GetMapping({"/cube/{number}", "/cube"})
    public Double GetCube(@PathVariable(name = "number", required = false) Double quantity) {
        if (quantity == null)
            return 0.0;
        return quantity * quantity * quantity;
    }

    //http://localhost:8080/adaptive/tesseract?number=4
    @GetMapping("/tesseract")
    public Double GetTesseract(@RequestParam(name = "number", required = false) Double quantity) {
        if (quantity == null) {
            return 0.0;
        }
        return quantity * quantity * quantity * quantity;
    }
}
