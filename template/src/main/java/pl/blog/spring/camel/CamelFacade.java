package pl.blog.spring.camel.camel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import pl.blog.spring.camel.camel.model.Camel;
import pl.blog.spring.camel.camel.model.Gender;
import pl.blog.spring.camel.camel.model.Guardian;
import pl.blog.spring.camel.camel.service.CamelService;
import pl.blog.spring.camel.camel.service.GuardianService;

import java.util.List;

@Component
public class CamelFacade {
    private final CamelService camelService;
    private final GuardianService guardianService;

    @Autowired
    public CamelFacade(CamelService camelService, GuardianService guardianService) {
        this.camelService = camelService;
        this.guardianService = guardianService;
    }

    public Camel createCamel(Guardian guardian, String camelName, int age, Gender gender) {
        Guardian camelGuardian = guardianService.addGuardian(guardian);

        Camel camel = new Camel(camelName, age, gender, camelGuardian);

        return camelService.addCamel(camel);
    }

    public List<Camel> getCamels() {
        return camelService.getCamels();
    }

    public Camel createCamel(Camel camel) {
        return camelService.addCamel(camel);
    }

    public Camel getCamel(Long id) {
        return getCamels().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void removeGuardian(Long id) {
        guardianService.removeGuardian(id);
    }

    public Guardian createGuardian(Guardian guardian) {
        return guardianService.addGuardian(guardian);
    }

    public Guardian getGuardian(Long id) {
        return getGuardians().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Guardian> getGuardians() {
        return guardianService.getGuardians();
    }
}
