package se331.rest.lab.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import se331.rest.lab.entity.Advisor;
import se331.rest.lab.repository.AdvisorRepository;

@Component
@RequiredArgsConstructor
public class InitApp {
    final AdvisorRepository advisorRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        advisorRepository.save(Advisor.builder()
                .name("Somsak")
                .surname("Smith")
                .department("English language teaching")
                .position("Lecturer")
                .build());
        advisorRepository.save(Advisor.builder()
                .name("Ahmed")
                .surname("Khan")
                .department("Business Administration")
                .position("Researcher")
                .build());
    }

}
