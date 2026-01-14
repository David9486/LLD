package model;

public class User {

   private int userId;
   private String name;
   private int role;
   private boolean isBlocked;

   public User(){


   }

    public User(int userId, String name, int role, boolean isBlocked) {
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

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
}
