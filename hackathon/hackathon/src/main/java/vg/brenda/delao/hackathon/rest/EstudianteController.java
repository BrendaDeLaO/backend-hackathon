package vg.brenda.delao.hackathon.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vg.brenda.delao.hackathon.model.Estudiante;
import vg.brenda.delao.hackathon.service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8086")
@Slf4j
@Tag(name = "Estudiantes", description = "Operaciones relacionadas con estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Operation(summary = "Listar todos los estudiantes")
    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        log.info("Obteniendo todos los estudiantes...");
        return estudianteService.getAllEstudiantes();
    }

    @Operation(summary = "Listar estudiantes activos")
    @GetMapping("/activos")
    public List<Estudiante> getActiveEstudiantes() {
        log.info("Obteniendo estudiantes activos...");
        return estudianteService.getActiveEstudiantes();
    }

    @Operation(summary = "Listar estudiantes inactivos")
    @GetMapping("/inactivos")
    public List<Estudiante> getInactiveEstudiantes() {
        log.info("Obteniendo estudiantes inactivos...");
        return estudianteService.getInactiveEstudiantes();
    }

    @Operation(summary = "Obtener estudiante por ID")
    @GetMapping("/{id}")
    public Estudiante getEstudianteById(@PathVariable Integer id) {
        log.info("Buscando estudiante con ID: {}", id);
        return estudianteService.getEstudianteById(id).orElse(null);
    }

    @Operation(summary = "Registrar nuevo estudiante")
    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante newEstudiante) {
        log.info("Registrando nuevo estudiante: {}", newEstudiante);
        if (newEstudiante.getPrograma() == null || newEstudiante.getUbigeo() == null) {
            throw new IllegalArgumentException("Programa y Ubigeo son obligatorios.");
        }
        return estudianteService.saveEstudiante(newEstudiante);
    }

    @Operation(summary = "Actualizar estudiante")
    @PutMapping("/{id}")
    public Estudiante updateEstudiante(@PathVariable Integer id, @RequestBody Estudiante updatedEstudiante) {
        log.info("Actualizando estudiante con ID: {}", id);
        if (updatedEstudiante.getPrograma() == null || updatedEstudiante.getUbigeo() == null) {
            throw new IllegalArgumentException("Programa y Ubigeo son obligatorios.");
        }
        return estudianteService.updateEstudiante(id, updatedEstudiante);
    }

    @Operation(summary = "Eliminar lógicamente un estudiante")
    @DeleteMapping("/{id}")
    public void softDeleteEstudiante(@PathVariable Integer id) {
        log.info("Eliminando lógicamente al estudiante con ID: {}", id);
        estudianteService.softDeleteEstudiante(id);
    }

    @Operation(summary = "Restaurar un estudiante eliminado")
    @PutMapping("/restaurar/{id}")
    public void restoreEstudiante(@PathVariable Integer id) {
        log.info("Restaurando estudiante con ID: {}", id);
        estudianteService.restoreEstudiante(id);
    }
}
