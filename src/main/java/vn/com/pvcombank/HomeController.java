package vn.com.pvcombank;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.pvcombank.config.PVcomBankProperties;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final PVcomBankProperties pvcomBankProperties;

    @GetMapping("/")
    public String getGreeting() {
        return pvcomBankProperties.getGreeting();
    }
}
