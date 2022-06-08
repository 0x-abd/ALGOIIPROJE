package workspace;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
    05200000054 || AHMET BURAK DİNÇ 

    * BELİRTİLMEDİĞİ İÇİN HATA KONTROLÜ YAPILMAMIŞTIR.
    
 */

public class DoublyLinkedList {  
    
    private static final int QUIT = 0; // Menu secenekleri
    private static final int ADD = 1;
    private static final int LISTALL = 2;
    private static final int SEARCH = 3;
    private static final int DELETE = 4;
    private static final int SORTASC =5;
    private static final int SORTDESC= 6;
    
    class Node{      // DoublyLinkedList'te kullanılan node inner class tanımı
        Student data;
        Node previous;  
        Node next;  
        public Node(Student data) {  
            this.data = data;  
        }  
    }  
  
    //doubly linked list head ve tail 
    Node head, tail = null;  
  
    //doubly linked liste node ekleyen metod.  
    public void addNode(Student s1) { 
        //Create a new node  
        Node newNode = new Node(s1);  
        
        //Liste boşsa
        if(head == null) {  
            head = tail = newNode;      
            head.previous = null;  
            tail.next = null;  
        }  
        else {  
            tail.next = newNode;  
            newNode.previous = tail;    
            tail = newNode;         
            tail.next = null;  
        }
        sortAsc(); // Eklenen node'un artan sıraya göre sıralanmasını sağlamak için fonksiyon çağırılıyor.
        
    }  
  
        // Doubly linked listi artan sıraya göre sıralayan fonksyion
        public void sortAsc() {  
        Node current = null, index = null;  
        Student temp;  
        if(head == null) {  
            return;  
        }  
        else {  
            for(current = head; current.next != null; current = current.next) {  
                for(index = current.next; index != null; index = index.next) {   
                    if(current.data.getOgrenciNumarasi() > index.data.getOgrenciNumarasi()) {  
                        temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                }  
            }  
        }  
    }  
        //Listeyi azalan sıraya göre sıralayan fonksiyon.
        public void sortDesc() {  
        Node current = null, index = null;  
        Student temp;  
        if(head == null) {  
            return;  
        }  
        else {  
            for(current = head; current.next != null; current = current.next) {  
                for(index = current.next; index != null; index = index.next) {  
                    if(current.data.getOgrenciNumarasi() < index.data.getOgrenciNumarasi()) {  
                        temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                }  
            }  
        }  
    }
    //Doubly linked list icerisindeki tüm nodeları gösteren fonksiyon.
    public void display() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            System.out.print(current.data + " ");  
            current = current.next;  
            System.out.println();  
        }  
        System.out.println();  
    }  
    
    public void searchName() {  // KLAVYEDEN GİRİLEN İSME GÖRE EŞLEŞEN İSİMLERİ GÖSTEREN METOD.
        boolean flag = false;  
        Node current = head;  
        Student s1 = null;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter search name: ");
        String keyword = scan.nextLine();
        System.out.println("Matches:");  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            //Compare value to be searched with each node in the list  
            if(current.data.getAdSoyad().toLowerCase().contains(keyword.toLowerCase())) { 
                s1 = current.data;
                flag = true;
                
            } 
            current = current.next; 
        }  
        if(flag)  
             System.out.println(s1.toString());  
        else  
             System.out.println("Name is not present in the list");  
    }  
    
    public void deleteName() {   // KLAVYEDEN GİRİLEN NUMARAYA GÖRE LİSTEDEN SİLENECEK NODE'UN BELİRLENMESİNİ SAĞLAYAN METOD.
        boolean flag = false;  
        Node current = head;  
        Student s1 = null;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter search number to DELETE: ");
        int number = scan.nextInt();
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            if(current.data.getOgrenciNumarasi() == number) { 
                deleteNode(current);
                flag = true;
            } 
            current = current.next;    
        } 
        System.out.println();
    }
    // Doubly linked listten node silen fonksiyon
    public void deleteNode(Node del) // BELİRLENEN NODE'UN LİSTEDEN SİLİNMESİNİ SAĞLAYAN METOD.
    {
        if (head == null || del == null) {
            return;
        }
        if (head == del) {
            head = del.next;
        }
        if (del.next != null) {
            del.next.previous = del.previous;
        }
        if (del.previous != null) {
            del.previous.next = del.next;
        }
        return;
    }
  
    public static void main(String[] args) {  
  
        DoublyLinkedList dList = new DoublyLinkedList(); // OGRENCİLERİN TUTULACAGİ DOUBLYLINKED LIST OLUSTURULUYOR

        
        
        ArrayList<Student> ogrenciler = new ArrayList<Student>(); // DOSYADAN OKUNAN OGRENCİLER BU ARRAY'E AKTARILIYOR
        // DOSYA OKUMA VE DOUBLYLUNKED EKLEME 
        try{
            File myObj = new File("ogrenciler.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                Student newStudent = new Student(Integer.parseInt(data.split(",")[0]), data.split(",")[1], data.split(",")[2]);
                ogrenciler.add(newStudent);
      
            }
            myReader.close();       
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            
        }
        for (int i = 0; i < ogrenciler.size(); i++) { // DOSYADAN CEKİLEN OGRENCİLERİ DOUBLYLINKED LIST'E EKLIYOR
            dList.addNode(ogrenciler.get(i));
            
        }
        
        // KULLANICI ARAYUZU
        Scanner scan = new Scanner(System.in);
        int choice = ADD;
        // Main menu
        while (choice != QUIT) {
        System.out.println();
        System.out.println("Choose from the following:");
        System.out.println("0) Quit");
        System.out.println("1) Add new contact");
        System.out.println("2) List all contacts");
        System.out.println("3) Search contacts by NAME and display");
        System.out.println("4) Search contacts by NUMBER and remove");
        System.out.println("5) Sort list by ascent ");
        System.out.println("6) Sort list by descend");
        choice = scan.nextInt();
        switch (choice) {
        case ADD:
            System.out.println("Numara: ");
            int numara = scan.nextInt();
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Ad Soyad: ");
            String adSoyad = scan2.nextLine();
            Scanner scan3 = new Scanner(System.in);
            System.out.println("Telefon Numarası: ");
            String telefon = scan3.nextLine();
            
            Student s1 = new Student(numara, adSoyad, telefon);
            dList.addNode(s1);
            
        break;
        case LISTALL:
            dList.display();
        break;
        case SEARCH:
            dList.searchName();
        break;
        case DELETE:
            dList.deleteName();
        break;
        case SORTASC:
            dList.sortAsc();
            dList.display();
            break;
        case SORTDESC:
            dList.sortDesc();
            dList.display();
            break;
   
 }
 }

    }  
}  