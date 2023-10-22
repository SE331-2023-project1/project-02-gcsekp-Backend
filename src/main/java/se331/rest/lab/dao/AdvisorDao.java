package se331.rest.lab.dao;

import org.springframework.data.domain.Page;

import se331.rest.lab.entity.Advisor;

public class AdvisorDao {
    Integer getAdvisorSize();

    Page<Advisor> getAdvisors(Integer pageSize, Integer page);

    Advisor getAdvisor(Long id);

    Advisor save(Advisor advisor);

}
