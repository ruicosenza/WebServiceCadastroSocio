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

    @RequestMapping( value = "/getSocio", method = RequestMethod.GET)
    public List<Socio> buscaSocio(@RequestParam(value="nome") String nome, @RequestParam(value="cpf") String cpf, @RequestParam(value="matricula") String matricula){
        List<Socio> listaSocios = new ArrayList<>();
        try {
            if( !matricula.isEmpty() ){
                listaSocios = socioRepository.findByMatricula(matricula);
            } else if( listaSocios.isEmpty() && !nome.isEmpty() ) {
                listaSocios = socioRepository.findByNome(nome);
            } else if( listaSocios.isEmpty() && !cpf.isEmpty() ) {
                listaSocios = socioRepository.findByCpf(cpf);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return listaSocios;
    }
}