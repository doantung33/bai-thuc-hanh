package view;

import controller.DocVaGhiFile;
import controller.TinhToan;
import model.DanhBa;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<DanhBa>danhBas=new ArrayList();
    static TinhToan tinhToan= new TinhToan(danhBas);
    static DanhBa danhBa= new DanhBa();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("------MANAGE CONTACTS-----");
                System.out.println("1. SHOW");
                System.out.println("2. ADD");
                System.out.println("3. UPDETA");
                System.out.println("4. DELETE");
                System.out.println("5. SEARCH");
                System.out.println("6. READ FILE");
                System.out.println("7. WRITE FILE");
                System.out.println("0. EXIT");
                int n = scanner.nextInt();
                switch (n) {
                    case 1:
                        show();
                        break;
                    case 2:
                        add();
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        search();
                        break;
                    case 6:
                        DocVaGhiFile.readFile();
                        break;
                    case 7:
                        DocVaGhiFile.writerFile(danhBa);
                        break;
                    case 0:
                        n=0;
                        System.exit(n);
                }
            } while (true) ;
        }

        private static void add() {
            Scanner scanner= new Scanner(System.in);
            DanhBa danhBa= new DanhBa();
            System.out.println("Nhập số điện thoại");
            int soDT= scanner.nextInt();
            danhBa.setSoDienThoai(soDT);
            Scanner scanner1= new Scanner(System.in);
            System.out.println("Nhập tên");
            String ten= scanner1.nextLine();
            danhBa.setTen(ten);
            System.out.println("Nhập tuổi");
            int tuoi= scanner.nextInt();
            danhBa.setTuoi(tuoi);
            Scanner scanner3= new Scanner(System.in);
            System.out.println("Nhập giới tính");
            String gioiTinh= scanner3.nextLine();
            danhBa.setGioiTinh(gioiTinh);
            Scanner scanner4= new Scanner(System.in);
            System.out.println("Nhập địa chỉ");
            String diaChi= scanner4.nextLine();
            danhBa.setDiaChi(diaChi);
            boolean check7 = false;
            do {
                Scanner scanner5= new Scanner(System.in);
                System.out.println("Nhập email");
                String email = (scanner5.nextLine());
                String regex = "^[a-zA-Z0-9][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                if (matcher.find()) {
                    danhBa.setEmail(email);
                    check7 = true;
                } else {
                    System.out.println("Please enter");
                }
            } while (!check7);
            danhBas.add(danhBa);
        }
        public static void search() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập tên danh bạ muốn tìm kiếm");
            String ten = scanner.nextLine();
            tinhToan.search(ten);
        }
        public static void show(){
            tinhToan.show();
        }
        public static void delete() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập số danh bạ muốn xóa");
            int soDT= scanner.nextInt();
            tinhToan.delete(soDT);
        }
        public static void edit(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập số danh bạ muốn sửa");
            int soDT1= scanner.nextInt();
            for (DanhBa danhBa:danhBas) {
                if (soDT1==(danhBa.getSoDienThoai())) {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Nhập lại số điện thoại");
                    int soDT= scanner1.nextInt();
                    danhBa.setSoDienThoai(soDT);
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Nhập lại tên danh bạ");
                    String ten1 = scanner2.nextLine();
                    danhBa.setTen(ten1);
                    System.out.println("Nhập lại tuổi");
                    int tuoi= scanner.nextInt();
                    danhBa.setTuoi(tuoi);
                    System.out.println("Nhập lại giới tính");
                    Scanner scanner3 = new Scanner(System.in);
                    String gioiTinh = scanner3.nextLine();
                    danhBa.setGioiTinh(gioiTinh);
                    System.out.println("Nhập lại địa chỉ");
                    Scanner scanner4 = new Scanner(System.in);
                    String diaChi = scanner4.nextLine();
                    danhBa.setDiaChi(diaChi);
                    boolean check7 = false;
                    do {
                        Scanner scanner5 = new Scanner(System.in);
                        System.out.println("Nhập lại email ");
                        String editEmail =(scanner5.nextLine());
                        String regex = "^[a-zA-Z0-9][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(editEmail);
                        if (matcher.find()) {
                            danhBa.setEmail(editEmail);
                            check7 = true;
                        } else {
                            System.out.println("Please enter");
                        }
                    } while (!check7);
                    }
                }tinhToan.edit(danhBa);
            }

}

