package pl.makstokarz.holidayManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.makstokarz.holidayManagementSystem.model.Vacation;
import pl.makstokarz.holidayManagementSystem.repository.VacationRepo;

import java.util.List;

@RestController
public class VacationController {

    @Autowired
    private VacationRepo vacationRepo;

    @GetMapping("/vacations")
    public ResponseEntity<List<Vacation>> getAllVacations(){
        return new ResponseEntity<>(vacationRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping("/vacations")
    public ResponseEntity<List<Vacation>> addVacation(@RequestBody List<Vacation> vacationList){
        return new ResponseEntity<>(vacationRepo.saveAll(vacationList), HttpStatus.OK);
    }

    @GetMapping("/vacations/{id}")
    public ResponseEntity<Vacation> getVacationById(@PathVariable Long id){
        return vacationRepo.findById(id)
                .map(vacation -> new ResponseEntity<>(vacation,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/vacations/{id}")
    public ResponseEntity<Vacation> updateVacation(@RequestBody Vacation vacationData, @PathVariable Long id){
        return vacationRepo.findById(id)
                .map(vacation -> {
                    vacation.setName(vacationData.getName());
                    vacation.setStart_date(vacationData.getStart_date());
                    vacation.setEnd_date(vacationData.getEnd_date());
                    vacation.setDescription(vacationData.getDescription());
                    return vacation;
                })
                .map(vacationRepo::save)
                .map(vacation -> new ResponseEntity<>(vacation,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PatchMapping("/vacations/transportcost/{id}")
    public ResponseEntity<Vacation> updateTransportCost(@RequestBody Vacation vacationData, @PathVariable Long id){
        return vacationRepo.findById(id)
                .map(vacation -> {
                    vacation.setTransportCost(vacationData.getTransportCost());
                    return vacation;
                })
                .map(vacationRepo::save)
                .map(vacation -> new ResponseEntity<>(vacation,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PatchMapping("/vacations/accommodationcost/{id}")
    public ResponseEntity<Vacation> updateAccommodationCost(@RequestBody Vacation vacationData, @PathVariable Long id){
        return vacationRepo.findById(id)
                .map(vacation -> {
                    vacation.setAccommodationCost(vacationData.getAccommodationCost());
                    return vacation;
                })
                .map(vacationRepo::save)
                .map(vacation -> new ResponseEntity<>(vacation,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PatchMapping("/vacations/othercost/{id}")
    public ResponseEntity<Vacation> updateOtherCost(@RequestBody Vacation vacationData, @PathVariable Long id){
        return vacationRepo.findById(id)
                .map(vacation -> {
                    vacation.setOtherCost(vacationData.getOtherCost());
                    return vacation;
                })
                .map(vacationRepo::save)
                .map(vacation -> new ResponseEntity<>(vacation,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/vacations/{id}")
    public ResponseEntity<Void> deleteVacationById(@PathVariable Long id){
        return vacationRepo.findById(id)
                .map(vacation -> {
                    vacationRepo.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




}
