package info.cheremisin.social.network.dto;

import info.cheremisin.social.network.validation.FieldMatch;
import info.cheremisin.social.network.validation.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordConfirmation", message = "Las conrtaseñas deben de coíncidir")
})
public class PasswordChangeDTO {

    @NotNull
    @Size(min=6, max=100, message = "Debe de contener mínimo 6 carácteres")
    @Password
    private String oldPassword;

    @NotNull
    @Size(min=6, max=100, message = "Debe de contener mínimo 6 carácteres")
    @Password
    private String password;

    @NotNull
    @Size(min=6, max=100, message = "Debe de contener mínimo 6 carácteres")
    private String passwordConfirmation;
}
