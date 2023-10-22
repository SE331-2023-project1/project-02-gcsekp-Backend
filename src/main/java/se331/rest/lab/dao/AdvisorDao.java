package se331.rest.lab.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.rest.lab.entity.Advisor;

public interface AdvisorDao {
    Integer getAdvisorSize();

    Page<Advisor> getAdvisors(Integer pageSize, Integer page);

    Advisor getAdvisorById(Long id);

    Advisor save(Advisor advisor);

    Optional<Advisor> findById(Long id);

    Page<Advisor> getAdvisor(String name, Pageable page);

}
