package se331.rest.lab.service;

import org.springframework.data.domain.Page;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Pageable;

import se331.rest.lab.entity.Advisor;

public interface AdvisorService {
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);

    Advisor getEvent(Long id);

    Advisor save(Advisor advisor);

    Advisor getAdvisorById(Long id);

    Page<Advisor> getAdvisor(String name, Pageable page);

}
