package lk.ijse.userservice.repo;



import lk.ijse.userservice.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterUserRepo extends JpaRepository<RegisterUser, Long> {

    List<RegisterUser> findRegisterUserByName(String name);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);

    Optional<RegisterUser> findByEmail(String email);

    Optional<RegisterUser> findOneByEmailAndPassword(String email,String password);


}
