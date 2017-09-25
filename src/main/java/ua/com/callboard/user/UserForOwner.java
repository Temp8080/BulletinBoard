
package ua.com.callboard.user;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserForOwner {

    private String login;

    private String phone;


    public UserForOwner withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserForOwner withPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
