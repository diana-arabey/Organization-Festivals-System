package by.iba.training.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import by.iba.training.project.people.User;



public interface UserRepository extends JpaRepository<User, Integer> {

}
