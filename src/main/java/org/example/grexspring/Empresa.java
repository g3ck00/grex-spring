package org.example.grexspring;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.*;
import org.example.grexspring.validation.Actualizar;
import org.example.grexspring.validation.Crear;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Funciona como el "AutoIncrease" para IDs en SQL
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String sector;

    @Positive
    private Integer numeroEmpleados;

    @PastOrPresent @NotNull
    private LocalDate fechaFundacion;

    @NotBlank
    private String ciudadSedePrincipal;

    private String sitioWebURL;

    @NotNull
    private boolean enOperaciones;

    //Estado del registro: a=activo, i=inactivo, n=no
    @NotBlank @Pattern(regexp="^(a|i|n)$")
    private String estadoRegistro;

    @NotNull
    private LocalTime horaSolicitud;

    @NotBlank(message="El usuario de ingreso es obligatorio...", groups = Crear.class)
    private String usuarioIngreso;

    @NotBlank(message="El usuario de modificación es obligatorio...", groups = Actualizar.class)
    private String usuarioModificacion;

    //Toda entidad JPA debe tener un constructor sin argumentos (al menos public o protected).
    public Empresa(){

    }

    public Empresa (String nombre, String sector, Integer numeroEmpleados,
                    LocalDate fechaFundacion, String ciudadSedePrincipal, String sitioWebURL,
                    boolean enOperaciones, String estadoRegistro, LocalTime horaSolicitud){
        this.nombre=nombre;

        this.sector=sector;
        this.numeroEmpleados=numeroEmpleados;
        this.fechaFundacion=fechaFundacion;
        this.ciudadSedePrincipal=ciudadSedePrincipal;
        this.sitioWebURL=sitioWebURL;
        this.enOperaciones=enOperaciones;
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
    public boolean getEnOperaciones(){return enOperaciones;}
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
    public void setEnOperaciones(boolean enOperaciones){this.enOperaciones=enOperaciones;}
    public void setEstadoRegistro(String estadoRegistro){this.estadoRegistro=estadoRegistro;}
    public void setHoraSolicitud(LocalTime horaSolicitud){this.horaSolicitud=horaSolicitud;}
    public void setUsuarioIngreso(String usuarioIngreso){this.usuarioIngreso=usuarioIngreso;}
    public void setUsuarioModificacion(String usuarioModificacion){this.usuarioModificacion=usuarioModificacion;}
}
