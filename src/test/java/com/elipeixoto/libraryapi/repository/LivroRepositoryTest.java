package com.elipeixoto.libraryapi.repository;

import com.elipeixoto.libraryapi.GeneroLivroEnum;
import com.elipeixoto.libraryapi.model.Autor;
import com.elipeixoto.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;


    @Test
    void deveSalvarLivro(){
        Autor autor = autorRepository.findById(UUID.fromString("175b326f-0b5c-46b0-aa03-89982f2a7e45")).orElse(null);


        Livro livro = new Livro();
        livro.setTitulo("Livro 1");
        livro.setPreco(BigDecimal.valueOf(50));
        livro.setGenero(GeneroLivroEnum.MISTERIO);
        livro.setIsbn("128762142");
        livro.setDataPublicacao(LocalDate.of(2025, 10, 31));
        livro.setAutor(autor);

        var livroSalvo = livroRepository.save(livro);
        System.out.println("Livro salvo: " + livroSalvo);
    }
}
