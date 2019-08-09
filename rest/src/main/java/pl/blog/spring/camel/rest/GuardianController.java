package pl.blog.spring.camel.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.blog.spring.camel.camel.CamelFacade;
import pl.blog.spring.camel.camel.model.Guardian;

import java.util.List;

@RestController
@RequestMapping("/guardian")
public class GuardianController {
    private final CamelFacade camelFacade;

    public GuardianController(CamelFacade camelFacade) {
        this.camelFacade = camelFacade;
    }

    @GetMapping
    public List<Guardian> getGuardians() {
        return camelFacade.getGuardians();
    }

    @GetMapping(value = "/{id}")
    public Guardian getGuardian(@PathVariable Long id) {
        return camelFacade.getGuardian(id);
    }

    @PostMapping
    public Guardian createGuardian(@RequestBody Guardian guardian) {
        return camelFacade.createGuardian(guardian);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity removeGuardian(@PathVariable Long id) {
        camelFacade.removeGuardian(id);
        return ResponseEntity.ok().build();
    }
}
