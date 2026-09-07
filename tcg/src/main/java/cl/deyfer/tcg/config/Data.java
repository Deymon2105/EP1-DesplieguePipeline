package cl.deyfer.tcg.config;

import cl.deyfer.tcg.model.ProductoTcg;
import cl.deyfer.tcg.repository.ProductoTcgRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Data implements CommandLineRunner {

    private final ProductoTcgRepository repository;

    public Data(ProductoTcgRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() > 0) {
            return; // Si ya hay datos (por ejemplo, en MySQL), no inserta nada
        }

        List<ProductoTcg> productos = List.of(
            ProductoTcg.builder()
                .sku("PKM-CRZ-ETB")
                .nombre("Elite Trainer Box Crown Zenith")
                .setColeccion("Crown Zenith")
                .categoria("SELLADO")
                .idioma("INGLES")
                .precio(64990.0)
                .stock(12)
                .disponible(true)
                .build(),

            ProductoTcg.builder()
                .sku("PKM-MEW-151-UPC")
                .nombre("Ultra Premium Collection Pokémon 151")
                .setColeccion("Scarlet & Violet 151")
                .categoria("SELLADO")
                .idioma("INGLES")
                .precio(149990.0)
                .stock(4)
                .disponible(true)
                .build()
        );

        repository.saveAll(productos);
    }
}