package pl.makstokarz.holidayManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate start_date;
    private LocalDate end_date;
    private String description;
    private Double transportCost;
    private Double accommodationCost;
    private Double otherCost;
    private Double totalCost;
    private List<String> placesToSee;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @PrePersist
    @PreUpdate
    public void calculateTotalCost(){
        totalCost = transportCost + accommodationCost + otherCost;
    }

}
