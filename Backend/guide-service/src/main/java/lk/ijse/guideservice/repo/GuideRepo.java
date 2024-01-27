package lk.ijse.guideservice.repo;
import lk.ijse.guideservice.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;

public interface GuideRepo extends JpaRepository<Guide,Long> {

    boolean existsByIdAndContactnumber(long id,String  contactnumber);

    void deleteById(Long id);

    ArrayList<Guide> findByGuidename(String guidename);
}
