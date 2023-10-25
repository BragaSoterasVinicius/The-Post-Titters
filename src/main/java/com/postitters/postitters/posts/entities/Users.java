package com.postitters.postitters.posts.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARROBA")
    private String arroba;
    @Column(name = "BIO")
    private String bio;
    @Column(name = "FACEPIC")
    private String facepic;
    @Column(name = "NICK")
    private String nick;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "SNH")
    private String senha;

    public String getArroba() {
        return arroba;
    }

    public void setArroba(String arroba) {
        this.arroba = arroba;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFacepic() {
        return facepic;
    }

    public void setFacepic(String facepic) {
        this.facepic = facepic;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
