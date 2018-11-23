package by.iba.training.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import by.iba.training.project.event.PlaceOfEvent;



public interface PlaceRepository extends CrudRepository<PlaceOfEvent, Integer> {
	
}
