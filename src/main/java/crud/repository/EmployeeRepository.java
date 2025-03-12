package repository;
import model.User;

import java.util.*;

public class EmployeeRepository {
    private static EmployeeRepository instance;
    private List<User> userList  = new ArrayList<>();

    public static EmployeeRepository getInstance(){
        if(instance == null)
            instance = new EmployeeRepository();
        return instance;
    }

    public List<User> getUserList(){
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void removeUser(User user){
        userList.remove(user);
    }

    public boolean userIsExist(User user){
        return userList.contains(user);
    }

    public int getUserListLength(){
        return userList.size();
    }
}
