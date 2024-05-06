package main;

import java.util.Random;
import java.util.Scanner;

public class KhoiDau {
    public static int luaChon(double taiKhoanNguoiChoi, Scanner sc){
        System.out.println("------------------------------MỜI BẠN LỰA CHỌN------------------------------");
        System.out.println("Chọn (1) để tiếp tục chơi.");
        System.out.println("chọn phím bất kỳ để thoát");
        int luaChon = sc.nextInt();
        if(luaChon == 1){
            System.out.println("*** Bắt đầu chơi.");
            //Đặt cược
            System.out.println("***** Tài khoản của bạn: " + taiKhoanNguoiChoi + ", bạn muốn cược bao nhiêu?");
            double datCuoc = 0;
            do{
                System.out.println("****** Đặt cược (0 < số tiền cược <= " + taiKhoanNguoiChoi +"):");
                datCuoc = sc.nextDouble();
            } while(datCuoc <= 0 || datCuoc > taiKhoanNguoiChoi);

            //Lựa chọn tài xỉu
            int luaChonTaiXiu = 0;
            do{
                System.out.println("******** Chọn: (1) <-> Tài || (2) <-> Xỉu");
                luaChonTaiXiu = sc.nextInt();
            } while(luaChonTaiXiu != 1 && luaChonTaiXiu != 2);
            
            //Tung xúc sắc
            Random xucxac1 = new Random();
            Random xucxac2 = new Random();
            Random xucxac3 = new Random();


        }
        return luaChon;
    }
}
