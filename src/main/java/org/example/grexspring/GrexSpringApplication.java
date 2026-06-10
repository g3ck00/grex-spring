package org.example.grexspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class GrexSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrexSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner cargarDatos(Repositorio repositorio){
        return args->{
            repositorio.save(new Empresa(
                    "Empresa A",
                    "Tecnología",
                    1000,
                    LocalDate.of(1999,12,25),
                    "Guayaquil",
                    "empresa-a.com",
                    true,
                    "a",
                    LocalTime.of(12,0)));

            repositorio.save(new Empresa(
                    "Empresa B",
                    "Salud",
                    2000,
                    LocalDate.of(1945,12,1),
                    "Quito",
                    "empresa-b.com.ec",
                    false,
                    "i",
                    LocalTime.of(12,0)));

            repositorio.save(new Empresa(
                    "Empresa C",
                    "Finanzas",
                    3000,
                    LocalDate.of(1985,1,15),
                    "Manta",
                    "empresa-c.com",
                    true,
                    "a",
                    LocalTime.of(12,0)));

            repositorio.save(new Empresa(
                    "Empresa D",
                    "Finanzas",
                    1200,
                    LocalDate.of(2000,6,1),
                    "Cuenca",
                    "empresa-d.com",
                    false,
                    "i",
                    LocalTime.of(12,0)));

            repositorio.save(new Empresa(
                    "Empresa E",
                    "Tecnología",
                    500,
                    LocalDate.of(1975,6,30),
                    "Ambato",
                    "empresa-e.com",
                    true,
                    "a",
                    LocalTime.of(12,0)));

            repositorio.save(new Empresa(
                    "Empresa F",
                    "Salud",
                    200,
                    LocalDate.of(1991,9,14),
                    "Guayaquil",
                    "empresa-f.com",
                    true,
                    "n",
                    LocalTime.of(12,0)));
        };
    }

    @Bean
    CommandLineRunner cargarHorario(Repositorio repositorio, HorarioPermitidoRepository horarioRepo){
        return args ->{
            horarioRepo.save(new HorarioPermitido(LocalTime.of(8,0), LocalTime.of(17,0)));
        };
    }
}
