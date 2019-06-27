package ke.jakinda.APR.PLATEREC.activities.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by jakin on 07/03/2018.
 */
@Table(name="Admin")
public class Admin extends Model {


    @Column(name = "name")
    public String name;
    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;
    @Column(name = "repassword")
    public String repassword;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public Admin getUser(String usernames, String passwords) {
        return new Select()
                .from(Admin.class)
                .where("username = ?", usernames)
                .where("password = ?", passwords)
                .executeSingle();
                /*return new select ()
                 *where(Admin.class)
                 * where("password = ?", passwords)
                 * executeSingle();
                 *
                 */
    }


}

