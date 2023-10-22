package se331.rest.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.rest.lab.entity.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {

}
