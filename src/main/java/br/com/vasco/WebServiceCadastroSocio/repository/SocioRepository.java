package br.com.vasco.WebServiceCadastroSocio.repository;

import br.com.vasco.WebServiceCadastroSocio.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
    @Query("SELECT s FROM Socio s WHERE s.nome LIKE CONCAT('%',:nome,'%')")
    List<Socio> findByNome(@Param("nome") String nome);
    List<Socio> findByCpf(String cpf);
    List<Socio> findByMatricula(String matricula);
}