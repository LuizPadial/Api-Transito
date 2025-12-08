package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("/proprietarios")
    public List<Proprietario> listar(){
        var proprietario1 = new Proprietario();
        proprietario1.setId(1L);
        proprietario1.setNome("joão");
        proprietario1.setTelefone("34 99999-1111");
        proprietario1.setEmail("joaoroscagasta@gmail.com");

        var proprietario2 = new Proprietario();
        proprietario2.setId(2L);
        proprietario2.setNome("Pedro");
        proprietario2.setTelefone("34 88888-7777");
        proprietario2.setEmail("pedroboqueta@gmail.com");

        return Arrays.asList(proprietario1,proprietario2);

    }
}
