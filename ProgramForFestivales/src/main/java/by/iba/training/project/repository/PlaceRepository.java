package by.iba.training.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.iba.training.project.event.PlaceOfEvent;



public interface PlaceRepository extends JpaRepository<PlaceOfEvent, Integer> {

}
