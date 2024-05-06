package main;

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
        double taikhoanNguoiChoi = 5000;
        Scanner sc = new Scanner(System.in);
        int luaChon = 1;
        do {
            //Khởi đầu
            KhoiDau khoidau = new KhoiDau();
            luaChon = khoidau.luaChon(taikhoanNguoiChoi, sc);
            
        } while(luaChon!=1);
    }
}
