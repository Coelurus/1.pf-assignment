package cz._pf.vopalensky.assignment.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz._pf.vopalensky.assignment.backend.model.Rate;
import cz._pf.vopalensky.assignment.backend.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RateService {

    private static final String SOURCE = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";

    @Autowired
    RateRepository repo;
    public Iterable<Rate> list() {
        return repo.findAll();
    }

    public Rate save(Rate rate){
        return repo.save(rate);
    }

    public Iterable<Rate> save(Iterable<Rate> rates) {
        return repo.saveAll(rates);
    }

    public void clear(){
        repo.deleteAll();
    }

    public void updateDB(){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Rate>> typeReference = new TypeReference<List<Rate>> (){ };
        try {
            List<Rate> rates = mapper.readValue(new URI(SOURCE).toURL(), typeReference);
            clear();
            save(rates);
        }catch (IOException | URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

    public Optional<Rate> getByShortName(String shortName) {
        return repo.findFirstByShort(shortName);
    }
}
