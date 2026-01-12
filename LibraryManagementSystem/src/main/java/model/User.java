package model;

public class User {

   private int userId;
   private String name;
   private int role;
   private String isBlocked;

   public User(){


   }

    public User(int userId, String name, int role, String isBlocked) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.isBlocked = isBlocked;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(String isBlocked) {
        this.isBlocked = isBlocked;
    }
}
