package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianos.concesionario.repository.VendedoresRepository;
import com.salesianos.concesionario.model.Vendedor;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private VendedoresRepository vr;

    @PostConstruct
    public void init() {
        if (vr.count() == 0) {
            Vendedor v = new Vendedor(0, "Sin vendedor", "", null, "", "");
            vr.save(v);
        }
    }
}