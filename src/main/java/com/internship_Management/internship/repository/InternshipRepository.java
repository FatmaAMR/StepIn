package com.internship_Management.internship.repository;

import model.Internship;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InternshipRepository extends JpaRepository<Internship, Integer> {
    // Search by keyword in title or description (case-insensitive)
    @Query("SELECT i FROM Internship i WHERE i.isSoftlyDeleted = false AND " +
           "(LOWER(i.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(i.description) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<Internship> findByTitleOrDescriptionContaining(@Param("keyword") String keyword);

    // Search by track_id
    List<Internship> findByTrackIdAndIsSoftlyDeletedFalse(Integer trackId);
}
