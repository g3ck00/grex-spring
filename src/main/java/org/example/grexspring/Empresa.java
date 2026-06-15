package org.example.grexspring;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.*;
import jdk.jfr.BooleanFlag;
import org.example.grexspring.validation.Actualizar;
import org.example.grexspring.validation.Crear;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Funciona como el "AutoIncrease" para IDs en SQL
    private Long id;

    @NotBlank(message="El nombre no puede estar vacío.")
    private String nombre;

    @NotBlank(message="El sector no puede estar vacío.")
    private String sector;

    @Positive(message="El número de empleados no puede ser menor o igual a cero.")
    private Integer numeroEmpleados;

    @PastOrPresent(message="La fecha no puede ser después del día actual.")
    @NotNull(message="La fecha de fundación no puede estar vacío.")
    private LocalDate fechaFundacion;

    @NotBlank(message="La ciudad de la sede principal no puede estar vacía.")
    private String ciudadSedePrincipal;

    private String sitioWebURL;

    //Caso especial: es difícil lograr que se acepte tan solo "true" or "false" (el parser de Jackson es muy insistente en tomar cualquier dato como válido)
    //@NotNull
    //private Boolean enOperaciones;

    //Estado del registro: a=activo, i=inactivo, n=no
    @NotBlank(message="El estado del registro no puede estar vacío...")
    @Pattern(regexp="^(a|i|n)$", message="Ingrese solo una opción válida (a, i, n)...")
    private String estadoRegistro;

    @NotNull(message="La hora de solicitud no puede estar vacía.")
    private LocalTime horaSolicitud;

    @NotBlank(message="El usuario de ingreso no puede estar vacío...", groups=Crear.class)
    private String usuarioIngreso;

    @NotBlank(message="El usuario de modificación no puede estar vacío...", groups = Actualizar.class)
    private String usuarioModificacion;

    //Toda entidad JPA debe tener un constructor sin argumentos (al menos public o protected).
    public Empresa(){

    }

    public Empresa (String nombre, String sector, Integer numeroEmpleados,
                    LocalDate fechaFundacion, String ciudadSedePrincipal, String sitioWebURL,
                    /* enOperaciones,*/ String estadoRegistro, LocalTime horaSolicitud){
        this.nombre=nombre;

        this.sector=sector;
        this.numeroEmpleados=numeroEmpleados;
        this.fechaFundacion=fechaFundacion;
        this.ciudadSedePrincipal=ciudadSedePrincipal;
        this.sitioWebURL=sitioWebURL;
        //this.enOperaciones=enOperaciones;
        this.estadoRegistro=estadoRegistro;
        this.horaSolicitud=horaSolicitud;
        //this.usuarioIngreso=usuarioIngreso;
        //this.usuarioModificacion=usuarioModificacion;
    }

    //Getters
    public Long getId(){return id;}
    public String getNombre(){return nombre;}
    public String getSector(){return sector;}
    public Integer getNumeroEmpleados(){return numeroEmpleados;}
    public LocalDate getFechaFundacion(){return fechaFundacion;}
    public String getCiudadSedePrincipal()
                    {return ciudadSedePrincipal;}
    public String getSitioWebURL(){return sitioWebURL;}
    //public boolean getEnOperaciones(){return enOperaciones;}
    public String getEstadoRegistro(){return estadoRegistro;}
    public LocalTime getHoraSolicitud(){return horaSolicitud;}
    public String getUsuarioIngreso(){return usuarioIngreso;}
    public String getUsuarioModificacion(){return usuarioModificacion;}

    //Setters
    public void setId(Long id){this.id=id;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public void setSector(String sector){this.sector=sector;}
    public void setNumeroEmpleados(Integer numEmpleados)
                {this.numeroEmpleados=numEmpleados;}
    public void setFechaFundacion(LocalDate fechaFundacion)
                {this.fechaFundacion=fechaFundacion;}
    public void setCiudadSedePrincipal(String ciudadSedePrincipal)
                {this.ciudadSedePrincipal=ciudadSedePrincipal;}
    public void setSitioWebURL(String sitioWebURL)
                {this.sitioWebURL=sitioWebURL;}
    //public void setEnOperaciones(boolean enOperaciones){this.enOperaciones=enOperaciones;}
    public void setEstadoRegistro(String estadoRegistro){this.estadoRegistro=estadoRegistro;}
    public void setHoraSolicitud(LocalTime horaSolicitud){this.horaSolicitud=horaSolicitud;}
    public void setUsuarioIngreso(String usuarioIngreso){this.usuarioIngreso=usuarioIngreso;}
    public void setUsuarioModificacion(String usuarioModificacion){this.usuarioModificacion=usuarioModificacion;}
}
