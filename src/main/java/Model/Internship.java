package model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "internships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "application_end_date")
    private LocalDate applicationEndDate;

    @Column(name = "location")
    private String location;

    @Column(name = "is_softly_deleted")
    private boolean isSoftlyDeleted;

    @Column(name = "is_expired")
    private boolean isExpired;

    @Column(name = "company_id")
    private int company_id;

    @Column(name = "uploaded_hr_id")
    private int hr_id;

    @Column(name = "track_id")
    private int track_id;
}