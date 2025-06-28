import java.util.Date;

class User {
    int userId;
    int balance;
    Date createdDate;
    
    User(int userId, int balance) {
        this.userId = userId;
        this.balance = balance;
        this.createdDate = new Date();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}