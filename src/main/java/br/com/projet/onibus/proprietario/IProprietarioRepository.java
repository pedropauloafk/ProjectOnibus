package br.com.projet.onibus.proprietario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProprietarioRepository extends JpaRepository<Proprietario, Long> {


}
