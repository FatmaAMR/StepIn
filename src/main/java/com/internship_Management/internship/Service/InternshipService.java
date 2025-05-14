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
                existing.setLocation(updatedInternship.getLocation());
                existing.setCompany_id(updatedInternship.getCompany_id());
                existing.setHr_id(updatedInternship.getHr_id());
                existing.setTrack_id(updatedInternship.getTrack_id());
                existing.setSoftlyDeleted(updatedInternship.isSoftlyDeleted());
                existing.setExpired(updatedInternship.isExpired());
                return repo.save(existing);
            }).orElse(null);
    }

    public void deleteInternship(int id) {
        repo.deleteById(id);
    }

    public boolean softDeleteInternship(int id) {
        return repo.findById(id)
            .map(internship -> {
                internship.setSoftlyDeleted(true);
                repo.save(internship);
                return true;
            })
            .orElse(false);
    }

    public List<Internship> searchByTitleOrDescription(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllInternships();
        }
        return repo.findByTitleOrDescriptionContaining(keyword);
    }

    public List<Internship> searchByTrackId(int trackId) {
        return repo.findByTrackIdAndSoftlyDeletedFalse(trackId);
    }
}