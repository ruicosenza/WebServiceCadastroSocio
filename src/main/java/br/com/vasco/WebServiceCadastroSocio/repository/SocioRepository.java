package br.com.vasco.WebServiceCadastroSocio.repository;

import br.com.vasco.WebServiceCadastroSocio.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
    List<Socio> findByNome(String nome);
    List<Socio> findByCpf(String cpf);
    List<Socio> findByMatricula(String matricula);
}