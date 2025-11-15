package com.elipeixoto.libraryapi.repository;

import com.elipeixoto.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;


    @Test
    void deveSalvarAutor(){

        Autor autor = new Autor();
        autor.setNome("Eliane Rosa Peixoto");
        autor.setDataNascimento(LocalDate.of(1986, 03, 07));
        autor.setNacionalidade("Brasileira");

        var autorSalvo = autorRepository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }


}
