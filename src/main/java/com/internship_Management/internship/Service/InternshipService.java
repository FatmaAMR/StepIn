package com.internship_Management.internship.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship_Management.internship.repository.InternshipRepository;

import model.Internship;

@Service
public class InternshipService {
    @Autowired
    private InternshipRepository repo;
    public String showInterns(String interns){
        return interns;
    }

    public List<Internship> getAllInternships() {
        return repo.findAll();
    }

public Optional<Internship> getInternshipById(int id) {
        return repo.findById(id);
    }

    public Internship createInternship(Internship internship) {
        internship.setSoftlyDeleted(false); // Ensure new internships are not deleted
        internship.setExpired(false); // Ensure new internships are not expired
        return repo.save(internship);
    }

    
    public Internship updateInternship(int id, Internship updatedInternship) {
        return repo.findById(id)
            .map(existing -> {
                existing.setTitle(updatedInternship.getTitle());
                existing.setDescription(updatedInternship.getDescription());
                existing.setStartDate(updatedInternship.getStartDate());
                existing.setEndDate(updatedInternship.getEndDate());
                existing.setApplicationEndDate(updatedInternship.getApplicationEndDate());
                existing.setCompanyId(updatedInternship.getCompanyId());
                existing.setUploadedHrId(updatedInternship.getUploadedHrId());
                return repo.save(existing);
            }).orElse(null); 
    }

    
    public void deleteInternship(int id) {
        repo.deleteById(id);
    }

    // Soft delete an internship by setting isSoftlyDeleted to true (for HR or Admin)
    public boolean softDeleteInternship(int id) {
        return repo.findById(id)
                .map(internship -> {
                    internship.setSoftlyDeleted(true);
                    repo.save(internship);
                    return true;
                })
                .orElse(false);
    }

    // Search internships by keyword in title or description
    public List<Internship> searchByTitleOrDescription(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllInternships();
        }
        return repo.findByTitleOrDescriptionContaining(keyword);
    }

    // Search internships by track ID
    public List<Internship> searchByTrackId(int trackId) {
        return repo.findByTrackIdAndIsSoftlyDeletedFalse(trackId);
    }

   
}