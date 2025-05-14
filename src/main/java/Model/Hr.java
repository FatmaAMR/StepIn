package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "hr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "f_name")
    private String fName;

    @Column(name = "l_name")
    private String lName;

    private String email;

    private String pass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "hr", cascade = CascadeType.ALL)
    private List<Internship> internships;
}
