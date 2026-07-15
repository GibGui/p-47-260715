import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main{
    public static void main(String[] args){
        System.out.println("=== 명언 앱!!!! ===");

        Scanner sc = new Scanner(System.in);
        List<String> wiseSay = new ArrayList<>();
        List<String> author = new ArrayList<>();


        while (true){



            System.out.print("명령) ");
            String commend = sc.nextLine();

            if (commend.equals("종료")){
                break;

            }else if(commend.equals("등록")){
                System.out.print("명언 : ");
                String wiseSays = sc.nextLine();
                System.out.print("작가 : ");
                String authors = sc.nextLine();
                wiseSay.add(wiseSays);
                author.add(authors);
                System.out.println(wiseSay.size() + " 번 명언이 등록되었습니다.");



            }

        }





    }

}
