package com.internship_Management.internship.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.internship_Management.internship.Service.InternshipService;

import model.Internship;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/Internship")
public class InternshipController {
    
   @Autowired
   private InternshipService InternService;
@GetMapping
public ResponseEntity<List<Internship>> getAllInternships() {
    List<Internship> internships = InternService.getAllInternships();
    
    if (internships.isEmpty()) {
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.emptyList()); 
    }
    
    return ResponseEntity.ok(internships); 
}


    @GetMapping("/{id}")
    public ResponseEntity<Internship> getInternshipById(@PathVariable int id) {
        Optional<Internship> internship = InternService.getInternshipById(id);
        return internship.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

@PostMapping
public ResponseEntity<Internship> createInternship(@RequestBody Internship internship) {
    try {
        Internship createdInternship = InternService.createInternship(internship);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInternship);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
    }
}

    @GetMapping("/track/{trackId}")
public ResponseEntity<List<Internship>> searchByTrackId(@PathVariable int trackId) {
    List<Internship> internships = InternService.searchByTrackId(trackId);

    if (internships.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.emptyList()); 
    }
  return ResponseEntity.ok(internships); 
}
@GetMapping("/search")
public ResponseEntity<List<Internship>> searchInternships(@RequestParam String keyword) {
    List<Internship> internships = InternService.searchByTitleOrDescription(keyword);

    if (internships.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
    }
    return ResponseEntity.ok(internships);
}


    @DeleteMapping("/{id}")
public ResponseEntity<Void> softDeleteInternship(@PathVariable int id) {
    boolean deleted = InternService.softDeleteInternship(id);
    if (deleted) {
        return ResponseEntity.noContent().build(); // 204 No Content
    } else {
        return ResponseEntity.notFound().build(); // 404 Not Found
    }
}


}
