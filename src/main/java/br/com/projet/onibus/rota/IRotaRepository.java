package br.com.projet.onibus.rota;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRotaRepository extends JpaRepository<Rota, Long> {


    Page<Rota> findAllByViagemTrue(Pageable paginacao);
}
