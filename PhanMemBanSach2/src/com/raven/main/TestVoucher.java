package com.raven.main;

import com.raven.model.Voucher;
import com.raven.service.VoucherService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TestVoucher {

    private VoucherService vcs = new VoucherService();
    private List<Voucher> listVoucher = new ArrayList<>();

        public static void main(String[] args) {
            
            VoucherService vcs = new VoucherService();
            Voucher filteredVoucher = vcs.Loc(30, "Đã xóa",new Date(2024, 3, 11), new Date(2024, 4, 5));

            if (filteredVoucher != null) {
                System.out.println("Mã voucher: " + filteredVoucher.getMaVoucher());
                System.out.println("Tên voucher: " + filteredVoucher.getTenVoucher());
            } else {
                System.out.println("Không tìm thấy voucher phù hợp");
            }
        }
    }


