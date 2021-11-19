package com.nighthawk.csa;

import com.nighthawk.csa.starters.ImageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class MainController {

    @GetMapping("/aboutus")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String abtus() {
        return "starters/aboutus";
    }

    @GetMapping("/greet")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        // @RequestParam handles required and default values, name and data are class variables, data looking like JSON
        model.addAttribute("name", name);   // MODEL is passed to html
        return "starters/greet";                     // returns HTML VIEW (greeting)
    }

    @GetMapping("/image")
    public String image(Model model)  {
        //String web_server = "http://localhost:8080/";
        String web_server = "https://csa.nighthawkcodingsociety.com";
        List<ImageInfo> lii = new ArrayList<>();

        String file0 = "/images/Mona_Lisa.png";
        lii.add(new ImageInfo(file0, web_server+file0, 12));
        lii.get(0).read_image();

        String file1 = "/images/bulb_on.gif";
        lii.add(new ImageInfo(file1, web_server+file1, 2));
        lii.get(1).read_image();

        String file2 = "/images/bulb_off.png";
        lii.add(new ImageInfo(file2, web_server+file2, 7));
        lii.get(2).read_image();

        model.addAttribute("lii", lii);
        return "starters/image";
    }

    @GetMapping("/image/grayscale")
    public String image_grayscale(Model model) {
        //String web_server = "http://localhost:8080/";
        String web_server = "https://csa.nighthawkcodingsociety.com";
        List<ImageInfo> lii = new ArrayList<>();

        String file0 = "/images/Mona_Lisa.png";
        lii.add(new ImageInfo(file0, web_server+file0, 12));
        String str = lii.get(0).grayscale();
        model.addAttribute("str", str);
        return "starters/image_grayscale";
    }

    @GetMapping("/binary")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String binary() {
        return "starters/binary";
    }


    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/deploy")
    public String deploy(){
        return "deploy";
    }
}