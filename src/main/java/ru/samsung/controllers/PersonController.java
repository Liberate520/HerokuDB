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
    @RequestMapping(value = "/create", method= RequestMethod.PUT, consumes="text/plain")
    public int createPerson(@RequestBody String param){
        String name = null;
        String ip = null;
        try{
            JSONObject json = new JSONObject(param);
            name = json.getString("name");
            ip = json.getString("ip");
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return person.createPerson(name, ip);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST,consumes="text/plain")
    public int updatePerson(@RequestBody String param){
        Person p = new Person();
        try{
            JSONObject json = new JSONObject(param);
            p.setId(json.getInt("id"));
            p.setName(json.getString("name"));
            p.setIp(json.getString("ip"));
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return person.updatePerson(p);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public int deletePerson(@PathVariable Integer id){
        return person.deletePerson(id);
    }

    @RequestMapping(value = "/getperson", method=RequestMethod.GET)
    public Person getPerson(@RequestParam("id") Integer id){
        return person.getPerson(id);
    }

    @RequestMapping(value = "/getpersons", method=RequestMethod.GET)
    public List<Person> getPersons(){
        return person.getPersons();
    }
}
