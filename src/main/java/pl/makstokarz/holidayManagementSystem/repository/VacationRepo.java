package pl.makstokarz.holidayManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.makstokarz.holidayManagementSystem.model.Vacation;

public interface VacationRepo extends JpaRepository<Vacation,Long> {
}
