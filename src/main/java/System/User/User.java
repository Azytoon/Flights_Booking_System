package System.User;

import java.util.UUID;


public class User {

    private final UUID UserId;

    private String Name = null;

    public User(UUID UserId,String Name) {
        this.UserId = UserId;
        this.Name = Name;
    }


	public UUID getUserId() {
		return UserId;
	}


	public String getName() {
		return Name;
	}
    
}
