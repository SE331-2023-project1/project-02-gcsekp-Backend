package se331.rest.lab.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.rest.lab.entity.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    List<Advisor> findAll();

    Page<Advisor> findByNameContainingIgnoreCaseOrAdvisorID(String name, String advisorID, Pageable pageable);

}
