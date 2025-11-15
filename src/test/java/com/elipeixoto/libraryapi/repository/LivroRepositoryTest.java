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
        Autor autor = new Autor();
        autor.setNome("Eliane");
        autor.setDataNascimento(LocalDate.of(1986, 03, 07));
        autor.setNacionalidade("Brasileira");


        Livro livro = new Livro();
        livro.setTitulo("Livro 4");
        livro.setPreco(BigDecimal.valueOf(50));
        livro.setGenero(GeneroLivroEnum.MISTERIO);
        livro.setIsbn("1287623142");
        livro.setDataPublicacao(LocalDate.of(2025, 10, 31));
        livro.setAutor(autor);

         livroRepository.save(livro);

    }

    @Test
    void deveAtualizarAutorDoLivro(){
        UUID idLivro = UUID.fromString("ea5c31a2-b242-47ff-89d3-f6ce9cc45399");
        var livroParaAtualizar = livroRepository.findById(idLivro).orElse(null);

        UUID idAutor = UUID.fromString("32855672-d42d-463f-a3cb-4d0afa37347f");
        Autor autor = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(autor);

        livroRepository.save(livroParaAtualizar);

    }
}
