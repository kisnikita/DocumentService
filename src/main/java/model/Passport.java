package main.java.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Table(name = "passports", uniqueConstraints = {
        @UniqueConstraint(columnNames = "number")
})
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private int series;
    @NonNull
    private int number;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return series == passport.series && number == passport.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(series, number);
    }

    @PreRemove
    public void preRemove(){
        user.setPassport(null);
    }
}
