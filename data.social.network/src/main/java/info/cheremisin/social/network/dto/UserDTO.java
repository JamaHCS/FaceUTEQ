package info.cheremisin.social.network.dto;

import info.cheremisin.social.network.validation.FieldMatch;
import info.cheremisin.social.network.validation.Password;
import info.cheremisin.social.network.validation.ValidEmail;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordConfirmation", message = "Las contraseñas deben de coíncidir")
})
public class UserDTO {

    private Long id;

    @NotNull
    @ValidEmail
    private String email;

    @NotNull
    @Size(min=6, max=100, message = "Debe de tener una longitud minima de 6 carácteres")
    @Password
    private String password;

    @NotNull
    @Size(min=6, max=100, message = "Debe de tener una longitud minima de 6 carácteres")
    private String passwordConfirmation;

    @NotNull
    @Size(min=2, max=100, message = "Debe de tener una longitud minima de 6 carácteres")
    private String firstName;

    @NotNull
    @Size(min=2, max=100, message = "Debe de tener una longitud minima de 6 carácteres")
    private String lastName;

    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dob;

    private String sex;
    private String phone;
    private Boolean isAdmin;
    private String image;
    private Boolean isProfessor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
