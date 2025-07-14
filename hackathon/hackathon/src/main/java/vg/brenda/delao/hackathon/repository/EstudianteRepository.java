package vg.brenda.delao.hackathon.repository;

import vg.brenda.delao.hackathon.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    // Buscar por estado (A = activo, I = inactivo)
    List<Estudiante> findByEstado(char estado);

    // Buscar por DNI único
    Optional<Estudiante> findByDni(String dni);

    // Buscar por ID y estado (opcional para obtener solo si está activo)
    Optional<Estudiante> findByIdEstudianteAndEstado(Integer idEstudiante, char estado);
}
