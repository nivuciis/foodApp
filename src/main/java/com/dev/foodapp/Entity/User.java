package com.dev.foodapp.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String cpf;
    private String email;
    private String senha;
    private String endereço;
    private String cep;

    @Setter(value = AccessLevel.NONE)
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<UserPermission> userPerm;

    public void setUserPerm(List<UserPermission> userP){
        for(UserPermission p:userP){
            p.setUser(this);
        }
        this.userPerm =  userP;
    }
}
