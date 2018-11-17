package by.iba.training.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.iba.training.project.event.Event;




public interface EventRepository extends JpaRepository<Event, Integer> {

}
