package pl.blog.spring.camel.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.blog.spring.camel.camel.CamelFacade;
import pl.blog.spring.camel.camel.model.Camel;

import java.util.List;

@RestController
public class CamelController {
    private final CamelFacade camelFacade;

    public CamelController(CamelFacade camelFacade) {
        this.camelFacade = camelFacade;
    }

    @GetMapping
    public String getControllerInfo() {
        return "cagmel-controller";
    }

    @GetMapping(value = "/camel")
    public List<Camel> getCamels() {
        return camelFacade.getCamels();
    }

    @PostMapping(value = "/camel")
    public Camel createCamel(@RequestBody Camel camel) {
        return camelFacade.createCamel(camel);
    }

    @GetMapping(value = "/camel/{id}")
    public Camel getCamelById(@PathVariable Long id) {
        return camelFacade.getCamel(id);
    }
}
