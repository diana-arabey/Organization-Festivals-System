package by.iba.training.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import by.iba.training.project.people.UserInfo;



public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
