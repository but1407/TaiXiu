package main;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*
* Luật chơi:
* Có 3 viên xúc sắc
* mỗi lần lắc sẽ ra 1 kết quả. Kq = xx1 + xx2 + xx3
* 1. Tổng = 3 || 18 => Cái ăn hết, người chơi thua
* 2. Tổng = (4->10) => xỉu => người chơi đặt xỉu thì người chơi thắng, ngược lại thua
* 3. Tổng = (11->17) => xỉu => người chơi đặt tài thì người chơi thắng, ngược lại thua
* */
public class TaiXiu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền bạn đang có:");
        try {
            double taiKhoanNguoiChoi = sc.nextDouble();
            int luaChon = 0;
            do {
                //Khởi đầu
                KhoiDau khoidau = new KhoiDau();
                //format VND
                Locale lc = new Locale("vi", "VN");
                //NumberFormat numf = NumberFormat.getInstance(lc);
                NumberFormat numf = NumberFormat.getCurrencyInstance(lc);

                System.out.println("------------------------------MỜI BẠN LỰA CHỌN------------------------------");
                System.out.println("Chọn (1) để tiếp tục chơi.");
                System.out.println("chọn phím bất kỳ để thoát");
                luaChon = sc.nextInt();
                if (luaChon == 1) {
                    System.out.println("*** Bắt đầu chơi.");

                    //Đặt cược
                    System.out.println("***** Tài khoản của bạn: " + numf.format(taiKhoanNguoiChoi) + ", bạn muốn cược bao nhiêu?");
                    double datCuoc = 0;
                    do {
                        System.out.println("****** Đặt cược (0 < số tiền cược <= " + numf.format(taiKhoanNguoiChoi) + "):");
                        datCuoc = sc.nextDouble();
                    } while (datCuoc <= 0 || datCuoc > taiKhoanNguoiChoi);

                    //Lựa chọn tài xỉu
                    int luaChonTaiXiu = 0;
                    luaChonTaiXiu = khoidau.LuaChonTaiXiu(luaChonTaiXiu, sc);
                    if(luaChonTaiXiu == 1){
                        System.out.println("***Bạn chọn Tài");
                    } else{
                        System.out.println("***Bạn chọn Xỉu");
                    }

                    //Tung xúc sắc
                    Random xucXac1 = new Random();
                    Random xucXac2 = new Random();
                    Random xucXac3 = new Random();

                    int giaTri1 = xucXac1.nextInt(5) + 1;
                    int giaTri2 = xucXac2.nextInt(5) + 1;
                    int giaTri3 = xucXac3.nextInt(5) + 1;
                    int tong = giaTri1 + giaTri2 + giaTri3;

                    //Tính toán kết quả
                    System.out.println("******** Kết quả: " + giaTri1 + " + " + giaTri2 + " + " + giaTri3);
                    if (tong == 3 || tong == 18) {
                        taiKhoanNguoiChoi -= datCuoc;
                        System.out.println("******** Tổng là: " + tong + " => nhà cái ăn hết, bạn đã thua cược!");
                        System.out.println("******** Tài khoản của bạn là: " + numf.format(taiKhoanNguoiChoi));
                    } else if (tong >= 4 && tong <= 10) {
                        taiKhoanNguoiChoi = khoidau.VeXiu(luaChonTaiXiu, tong, taiKhoanNguoiChoi, datCuoc, numf);
                    } else {
                        taiKhoanNguoiChoi = khoidau.VeTai(luaChonTaiXiu, tong, taiKhoanNguoiChoi, datCuoc, numf);
                    }
                }
            } while (luaChon == 1);
        } catch (InputMismatchException e){
            System.out.println("bạn nhập sai kiểu dữ liệu!");
        }
    }
}
