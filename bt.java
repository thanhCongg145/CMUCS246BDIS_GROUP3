//REVIEW
package Lab9;
import java.util.Scanner ;
import java.text.ParseException;
import java.util.ArrayList ;
import java.text.SimpleDateFormat ;

class Student {
    public  id , fullname , major ; // lỗi thiếu khai báo string
    public float gpa ;
    Date birthday ; // lỗi chưa import thư viện date
    public void Student (String id , String fullname , String major , float gpa , Date birthday ) {
        this.id = id ;
        this.fullname = fullname ;
        this.major = major ;
        this.gpa = gpa ;
        this.birthday = birthday ;
    }
    
    public void Enter (){
        Scanner input = new Scanner (System.in);
        System.out.println("Enter your id : "); id = input.nextLine() ;
        System.out.println("Enter your fullname : "); fullname = input.nextLine() ;
        System.out.println("Enter your major : "); major = input.nextLine() ;
        System.out.println("Enter your gpa : "); gpa = input.nextFloat();
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy") ;
        System.out.println("Enter you birthday "); input.nextLine() ; String Bd = input.nextLine() ;
        try {
            birthday = sdf.parse(Bd) ;
        }
        catch (ParseException e) {
            System.out.println("dinh dang ngay sinh khong hop le");
        }
    }
    public void EditById () {
        Scanner input = new Scanner (System.in);
        System.out.print("nhap ten can sua : ");
        fullname = input.nextLine() ;
        System.out.print("nhap cong viec can sua : ")//lỗi dấu phẩy
        major = input.nextLine() ;
        System.out.print("nhap gpa can sua : ");
        gpa = input.nextFloat();
    }
    public void print () {
        System.out.println("Id : " + id);
        System.out.println("fullname : " + fullname);
        System.out.println("major : " + major);
        System.out.println("gpa : " + gpa);
        System.out.println("birthday  : " + birthday);
        System.out.println("------------------------");
    }
}
class StudentList  {
    ArrayList<Student> s1 = new ArrayList<> () ;
    public void AddStudent (Student a ) {
        s1.add(a) ;
    }
    public void PrintSv () {
        if (s1.isEmpty()) {
            System.out.println("danh sach sv trong ");
        }
        else {
            for (Student x : s1) {
                x.print(); 
            }
        }
    }
    public void DeleteSv (String id ) {
        for(Student x : s1 ) {
            if (x.id.equals(id)) {
                s1.remove(x) ;
                System.out.println("Da xoa thanh cong");
                break ;
            }
        }
    }
    public void EditIdStudent (String id) {
        for(Student x : s1 ) {
            if (x.id.equals(id)) {
               x.EditById();
                System.out.println("thanh cong !!");
                return ;
            }
            else {
                System.out.println("id sv can chinh sua kh dung !");
            }
        }
    }
} 
public class bt {
    public static void main (String[] args ) {
        StudentList a  = new StudentList () ;
        
        while (true ) {
            System.out.println("------------BANG SINH VIEN-----------");
            System.out.println("1.Nhap sinh vien");
            System.out.println("2.In ra danh sach sinh vien");
            System.out.println("3.Xoa sinh vien theo id ");
            System.out.println("4.Chinh sua sv theo id ");
            System.out.println("5.Thoat ");
            System.out.print("Nhap lua chon : "); 
            int lc = input.nextInt() ; // lỗi chưa khai báo scanner 
            switch (lc) {
                case 1 :
                    Student s1 = new Student () ;
                    // chưa khai báo hàm enter nên chưa thể thêm sv 
                    a.AddStudent(s1);
                    break ;
                case 2 :
                    a.PrintSv(); 
                    break ;
                case 3 :
                    System.out.print("Nhap id sv ban can xoa :");
                    input.nextLine() ;
                    String idDelete = input.nextLine() // thiếu dấu chấm phẩy
                    a.DeleteSv(idDelete);
                case 4 :
                    input.nextLine() ;
                    System.out.print("Nhap id sv can sua : ");
                    String id = input.nextLine() ;
                    a.EditIdStudent(); // chưa truyền vào tham số id 
                case 5 : 
                    System.out.println("good byee");
                    return ;
            }
        }
    }
}
