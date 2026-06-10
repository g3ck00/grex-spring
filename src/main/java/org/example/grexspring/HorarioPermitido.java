package org.example.grexspring;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class HorarioPermitido {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    public HorarioPermitido(LocalTime horaInicio, LocalTime horaFin){
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }

    public HorarioPermitido() {

    }

    public Long getId(){return id;}
    public LocalTime getHoraInicio(){return horaInicio;}
    public LocalTime getHoraFin(){return horaFin;}

    public void setId(Long id) {this.id=id;}
    public void setHoraInicio(LocalTime horaInicio){this.horaInicio=horaInicio;}
    public void setHoraFin(LocalTime horaFin){this.horaFin=horaFin;}
}
