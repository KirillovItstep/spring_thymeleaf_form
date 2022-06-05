package com.company.spring_thymeleaf_form.firms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class FirmService {
        @Autowired
        private FirmRepository firmRepository;

        public List<Firm> findAll() {
            return firmRepository.findAll();
        }

        public void save(Firm firm) {
            firmRepository.save(firm);
        }

        public Firm findById(Long id) {
            return firmRepository.findById(id).get();
        }

        public void deleteById(Long id) {
            firmRepository.deleteById(id);
        }
    }
