package cz._pf.vopalensky.assignment.backend.controller;

import cz._pf.vopalensky.assignment.backend.exception.RateNotFoundException;
import cz._pf.vopalensky.assignment.backend.model.Rate;
import cz._pf.vopalensky.assignment.backend.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RateController {

    @Autowired
    private RateService service;

    private void resolveRefreshRequest(Boolean usedb) {
        if (!usedb) {
            service.clear();
            service.updateDB();
        }
    }

    @GetMapping({ "/", "/api/rates", "/api/rates/" })
    @ResponseBody
    public Iterable<Rate> list(@RequestParam(defaultValue = "true") Boolean usedb) {
        resolveRefreshRequest(usedb);
        return service.list();
    }

    @GetMapping("/api/rates/{shortName}")
    @ResponseBody
    public Rate getRateByShortName(@PathVariable String shortName) {
        return service.getByShortName(shortName).orElseThrow(() -> new RateNotFoundException(shortName));
    }
}
