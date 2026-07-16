import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Quote {

    int id;
    String content;
    String author;


    public Quote(int id, String wiseSay, String author) {

        this.id = id;
        this.content = wiseSay;
        this.author = author;

    }

}



class QuoteRepository {

    private List<Quote> list = new ArrayList<>(1);
    private int nextId = 1;


    void register(String wiseSay, String author) {


        list.add(new Quote(nextId, wiseSay, author));

        System.out.println(nextId + " 번 명언이 등록되었습니다.");
        nextId++;


    }


    void remove(int id) {

        Quote q = findById(id);

        if (q == null) {
            System.out.println(id + " 번 명언은 없습니다.");
            return;
        }

        list.remove(q);
        System.out.println(id + " 번 명언이 삭제되었습니다.");

    }

    void view() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------------");
        for (int i = list.size() - 1; i >= 0; i--) {
            Quote q = list.get(i);
            System.out.println(q.id + " / " + q.author + " / " + q.content);

        }


    }

    void edit(int id, String newwiseSay, String newauthor) {

        Quote q = findById(id);

        if (q == null) {
            System.out.println(id + " 번 명언은 없습니다.");
            return;

        }
        q.content = newwiseSay;
        q.author = newauthor;

    }



    // 아이디를 주면, 그 아이디의 quote값의 참조값을 리턴해주는 함수. 없으면 null을 리턴하는 함수.
    Quote findById(int id) {

        for (Quote q : list) {
            if (q.id == id) {
                return q;
            }

        }
        return null;

    }
}


public class Main {
    public static void main(String[] args) {
        new Run().start();



    }


}


class Run {


    Scanner sc = new Scanner(System.in);
    QuoteRepository app = new QuoteRepository();


    void start(){
        System.out.println("=== 명언 앱 ===");
        while (true) {


            System.out.print("명령) ");
            String commend = sc.nextLine();

            if (commend.equals("종료")) {
                break;

            } else if (commend.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSays = sc.nextLine();
                System.out.print("작가 : ");
                String authors = sc.nextLine();

                app.register(wiseSays, authors);


            } else if (commend.equals("목록")) {

                app.view();


            } else if (commend.startsWith("삭제?id")) {

                String[] arr = commend.split("=");
                int id2 = Integer.parseInt(arr[1]);
                app.remove(id2);

            } else if (commend.startsWith("수정?id")) {

                String[] arr = commend.split("=");

                int id2 = Integer.parseInt(arr[1]);
                Quote q = app.findById(id2);

                if(q == null){
                    System.out.println(id2 + " 번 명언은 없습니다.");
                    continue;
                }

                System.out.println("명언(기존) : " + q.content);
                System.out.print("명언 : ");
                String wiseSay = sc.nextLine();
                System.out.println("작가(기존) : " + q.author);
                System.out.print("작가 : ");
                String author = sc.nextLine();

                app.edit(id2, wiseSay, author);


            }

        }

    }




}
