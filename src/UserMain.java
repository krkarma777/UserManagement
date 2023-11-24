import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserMain {
    public static void main(String[] args) {

        fileCreator();
        UserRegister userRegister = new UserRegister();
        UserViewer userViewer = new UserViewer(userRegister);

        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)
        ){
            while(true){

                displayMenu();
                int choice = getUserChoice(br);

                switch (choice){
                    case 1 : // 회원 생성
                        System.out.println("회원 등록을 선택하셨습니다.");
                        userRegister.addUser(); // 생성하는 메서드 추가 예정
                        break;
                    case 2 : // 회원 조회
                        System.out.println("회원 조회를 선택하셨습니다.");
                        userViewer.displayUsers();// 조회하는 메서드 추가 예정
                        break;
                    case 3 : // 프로그램 종료
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default: //잘못된 입력 리턴
                        System.out.println("잘못된 입력값입니다. 다시 입력해주십시오.");
                        break;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    private static void displayMenu(){
        System.out.println("=============");
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 조회");
        System.out.println("3. 프로그램 종료");
        System.out.println("=============");
    }
    private static int getUserChoice(BufferedReader br) throws IOException {
        System.out.println("원하시는 작업을 선택하세요 : ");
        return Integer.parseInt(br.readLine());
    }

    private static void fileCreator(){
        File file = new File(UserRegister.FILE_PATH);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
