package org.example.grexspring;

import org.springframework.data.jpa.repository.JpaRepository; //?

import java.util.List;

public interface Repositorio extends JpaRepository<Empresa, Long>{
    List<Empresa> findBySector(String sector);
    List<Empresa> findByEstadoRegistroNotContaining(String estadoRegistro);
    List<Empresa> findByEstadoRegistroContaining(String estadoRegistro);
}

/*public class Repositorio {
}*/
