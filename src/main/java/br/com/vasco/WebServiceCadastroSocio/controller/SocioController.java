package br.com.vasco.WebServiceCadastroSocio.controller;

import br.com.vasco.WebServiceCadastroSocio.models.Socio;
import br.com.vasco.WebServiceCadastroSocio.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class SocioController {

    private final SocioRepository socioRepository;

    @Autowired
    public SocioController(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    @RequestMapping( value = "/getSocio", method = RequestMethod.POST)
    public List<Socio> buscaSocio(@RequestBody Socio socio){
        List<Socio> listaSocios = new ArrayList<>();
        try {
            if( socio.getMatricula() != null && !socio.getMatricula().isEmpty() ){
                listaSocios = socioRepository.findByMatricula(socio.getMatricula());
            } else if( listaSocios.isEmpty() && socio.getNome() != null && !socio.getNome().isEmpty() ) {
                listaSocios = socioRepository.findByNome(socio.getNome());
            } else if( listaSocios.isEmpty() && socio.getCpf() != null && !socio.getCpf().isEmpty() ) {
                listaSocios = socioRepository.findByCpf(socio.getCpf());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return listaSocios;
    }
}