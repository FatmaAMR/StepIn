package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    @Column(name = "`desc`", columnDefinition = "TEXT")
    private String desc;

    private String email;

    private String hashPass;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Hr> hrs;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Internship> internships;
}
