package main.java.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "driverLicense",uniqueConstraints = {
        @UniqueConstraint(columnNames = "number")
})
public class DriverLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private int number;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverLicense that = (DriverLicense) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @PreRemove
    public void preRemove(){
        user.setDriverLicense(null);
    }
}
