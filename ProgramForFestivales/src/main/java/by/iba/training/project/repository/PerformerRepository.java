package by.iba.training.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.iba.training.project.people.Performer;

public interface PerformerRepository extends JpaRepository<Performer, Integer> {

}
