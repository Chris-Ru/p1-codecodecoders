package com.nighthawk.csa;

import org.springframework.web.bind.annotation.GetMapping;

public class NameCheapController {
    @GetMapping("/.well-known/pki-validation/12E800B1D5ECEBF85E19E331034DA94D.txt")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String namecheap() {
        return "namecheap";
    }
}
