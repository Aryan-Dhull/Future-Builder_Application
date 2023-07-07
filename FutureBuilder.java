import java.text.ParseException;
import java.util.*;
class student{
    public String company_role;
    public String company_name;
    public int current_ctc;
    private final String name;
    private final String branch;
    private final int RollNo;
    private double CGPA;

    public student(String name,int rollno,double cgpa,String branch){
        this.name=name;
        this.RollNo=rollno;
        this.CGPA=cgpa;
        this.branch=branch;
    }
    boolean registered_S=false;
    boolean registered_C=false;
    boolean placed=false;
    boolean offered=false;
    boolean blocked=false;

    public double getCGPA() {
        return CGPA;
    }

    public int getRollNo() {
        return RollNo;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public void setCGPA(double g) {
        this.CGPA=g;
    }
}
class company{
    String name;
    int ctc;
    String role;
    double mincgpa;
    boolean registered_placement=false;
    public company(String name,String role,int ctc,double mincgpa){
        this.name=name;
        this.role=role;
        this.mincgpa=mincgpa;
        this.ctc=ctc;
    }
    Vector<student> applied=new Vector<>();
    Vector<student> selected=new Vector<>();

    public void setRole(String role) {
        this.role=role;
    }

    public void setCtc(int ctc) {
        this.ctc=ctc;
    }

    public void setMinCGPA(double mincgpa) {
        this.mincgpa=mincgpa;
    }
}
class Placement{
    String start_S;
    String end_S;
    String start_C;
    String end_C;
    String start_S_t;
    String end_S_t;
    int start_S_y;
    int start_C_y;
    int end_S_y;
    int end_C_y;
    String start_C_t;
    String end_C_t;
    String start_S_d;
    String end_S_d;
    String start_C_d;
    String end_C_d;
    String start_S_m;
    String end_S_m;
    String start_C_m;
    String end_C_m;
    Vector<student> Slist=new Vector<>();
    Vector<company> Clist=new Vector<>();
}
public class FutureBuilder {

    public static void Main(Scanner S, Vector<student> Slist, Vector<company> Clist,Placement p) throws ParseException {
        System.out.println("Welcome to FutureBuilder");
        System.out.println("  1) Enter the Application");
        System.out.println("  2) Exit the Application");
        System.out.print("Enter your choice::");
        int m=S.nextInt();
        if(m==1){lev2(S,Slist,Clist,p);}
        else if(m==2){System.out.println("Thanks For Using FutureBuilder!!!!!!");}
        else{
            System.out.println("Invalid Input");
            Main(S,Slist,Clist,p);
        }
    }
    public static void lev2(Scanner S,Vector<student> Slist,Vector<company> Clist,Placement p) throws ParseException {
        System.out.println();
        System.out.println("Choose The mode you want to Enter in:-");
        System.out.println("  1) Enter as Student Mode");
        System.out.println("  2) Enter as Company Mode");
        System.out.println("  3) Enter as Placement Cell Mode");
        System.out.println("  4) Return To Main Application");
        System.out.print("Enter your choice::");
        int n = S.nextInt();
        if(n==1){student_mode(S,Slist,Clist,p);}
        else if(n==2){company(S,Slist,Clist,p);}
        else if(n==3){placement(S,Slist,Clist,p);}
        else if(n==4){Main(S,Slist,Clist,p);}
        else{
            System.out.println("Invalid Input");
        }
    }
    //  STUDENT MODE AND IT'S FUNCTIONS
    public static void student_mode(Scanner S,Vector<student> Slist,Vector<company> Clist,Placement p) throws ParseException {
        System.out.println();
        System.out.println("Choose the Student Query to perform-");
        System.out.println("  1) Enter as a Student(Give Student Name, and Roll No.)");
        System.out.println("  2) Add students");
        System.out.println("  3) Back");
        int t=S.nextInt();
        if(t==1){
            System.out.println();
            System.out.print("Enter Name::");
            String fn=S.next();
            String ln=S.next();
            String na=fn+" "+ln;
            System.out.print("Enter RollNo.::");
            int r=S.nextInt();
            enter_student(S,Slist,Clist,na,r,p);
        }
        else if(t==2){
            System.out.println();
            System.out.print("Number of students to add =");
            int u=S.nextInt();
            System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
            for(int y=0;y<u;y++) {
                System.out.println("Enter details for "+ y+1+" student");
                System.out.print("Enter Name::");
                String fn = S.next();
                String ln = S.next();
                String nm=fn+" "+ln;
                System.out.print("Enter RollNo.::");
                int rm = S.nextInt();
                System.out.print("Enter CGPA::");
                double cg = S.nextDouble();
                System.out.print("Enter Branch::");
                String br = S.next();
                student s=new student(nm,rm,cg,br);
                Slist.add(s);
                System.out.println();
                System.out.println("Student added successfully");
                System.out.println();
            }
            student_mode(S,Slist,Clist,p);
        }
        else if(t==3){lev2(S,Slist,Clist,p);}
        else{
            System.out.println("Invalid Input");
            student_mode(S,Slist,Clist,p);
        }
    }
    public static void enter_student(Scanner S,Vector<student> Slist,Vector<company> Clist,String na,int r,Placement p) throws ParseException {
        System.out.println();
        boolean gh=false;
        for(student s:Slist){
            if (s.getRollNo() == r) {
                gh = true;
                break;
            }
        }
        if(gh) {
            System.out.println();
            System.out.println("Welcome " + na);
            System.out.println("  1) Register For Placement Drive");
            System.out.println("  2) Register For Company");
            System.out.println("  3) Get All available companies");
            System.out.println("  4) Get Current Status");
            System.out.println("  5) Update CGPA");
            System.out.println("  6) Accept offer");
            System.out.println("  7) Reject offer");
            System.out.println("  8) Back");
            System.out.print("Enter your choice::");
            int t = S.nextInt();
            if (t == 1) {
                System.out.print("Enter Time::");
                String date=S.next();
                String month=S.next();
                int year=S.nextInt();
                String time=S.next();
                date=date.substring(0,2);
                boolean b=time_check("s",date,month,year,time,p);
                if(b) {
                    System.out.println(na + " Registered for the Placement Drive at IIITD!!!!");
                    System.out.println("Your details are:");
                    System.out.println("Name:" + na);
                    System.out.println("RollNo:" + r);
                    for (int k = 0; k < Slist.size(); k++) {
                        if (Slist.elementAt(k).getRollNo() == r) {
                            System.out.println("CGPA:" + Slist.elementAt(k).getCGPA());
                            System.out.println("Branch:" + Slist.elementAt(k).getBranch());
                            Slist.elementAt(k).registered_S = true;
                            enter_student(S, Slist, Clist, na, r, p);
                        }
                    }
                }
                else{
                    System.out.println("Cannot Register Now");
                    enter_student(S, Slist, Clist, na, r, p);
                }
            } else if (t == 2) {
                register_for_company(S, Slist, Clist, na, r,p);
            } else if (t == 3) {
                list_of_companies(S, Slist, Clist, na, r,p);
            } else if (t == 4) {
                for (int k = 0; k < Slist.size(); k++) {
                    if (Slist.elementAt(k).getRollNo() == r) {
                        if (Slist.elementAt(k).offered) {
                            int max = 0;
                            company c = null;
                            for (company company : Clist) {
                                for (int q = 0; q < company.selected.size(); q++) {
                                    if (company.selected.get(q) == Slist.elementAt(k)) {
                                        if (max <= company.ctc) {
                                            max = company.ctc;
                                            c = company;
                                        }
                                    }
                                }
                            }
                            assert c != null;
                            System.out.println("You have been offered by " + c.name + "!! Please accept the offer.");
                            System.out.println();
                        } else if (Slist.elementAt(k).blocked) {
                            System.out.println("Blocked from placement session");
                        } else if (Slist.elementAt(k).registered_C) {
                            System.out.println("Registered at " + Slist.elementAt(k).company_name + " for " + Slist.elementAt(k).company_role + " role");
                        } else {
                            System.out.println("Not yet registered or placed at any company");
                        }
                    }
                }
                enter_student(S, Slist, Clist, na, r,p);
            } else if (t == 5) {
                System.out.print("Enter New CGPA::");
                double g = S.nextDouble();
                for (int k = 0; k < Slist.size(); k++) {
                    if (Slist.elementAt(k).getRollNo() == r) {
                        Slist.elementAt(k).setCGPA(g);
                    }
                }
                System.out.println("CGPA updated");
                enter_student(S, Slist, Clist, na, r,p);
            } else if (t == 6) {
                for (int k = 0; k < Slist.size(); k++) {
                    if (Slist.elementAt(k).getRollNo() == r) {
                        if (Slist.elementAt(k).offered) {
                            for (company company : Clist) {
                                for (int q = 0; q < company.selected.size(); q++) {
                                    if (company.selected.get(q) == Slist.elementAt(k)) {
                                        System.out.println("Congratulations " + na + "!!! You have accepted the offer by " + company.name);
                                        Slist.elementAt(k).placed = true;
                                    }
                                }
                            }
                        }
                    }
                }
                enter_student(S, Slist, Clist, na, r,p);
            } else if (t == 7) {
                for (int k = 0; k < Slist.size(); k++) {
                    if (Slist.elementAt(k).getRollNo() == r) {
                        if (Slist.elementAt(k).offered) {
                            for (company company : Clist) {
                                for (int q = 0; q < company.selected.size(); q++) {
                                    if (company.selected.get(q) == Slist.elementAt(k)) {
                                        System.out.println("You have been blocked from the placement session");
                                        Slist.elementAt(k).blocked = true;
                                    }
                                }
                            }
                        }
                    }
                }
                enter_student(S, Slist, Clist, na, r,p);
            } else if (t == 8) {
                student_mode(S, Slist, Clist,p);
            } else {
                System.out.println("Invalid Input");
                enter_student(S, Slist, Clist, na, r,p);
            }
        }
        else{
            System.out.println("Please add student first");
            System.out.println();
            enter_student(S, Slist, Clist, na, r,p);
        }
    }
    public static void register_for_company(Scanner S,Vector<student> Slist,Vector<company> Clist,String na,int r,Placement p) throws ParseException {
        System.out.println();
        boolean b=false;
        student f = null;
        for(student s:Slist){
            if(s.getRollNo()==r){
                b=s.blocked;
                f=s;
            }
        }
        if(b){
            System.out.print("You have been blocked from the placement drive");
        }
        else {
            System.out.println();
            System.out.println("Available Companies::");
            for (int o = 0; o < Clist.size(); o++) {
                if (Clist.get(o).registered_placement) {
                    System.out.println(o + 1 + ") " + Clist.get(o).name + " " + Clist.get(o).role + " " + Clist.get(o).ctc + " " + Clist.get(o).mincgpa);
                }
            }
            System.out.print("Enter your choice::");
            int g = S.nextInt();
            System.out.print("Enter company name::");
            String c = S.next();
            for(company d:Clist){
                if(Objects.equals(d.name, c)){
                    assert f != null;
                    if(d.mincgpa>f.getCGPA() || d.ctc<3*f.current_ctc){
                        System.out.println("You are not eligible for this company");
                        enter_student(S,Slist,Clist,na,r,p);
                    }
                    else if(d.selected.contains(f)){
                        System.out.println("Already registered for this company");
                        enter_student(S,Slist,Clist,na,r,p);
                    }
                }
            }

            System.out.println("Successfully Registered for " + Clist.get(g - 1).role + " Role at " + c + "!!!!");
            int q = 0;
            for (int k = 0; k < Slist.size(); k++) {
                if (Slist.get(k).getRollNo() == r) {
                    Slist.get(k).registered_C = true;
                    q = k;
                    break;
                }
            }
            for (company company : Clist) {
                if (company.registered_placement) {
                    if (Objects.equals(company.name, c)) {
                        company.applied.add(Slist.get(q));
                    }
                }
            }
        }
        enter_student(S,Slist,Clist,na,r,p);
    }
    public static void list_of_companies(Scanner S,Vector<student> Slist,Vector<company> Clist,String na,int r,Placement p) throws ParseException {
        System.out.println();
        System.out.println("List of All available companies is as follows:");
        double d=0;
        for(student s:Slist){
            if(s.getRollNo()==r){
                d=s.getCGPA();
            }
        }
        for(int o=0;o<Clist.size();o++){
            if(Clist.get(o).mincgpa<=d ) {
                System.out.println(o + 1 + ") CompanyName " + Clist.get(o).name);
                System.out.println("   CompanyRole " + Clist.get(o).role);
                System.out.println("   CompanyCTC " + Clist.get(o).ctc);
                System.out.println("   MinimumCGPA " + Clist.get(o).mincgpa);
                System.out.println();
            }
        }
        enter_student(S,Slist,Clist,na,r,p);
    }
    //  COMPANY MODE AND IT'S FUNCTIONS
    public static void company(Scanner S,Vector<student> Slist,Vector<company> Clist,Placement p) throws ParseException {
        System.out.println();
        System.out.println("Choose the Company Query to perform-");
        System.out.println("  1) Add Company and Details");
        System.out.println("  2) Choose Company");
        System.out.println("  3) Get Available Companies");
        System.out.println("  4) Back");
        System.out.print("Enter your choice::");
        int n=S.nextInt();
        if(n==1){add_company(S,Slist,Clist,p);}
        else if(n==2){mode_company(S,Slist,Clist,p);}
        else if(n==3){
            System.out.println();
            System.out.println("Available Companies::");
            for(int o=0;o<Clist.size();o++){
                System.out.println(o+1+") "+ Clist.get(o).name+" "+ Clist.get(o).role+" "+ Clist.get(o).ctc+" "+ Clist.get(o).mincgpa);
            }
            company(S,Slist,Clist,p);
        }
        else if(n==4){lev2(S,Slist,Clist,p);}
        else{
            System.out.println("Invalid Input");
            company(S,Slist,Clist,p);
        }
    }
    public static void add_company(Scanner S,Vector<student> Slist,Vector<company> Clist,Placement p) throws ParseException {
        System.out.println();
        System.out.print("Enter Company Name::");
        String cname = S.next();
        System.out.print("Enter Role::");
        String role = S.next();
        System.out.print("Enter CTC::");
        int ctc = S.nextInt();
        System.out.print("Enter Required CGPA::");
        int mincgpa = S.nextInt();
        company c=new company(cname,role,ctc,mincgpa);
        Clist.add(c);
        System.out.println("Company added successfully");
        System.out.println();
        company(S,Slist,Clist,p);
    }
    public static void mode_company(Scanner S,Vector<student> Slist,Vector<company> Clist,Placement p) throws ParseException {
        System.out.println();
        System.out.println("Choose To enter into mode of Available Companies:-");
        System.out.println("Companies");
        for(int o=0;o<Clist.size();o++){
            System.out.println(o+1+") "+ Clist.get(o).name+" "+ Clist.get(o).role+" "+ Clist.get(o).ctc+" "+ Clist.get(o).mincgpa);
        }
        System.out.print("Enter your choice::");
        int h=S.nextInt();
        System.out.println("Welcome "+ Clist.get(h - 1).name);
        company_option(S,Slist,Clist,h,p);
    }
    public static void company_option(Scanner S,Vector<student> Slist,Vector<company> Clist,int h,Placement p) throws ParseException {
        System.out.println();
        System.out.println("  1) Update Role");
        System.out.println("  2) Update Package");
        System.out.println("  3) Update CGPA criteria");
        System.out.println("  4) Register To Institute Drive");
        System.out.println("  5) Back");
        System.out.print("Enter your choice::");
        int y=S.nextInt();
        if(y==1){
            System.out.print("Enter New Role::");
            String role = S.next();
            Clist.get(h - 1).setRole(role);
            System.out.println("Welcome "+ Clist.get(h - 1).name);
            company_option(S,Slist,Clist,h,p);
        }
        else if (y==2) {
            System.out.print("Enter New CTC::");
            int ctc = S.nextInt();
            Clist.get(h - 1).setCtc(ctc);
            System.out.println("Welcome "+ Clist.get(h - 1).name);
            company_option(S,Slist,Clist,h,p);
        }
        else if (y==3){
            System.out.print("Enter New Required CGPA::");
            int mincgpa = S.nextInt();
            Clist.get(h - 1).setMinCGPA(mincgpa);
            System.out.println("Welcome "+ Clist.get(h - 1).name);
            company_option(S,Slist,Clist,h,p);
        }
        else if (y==4){
            System.out.println("Enter time::");
            String date=S.next();
            String month=S.next();
            int year=S.nextInt();
            String time=S.next();
            date=date.substring(0,2);
            boolean b=time_check("c",date,month,year,time,p);
            if(b) {
                System.out.println("Registered");
                Clist.get(h - 1).registered_placement = true;
                System.out.println("Welcome " + Clist.get(h - 1).name);
            }
            else{
                System.out.println("Cannot Register Now");
            }
            company_option(S,Slist,Clist,h,p);
        }
        else if(y==5){company(S,Slist,Clist,p);}
        else{
            System.out.println("Invalid Input");
            company_option(S,Slist,Clist,h,p);
        }
    }
    //    PLACEMENT MODE AND IT'S FUNCTIONS
    public static void placement(Scanner S,Vector<student> Slist,Vector<company> Clist,Placement p) throws ParseException {
        System.out.println();
        System.out.println("Welcome to IIITD Placement Cell");
        System.out.println("  1) Open Student Registrations");
        System.out.println("  2) Open Company Registrations");
        System.out.println("  3) Get Number of Student Registrations");
        System.out.println("  4) Get Number of Company Registrations");
        System.out.println("  5) Get Number of Offered/Unoffered/Blocked Students");
        System.out.println("  6) Get Student Details");
        System.out.println("  7) Get Company Details");
        System.out.println("  8) Get Average Package");
        System.out.println("  9) Get Company Process Results");
        System.out.println("  10) Back");
        System.out.print("Enter your choice::");
        int y=S.nextInt();
        if(y==1){
            System.out.print("Enter Start Time::");
            String start_date=S.next();
            String start_month=S.next();
            int start_year=S.nextInt();
            String start_time=S.next();
            p.start_S_d=start_date.substring(0,2);
            p.start_S_m=start_month;
            p.start_S_y=start_year;
            p.start_S_t=start_time;
            boolean b=com_before_stud(p.start_S_d,p.start_S_m,p.start_S_y,p.start_S_t,p);
            if(b) {
                p.start_S = start_date + " " + start_month + " " +start_year + " " + start_time;
                System.out.print("Enter End Time::");
                String end_date = S.next();
                String end_month = S.next();
                int end_year=S.nextInt();
                String end_time = S.next();
                p.end_S_d = end_date.substring(0, 2);
                p.end_S_m = end_month;
                p.end_S_y= end_year;
                p.end_S_t = end_time;
                p.end_S = end_date + " " + end_month + " "+ end_year+ " " + end_time;
            }
            else{
                System.out.println("Cannot Open Student Registration Before Company Registration Ends");
            }
            placement(S,Slist,Clist,p);
        }
        else if(y==2){
            System.out.print("Enter Start Time::");
            String start_date=S.next();
            String start_month=S.next();
            int start_year=S.nextInt();
            String start_time=S.next();
            p.start_C_d=start_date.substring(0,2);
            p.start_C_m=start_month;
            p.start_C_y=start_year;
            p.start_C_t=start_time;
            p.start_C=start_date + " " + start_month + " " +start_year + " " + start_time;
            System.out.print("Enter End Time::");
            String end_date=S.next();
            String end_month=S.next();
            int end_year=S.nextInt();
            String end_time=S.next();
            p.end_C_d=end_date.substring(0,2);
            p.end_C_m=end_month;
            p.end_C_y= end_year;
            p.end_C_t=end_time;
            p.end_C=end_date + " " + end_month + " "+ end_year+ " " + end_time;
            placement(S,Slist,Clist,p);
        }
        else if(y==3){
            int d=0;
            for(student s:Slist){
                if (s.registered_S){
                    d++;
                }
            }
            System.out.println("Number of students registered= "+d);
            placement(S,Slist,Clist,p);
        }
        else if(y==4){
            int d=0;
            for(company s:Clist){
                if (s.registered_placement){
                    d++;
                }
            }
            System.out.println("Number of companies registered= "+d);
            placement(S,Slist,Clist,p);
        }
        else if(y==5){
            int o=0;
            int t=0;
            int b=0;
            for (student student : Slist) {
                if (student.registered_S) {
                    t++;
                    if (student.blocked) {
                        b++;
                    }
                    if (student.offered) {
                        o++;
                    }
                }
            }
            int u=t-o-b;
            System.out.println("Number of students offered="+o);
            System.out.println("Number of students unoffered="+u);
            System.out.println("Number of students blocked="+b);
            placement(S,Slist,Clist,p);
        }
        else if(y==6){
            for(int o=0;o<Slist.size();o++){
                System.out.println(o+1+")"+ Slist.get(o).getName()+" "+ Slist.get(o).getRollNo()+" "+ Slist.get(o).getCGPA()+" "+ Slist.get(o).getBranch());
                for(company c:Clist) {
                    if (c.applied.contains(Slist.get(o))) {
                        System.out.println("\tApplied at " + c.name + " for " + c.role + " role");
                    }
                }
                for(company c:Clist){
                    if(c.selected.contains(Slist.get(o))){
                        System.out.println("\tSelected for "+ c.role + " role at "+ c.name);
                    }
                }
                System.out.println();
            }
            System.out.println();
            placement(S,Slist,Clist,p);
        }
        else if(y==7){
            for(int o=0;o<Clist.size();o++){
                System.out.println(o+1+")"+ Clist.get(o).name+" "+ Clist.get(o).role+" "+ Clist.get(o).ctc+" "+ Clist.get(o).mincgpa);
                for(student s:Clist.get(o).selected){
                    System.out.println("\t"+s.getName()+ " "+ s.getRollNo()+ " " + s.getCGPA()+ " "+s.getBranch());
                }
            }
            System.out.println();
            placement(S,Slist,Clist,p);
        }
        else if(y==8){
            int f=0;
            int se=0;
            for (company company : Clist) {
                if (company.registered_placement) {
                    for (int u = 0; u < company.selected.size(); u++) {
                        se += 1;
                        if(company.selected.get(u).placed) {
                            f += company.ctc;
                        }
                    }
                }
            }
            if(se==0){
                System.out.println("No offer made yet");
            }
            else if(f==0){
                System.out.println("Average Package ="+f+" No offer has been accepted yet");
            }
            else {
                System.out.println("Average package= " + f / se);
            }
            System.out.println();
            placement(S,Slist,Clist,p);
        }
        else if(y==9){
            System.out.print("Enter Company Name::");
            String c=S.next();
            for (company company : Clist) {
                if (Objects.equals(company.name, c)) {
                    Collections.shuffle(company.applied);
                    Random rand = new Random();
                    int k=rand.nextInt(company.applied.size());
                    if(k==0){k+=1;}
                    for (int t = 0; t < k; t++) {
                        if (company.applied.get(t).getCGPA() >= company.mincgpa) {
                                company.selected.add(company.applied.get(t));
                                company.applied.get(t).offered = true;
                        }
                    }
                }
            }
            System.out.println("Following are the students selected-");
            for (company company : Clist) {
                for(int h = 0; h<company.selected.size(); h++) {
                    System.out.println(h + 1 + ") Name: " + company.selected.get(h).getName());
                    System.out.println("   Roll no: " + company.selected.get(h).getRollNo());
                    System.out.println("   CGPA: " + company.selected.get(h).getCGPA());
                    System.out.println("   Branch: " + company.selected.get(h).getBranch());
                    System.out.println();
                    company.selected.get(h).current_ctc=company.ctc;
                    company.selected.get(h).company_name=company.name;
                    company.selected.get(h).company_role=company.role;
                }
            }
            System.out.println();
            placement(S,Slist,Clist,p);
        }
        else if(y==10){lev2(S,Slist,Clist,p);}
        else{
            System.out.println("Invalid Input");
            placement(S,Slist,Clist,p);
        }
    }
    public static boolean com_before_stud(String date,String month,int year,String time,Placement p){
        String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
        int c=0,e=0;
        for(int h=0;h<12;h++) {
            if (months[h].equals(month)) {
                c = h;
            }
        }
        for(int h=0;h<12;h++) {
            if(months[h].equals(p.end_S_m)){
                e=h;
            }
        }
        if(year<p.end_C_y)return false;
        if(c<e)return false;
        int h1=Integer.parseInt(time.substring(0,2));
        int he = Integer.parseInt(p.end_C_t.substring(0, 2));
        int m1=Integer.parseInt(time.substring(3,5));
        int me = Integer.parseInt(p.end_C_t.substring(3, 5));
        int d1=Integer.parseInt(date);
        int de = Integer.parseInt(p.end_C_d);
        if(d1<de)return false;
        if(h1<he)return false;
        return m1 >= me;
    }
    public static boolean time_check(String type,String date,String month,int year,String time,Placement p) {
        String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
        int h1=Integer.parseInt(time.substring(0,2));
        int hs;
        int m1=Integer.parseInt(time.substring(3,5));
        int ms;
        int me;
        int d1=Integer.parseInt(date);
        int ds;
        int de;
        if(Objects.equals(type, "s")) {
            hs = Integer.parseInt(p.start_S_t.substring(0, 2));
            ms = Integer.parseInt(p.start_S_t.substring(3, 5));
            me = Integer.parseInt(p.end_S_t.substring(3, 5));
            ds = Integer.parseInt(p.start_S_d);
            de = Integer.parseInt(p.end_S_d);
            int c=0,e=0,s=0;
            for(int h=0;h<12;h++) {
                if (months[h].equals(month)) {
                    c = h;
                }
            }
            for(int h=0;h<12;h++) {
                if(months[h].equals(p.end_S_m)){
                    e=h;
                }
            }
            for(int h=0;h<12;h++) {
                if(months[h].equals(p.start_S_m)){
                    s=h;
                }
            }
            if(year>p.end_S_y || year<p.start_S_y)return false;
            if(c<s || c>e)return false;
        }
        else{
            hs = Integer.parseInt(p.start_C_t.substring(0, 2));
            ms = Integer.parseInt(p.start_C_t.substring(3, 5));
            me = Integer.parseInt(p.end_C_t.substring(3, 5));
            ds = Integer.parseInt(p.start_C_d);
            de = Integer.parseInt(p.end_C_d);
            int c=0,e=0,s=0;
            for(int h=0;h<12;h++) {
                if (months[h].equals(month)) {
                    c = h;
                }
            }
            for(int h=0;h<12;h++) {
                if(months[h].equals(p.end_C_m)){
                    e=h;
                }
            }
            for(int h=0;h<12;h++) {
                if(months[h].equals(p.start_C_m)){
                    s=h;
                }
            }
            if(year>p.end_C_y || year<p.start_C_y)return false;
            if(c<s || c>e)return false;
        }
        if(d1<ds || d1>de)return false;
        if(h1<hs)return false;
        return m1 >= ms && m1 <= me;
    }
    public static void main(String[] args) throws ParseException {
        Scanner S=new Scanner(System.in);
        Placement p=new Placement();
        Vector<student> Slist = p.Slist;
        Vector<company> Clist = p.Clist;
        Main(S,Slist,Clist,p);
    }
}