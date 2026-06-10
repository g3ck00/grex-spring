package org.example.grexspring;

import org.example.grexspring.validation.Actualizar;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final Repositorio repositorio;
    private final HorarioPermitidoRepository horarioRepo;
    //private final EmpresaController empresa;

    public EmpresaService(Repositorio repositorio, HorarioPermitidoRepository horarioRepo) {
        this.repositorio = repositorio;
        this.horarioRepo = horarioRepo;
        //this.empresa = empresa;
    }

    //repositorio.save() guarda el objeto en la base de datos
    //Spring devuelve automáticamente el objeto guardado como JSON
    public Empresa crear(Empresa empresa) {
        HorarioPermitido horario = horarioRepo.findById(1L).orElseThrow();

        LocalTime hora=empresa.getHoraSolicitud();

        boolean permitido=!hora.isBefore(horario.getHoraInicio()) && !hora.isAfter(horario.getHoraFin());

        if (!permitido) {
            throw new HorarioNoPermitidoException("Fuera del horario permitido...");
        } else {
            return repositorio.save(empresa);
        }
    }

    //UPDATE|
    public Empresa actualizar(Long id, Empresa empresaActualizada) {

        HorarioPermitido horario = horarioRepo.findById(1L).orElseThrow();

        LocalTime hora=empresaActualizada.getHoraSolicitud();

        boolean permitido=!hora.isBefore(horario.getHoraInicio()) && !hora.isAfter(horario.getHoraFin());

        if (!permitido) {
            throw new HorarioNoPermitidoException("Fuera del horario permitido...");
        } else {
            Empresa empresa = (Empresa) repositorio.findById(id).orElseThrow();
            empresa.setNombre(empresaActualizada.getNombre());
            empresa.setSector(empresaActualizada.getSector());
            empresa.setNumeroEmpleados(empresaActualizada.getNumeroEmpleados());
            empresa.setFechaFundacion(empresaActualizada.getFechaFundacion());
            empresa.setCiudadSedePrincipal(empresaActualizada.getCiudadSedePrincipal());
            empresa.setSitioWebURL(empresaActualizada.getSitioWebURL());
            empresa.setEnOperaciones(empresaActualizada.getEnOperaciones());
            empresa.setEstadoRegistro(empresaActualizada.getEstadoRegistro());
            return repositorio.save(empresa);
        }
    }

    public List<Empresa> findByEstadoRegistroNotContaining(String n) {
        return repositorio.findByEstadoRegistroNotContaining(n);
    }

    public List<Empresa> findByEstadoRegistroContaining(String n) {
        return repositorio.findByEstadoRegistroContaining(n);
    }

    public Optional<Object> findById(Long id) {
        return Optional.of(repositorio.findById(id));
    }

    public Empresa save(Empresa empresa) {
        return repositorio.save(empresa);
    }
}
