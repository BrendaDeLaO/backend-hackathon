package vg.brenda.delao.hackathon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vg.brenda.delao.hackathon.model.Estudiante;
import vg.brenda.delao.hackathon.repository.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository repository;

    // Listar todos los estudiantes (sin filtro)
    public List<Estudiante> getAllEstudiantes() {
        return repository.findAll();
    }

    // Listar solo estudiantes activos (estado = 'A')
    public List<Estudiante> getActiveEstudiantes() {
        return repository.findByEstado('A');
    }

    // Listar solo estudiantes inactivos (estado = 'I')
    public List<Estudiante> getInactiveEstudiantes() {
        return repository.findByEstado('I');
    }

    // Buscar por ID (solo si está activo)
    public Optional<Estudiante> getEstudianteById(Integer id) {
        return repository.findByIdEstudianteAndEstado(id, 'A');
    }

    // Guardar nuevo estudiante
    public Estudiante saveEstudiante(Estudiante estudiante) {
        estudiante.setEstado('A'); // por defecto activo

        if (estudiante.getPrograma() == null || estudiante.getUbigeo() == null) {
            throw new IllegalArgumentException("El programa y el ubigeo no pueden ser nulos.");
        }

        return repository.save(estudiante);
    }

    // Actualizar estudiante
    public Estudiante updateEstudiante(Integer id, Estudiante updatedEstudiante) {
        return repository.findById(id).map(estudiante -> {
            estudiante.setNombres(updatedEstudiante.getNombres());
            estudiante.setApellidos(updatedEstudiante.getApellidos());
            estudiante.setDni(updatedEstudiante.getDni());
            estudiante.setCorreo(updatedEstudiante.getCorreo());
            estudiante.setTelefono(updatedEstudiante.getTelefono());
            estudiante.setFechaNacimiento(updatedEstudiante.getFechaNacimiento());
            estudiante.setPrograma(updatedEstudiante.getPrograma());
            estudiante.setUbigeo(updatedEstudiante.getUbigeo());
            return repository.save(estudiante);
        }).orElse(null);
    }

    // Eliminación lógica (estado = 'I')
    public void softDeleteEstudiante(Integer id) {
        repository.findById(id).ifPresent(estudiante -> {
            estudiante.setEstado('I');
            repository.save(estudiante);
        });
    }

    // Restaurar estudiante (estado = 'A')
    public void restoreEstudiante(Integer id) {
        repository.findById(id).ifPresent(estudiante -> {
            estudiante.setEstado('A');
            repository.save(estudiante);
        });
    }
}
