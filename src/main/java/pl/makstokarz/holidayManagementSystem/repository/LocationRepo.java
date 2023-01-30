package pl.makstokarz.holidayManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.makstokarz.holidayManagementSystem.model.Location;

public interface LocationRepo extends JpaRepository<Location,Long> {
}
