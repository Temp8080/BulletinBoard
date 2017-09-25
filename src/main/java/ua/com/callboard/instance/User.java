package ua.com.callboard.instance;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mvcusers")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String pass;

    private String fav;

    @Column(nullable = false)
    private String phone;

    public User(String login, String pass, String fav, String phone) {
        this.login = login;
        this.pass = pass;
        this.fav = fav;
        this.phone = phone;
    }
}
