package com.StevanPrograming.tutorial;

import com.StevanPrograming.tutorial.models.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Rutas {
    private final Logger logger= LoggerFactory.getLogger(Rutas.class);

    @GetMapping("/hola")
    String miPrimeraRuta(){
        return "hola mundo";

    }
    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial){
        return "leyendo el libro con id: " +id+", editorial: "+editorial;
    }
    @GetMapping("/libro2/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String gato, @RequestParam String editorial){
        return  "leyendo el libro con id: " +id+", params:" +gato+", editorial: "+editorial;
    }
    @PostMapping("/libro")
    String guardarLibro(@RequestBody Map<String, Object> libro){
        libro.keySet().forEach(llave->{
            logger.debug("llave {} valor {} ", llave, libro.get(llave));
        });
        return "libro guardado";
    }
    @PostMapping("/crear_libro")
    String guardarLibro(@RequestBody Libro libro){
        logger.debug("nombre {} editorial {}", libro.nombre, libro.editorial);
        return "libro guardado con exito";
    }
    @GetMapping("/saludar")
    //@ResponseStatus(value = HttpStatus.OK)
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "la ruta fue movida")
    String miSegundaRutaConStatus(){
        return "aprendiendo spring boot con status";
    }
    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar){
        if(lugar.equals("granja")){
            return ResponseEntity.status(HttpStatus.OK).body("caballo, vaca, oveja, gallina");
        } else if (lugar.equals("selva")) {
            return ResponseEntity.status(HttpStatus.OK).body("mono, gorila, puma");

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("lugar no valido");
        }
    }
    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero){
        throw new NullPointerException("esta excepcion ocurrio porque habla de informacion no relevante para el cliente");
    }
}
