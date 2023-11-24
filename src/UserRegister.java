import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRegister {
    private ArrayList<User> userList;
    private static final String USER_NAME = System.getProperty("user.name");
    public static final String FILE_PATH = "C:/Users/" + USER_NAME + "/AppData/Local/Temp/users.dat";

    File file = new File(FILE_PATH);

    public UserRegister() {
        this.userList = new ArrayList<>();
        loadUsersFromFile();
    }
    public void addUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력해주십시오.");
        String name = sc.nextLine();
        System.out.println("이메일을 입력해주십시오.");
        String email = sc.nextLine();
        System.out.println("생년을 입력해주십시오.");
        int birthyear = Integer.parseInt(sc.nextLine());

        userList.add(new User(name, email, birthyear));
        saveUsersToFile();
    }

    public ArrayList<User> getUserList() {
        return new ArrayList<>(userList);
    }

    private void loadUsersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            userList = (ArrayList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveUsersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

