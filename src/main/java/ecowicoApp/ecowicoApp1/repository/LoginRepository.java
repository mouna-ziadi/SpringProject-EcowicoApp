package ecowicoApp.ecowicoApp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecowicoApp.ecowicoApp1.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findByUsernameAndPassword(String username, String password);

	Login findByUsername(String username);





}
