package stqa.mantis.model;

public class UserData {
    public int id;
    public String userName;
    public String mail;

  /*
  public UserData(int id, String username, String mail) {
    this.id = id;
    this.userName = username;
    this.mail = mail;
  }
  */

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getMail() {
        return mail;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }


    public UserData withUserName(String username) {
        this.userName = username;
        return this;
    }

    public UserData withMail(String mail) {
        this.mail = mail;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
