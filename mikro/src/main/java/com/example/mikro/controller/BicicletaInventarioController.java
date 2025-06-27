package com.example.mikro.controller;

import com.example.mikro.dto.BicicletaInventarioDTO;
import com.example.mikro.model.postgres.BicicletaInventarioPostgre;
import com.example.mikro.service.BicicletaInventarioService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRoutes.BICICLETA_INVENTARIO)
public class BicicletaInventarioController {

    private final BicicletaInventarioService service;

    public BicicletaInventarioController(BicicletaInventarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<BicicletaInventarioPostgre> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BicicletaInventarioPostgre getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("Bicicleta no encontrada con id " + id));
    }

    @PostMapping
    public BicicletaInventarioPostgre create(@RequestBody BicicletaInventarioDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public BicicletaInventarioPostgre update(@PathVariable Long id, @RequestBody BicicletaInventarioDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
