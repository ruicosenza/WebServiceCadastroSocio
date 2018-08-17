package br.com.vasco.WebServiceCadastroSocio.controller;

import br.com.vasco.WebServiceCadastroSocio.models.Socio;
import br.com.vasco.WebServiceCadastroSocio.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SocioController {

    private final SocioRepository socioRepository;

    @Autowired
    public SocioController(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    @RequestMapping( value = "/getSocio/{socio}", method = RequestMethod.GET)
    public List<Socio> listaSocios(@PathVariable("socio") String nome){
        List<Socio> listaSocios = socioRepository.findAll();

        return listaSocios;
    }
}