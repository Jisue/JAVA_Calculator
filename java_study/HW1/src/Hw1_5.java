import java.util.Scanner;

class ReservationSystem{
    String[] sname;
    String[] aname;
    String[] bname;
    int seat;
    
    ReservationSystem(){
        sname = new String[10];
        aname = new String[10];
        bname = new String[10];
        for(int i=0;i<10;i++){
            sname[i] = "---";
            aname[i] = "---";
            bname[i] = "---";
        }
    }
    
    void seatchoice(){
        System.out.print("�¼� ���� S(1), A(2), B(3)>>");
        Scanner input = new Scanner(System.in);
        seat = input.nextInt();
    }
    
    void printSname(){
        System.out.print("S>>");
        for(int i=0;i<sname.length;i++){
            System.out.print(" "+sname[i]);
        }
        System.out.println();
    }
    void printAname(){
        System.out.print("A>>");
        for(int i=0;i<aname.length;i++){
            System.out.print(" "+aname[i]);
        }
        System.out.println();
    }
    void printBname(){
        System.out.print("B>>");
        for(int i=0;i<bname.length;i++){
            System.out.print(" "+bname[i]);
        }
        System.out.println();
    }
    
    void printAllseat(){
        switch(seat){
        case 1:
            printSname();
            break;
        case 2:
            printAname();
            break;
        case 3:
            printBname();
            break;
        default:
            System.out.println("���� �޴�");
            break;
        }
    }
    
    //����
    void setSeat(String name, int num){
       // �ߺ� �˻�
       switch(seat){
        case 1:
            if(sname[num-1] == "---") {
                sname[num-1] = name;
            }
            else {
                System.out.println("�̹� ����� �ڸ�");
            }
            break;
        case 2:
            if(aname[num-1] == "---") {
                aname[num-1] = name;
            }
            else {
                System.out.println("�̹� ����� �ڸ�");
            }
            break;
        case 3:
            if(bname[num-1] == "---") {
                bname[num-1] = name;
            }
            else {
                System.out.println("�̹� ����� �ڸ�");
            }
            break;
        default:
            System.out.println("���� �޴�");
            break;
        }
    }
    
    void reservation(){
        seatchoice();
        String name;
        int num;
        printAllseat();
         
        Scanner input = new Scanner(System.in);
        System.out.print("�̸�>>");
        name = input.next();
        System.out.print("��ȣ>>");
        num = input.nextInt();
        
        if(num>0 && num<11) {
            setSeat(name, num);
        }
        else {
            System.out.println("���� ��ȣ");
        }
    }
    
    //��ȸ
    void inquiry(){
        printSname();
        printAname();
        printBname();
        System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
    }
    
    //���
    void cancel(){
        seatchoice();
        printAllseat();
        
        String name;
        int i=0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("�̸�>>");
        name = input.next();
        
        switch(seat){
        case 1:
            for(i=0;i<sname.length;i++){
                if(sname[i].equals(name)){
                    sname[i]="---";
                    break;
                }
            }
            break;
        case 2:
            for(i=0;i<aname.length;i++){
                if(aname[i].equals(name)){
                    aname[i]="---";
                    break;
                }
            }
            break;
        case 3:
            for(i=0;i<bname.length;i++){
                if(bname[i].equals(name)){
                    bname[i]="---";
                    break;
                }
            }
            break;
        default:
            System.out.println("���� �޴�");
            break;
        }
        if(i==10){
            System.out.println("���� �̸�");
        }
    }
}

public class Hw1_5 {
 
    public static void main(String[] args) {
    	ReservationSystem r = new ReservationSystem();
        
        while(true){
            System.out.print("����:1, ��ȸ:2, ���:3, ������:4>>");
            Scanner input = new Scanner(System.in);
             
            int i = input.nextInt();
            switch(i){
                case 1:
                    r.reservation();
                    break;
                case 2:
                    r.inquiry();
                    break;
                case 3:
                    r.cancel();
                case 4:
                    break;
                default:
                    System.out.println("���� �޴�");
                    break;
            }
            if(i==4) {
                break;
            }
        }
    }
 
}