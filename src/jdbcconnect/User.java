package jdbcconnect;
import lombok.*;

@Data // Constructor, Getter, Setter, hashCode(), equals(), toSting() 자동생성
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String usersid;
    private String username;
    private String userpassword;
    private int userage;
    private String useremail;

    public String getUsersid() {
        return usersid;
    }

    public void setUsersid(String usersid) {
        this.usersid = usersid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Override
    public String toString() {
        return "User{" +
                "usersid='" + usersid + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", userage=" + userage +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}
