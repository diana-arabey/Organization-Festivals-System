package by.iba.training.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.iba.training.project.people.ContactInfo;

public interface ContInfoRepository extends JpaRepository<ContactInfo, Integer>{

}
