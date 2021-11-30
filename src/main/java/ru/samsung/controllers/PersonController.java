package ru.samsung.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.samsung.Entity.Person;
import ru.samsung.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRepository person;

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public int createPerson(@RequestBody String param){
        if (!param.contains("ip=") || !param.contains("name=")){
            return -1;
        }
        String name = param.substring(param.indexOf("name=")+5, param.indexOf("&"));
        param = param.substring(param.indexOf("&"));
        String ip = param.substring(param.indexOf("ip=")+3);
        return person.createPerson(name, ip);
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public int deletePerson(@RequestBody String param){
        if (!param.contains("id=")){
            return -1;
        }
        int id = Integer.parseInt(param.substring(param.indexOf("id=")+3));
        return person.deletePerson(id);
    }

    @RequestMapping(value = "/getperson", method=RequestMethod.POST)
    public Person getPerson(@RequestParam("id") Integer id){
        return person.getPerson(id);
    }

    @RequestMapping(value = "/getpersons", method=RequestMethod.POST)
    public List<Person> getPersons(){
        return person.getPersons();
    }
}
