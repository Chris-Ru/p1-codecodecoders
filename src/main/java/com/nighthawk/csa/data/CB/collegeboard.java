package com.nighthawk.csa.data.CB;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;



@Controller
public class collegeboard {

    @GetMapping("/frq")
    public String cb(Model model) {
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser
                    .parse(new FileReader("src/main/java/com/nighthawk/csa/data/CB/FRQ.json"));

            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;

            //Reading the array
            JSONArray week2 = (JSONArray)jsonObject.get("Week 2");

            //Printing all the values
            for(Object frq2 : week2)
            {
                System.out.println("\t"+frq2.toString());
            }

            model.addAttribute("week2", week2);

        } catch(Exception fe)
        {
            fe.printStackTrace();
        }
        return "data/collegeboard";

    }
}

//        ArrayList<FRQ> frqs = new ArrayList<>();
//
//        JSONParser parser = new JSONParser();
//        Object obj = parser.parse(new FileReader("src/main/java/com/nighthawk/csa/data/CB/FRQ.json"));
//        JSONObject jsonObject = (JSONObject) obj;
//
//        for (Object o : jsonObject.keySet()) {
//            String key = (String) o;
//
//            // Song song = new Song();
//            JSONObject FRQobj = (JSONObject) jsonObject.get(key);
//            frqs.add(new FRQ((String) FRQobj.get("name"), (String) FRQobj.get("gist"), (String) FRQobj.get("output")));
//        }
//
//        System.out.println(frqs.get(0));
//        model.addAttribute("FRQlist", frqs);
//        model.addAttribute("frq",frq);