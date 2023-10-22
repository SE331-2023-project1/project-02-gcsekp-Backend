package se331.rest.lab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import se331.rest.lab.dao.AdvisorDao;
import se331.rest.lab.entity.Advisor;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService {
    final AdvisorDao advisorDao;

    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page) {
        return advisorDao.getAdvisors(pageSize, page);
    }

    @Override
    public Advisor getEvent(Long id) {
        return advisorDao.getAdvisorById(id);
    }

    @Override
    @Transactional
    public Advisor save(Advisor advisor) {
        return advisorDao.save(advisor);
    }

    @Override
    public Advisor getAdvisorById(Long id) {
        return advisorDao.findById(id).orElse(null);
    }

    @Override
    public Page<Advisor> getAdvisor(String name, Pageable page) {
        return advisorDao.getAdvisor(name, page);
    }

}
