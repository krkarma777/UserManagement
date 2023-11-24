import java.util.ArrayList;

public class UserViewer {
    private UserRegister userRegister;

    public UserViewer(UserRegister userRegister) {
        this.userRegister = userRegister;
    }

    public void displayUsers() {
        ArrayList<User> userList = userRegister.getUserList();

        if (userList.isEmpty()) {
            System.out.println("가입된 회원이 없습니다.");
        } else {
            System.out.println("가입된 회원 목록:");
            for (User user : userList) {
                System.out.println("이름: " + user.getName() +
                        ", 이메일: " + user.getEmail() +
                        ", 생년: " + user.getBirthyear());
            }
        }
    }
}
