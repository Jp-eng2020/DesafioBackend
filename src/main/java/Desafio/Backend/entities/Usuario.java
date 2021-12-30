package Desafio.Backend.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String nome;

    @CPF
    private String cpf;

    @NotEmpty
    private String telefone;

    @NotEmpty
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "Idioma_id")
    private Idioma idioma;

    @NotEmpty
    private String password;

    @NotEmpty
    private String perfil;

    @NotNull
    private String role;

    @Column(nullable=false)
    private boolean active;
    @PrePersist
    public void prePersist(){
        this.active = true;
    }

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Arrays.stream(role.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}