USE [duan1_banSach]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[idChucVu] [int] IDENTITY(1,1) NOT NULL,
	[MaChucVu] [varchar](50) NOT NULL,
	[TenChucVu] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__ChucVu__2765C9B5E0C61064] PRIMARY KEY CLUSTERED 
(
	[idChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhAnh]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhAnh](
	[idHinhAnh] [int] IDENTITY(1,1) NOT NULL,
	[MaHinhAnh] [varchar](50) NOT NULL,
	[Ten] [nvarchar](255) NULL,
	[DuongDanAnh] [varchar](255) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__HinhAnh__4187C930C07A13E9] PRIMARY KEY CLUSTERED 
(
	[idHinhAnh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[idHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idKhachHang] [int] NULL,
	[idNhanVien] [int] NULL,
	[idVoucher] [int] NULL,
	[idThanhToan] [int] NULL,
	[MaHoaDon] [varchar](50) NOT NULL,
	[TongTien] [decimal](10, 2) NULL,
	[GhiChu] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__HoaDon__B060C52CA1E85718] PRIMARY KEY CLUSTERED 
(
	[idHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[idHoaDonChiTiet] [int] IDENTITY(1,1) NOT NULL,
	[idHoaDon] [int] NULL,
	[idSachChiTiet] [int] NULL,
	[MaHoaDonChiTiet] [varchar](50) NOT NULL,
	[DonGia] [decimal](10, 2) NULL,
	[SoLuong] [int] NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__HoaDonCh__98B3EB77263188B3] PRIMARY KEY CLUSTERED 
(
	[idHoaDonChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[idKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[MaKhachHang] [varchar](50) NOT NULL,
	[TenKhachHang] [nvarchar](255) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SDT] [varchar](11) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__KhachHan__DAF646D094B78AA5] PRIMARY KEY CLUSTERED 
(
	[idKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[idNhaCungCap] [int] IDENTITY(1,1) NOT NULL,
	[MaNhaCungCap] [varchar](50) NOT NULL,
	[TenNhaCungCap] [nvarchar](255) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SDT] [varchar](11) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__NhaCungC__178CA807FAFE9FE3] PRIMARY KEY CLUSTERED 
(
	[idNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[idNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[MaNhanVien] [varchar](50) NOT NULL,
	[TenNhanVien] [nvarchar](255) NULL,
	[TenDangNhap] [varchar](100) NULL,
	[MatKhau] [varchar](100) NULL,
	[GioiTinh] [bit] NULL,
	[Email] [varchar](255) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SDT] [varchar](11) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
	[idChucVu] [int] NULL,
 CONSTRAINT [PK__NhanVien__214E8258D0A8D85E] PRIMARY KEY CLUSTERED 
(
	[idNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaXuatBan]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaXuatBan](
	[idNhaXuatBan] [int] IDENTITY(1,1) NOT NULL,
	[MaNhaXuatBan] [varchar](50) NOT NULL,
	[TenNhaXuatBan] [nvarchar](255) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SDT] [varchar](11) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__NhaXuatB__9B8B2567884337CB] PRIMARY KEY CLUSTERED 
(
	[idNhaXuatBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[idSach] [int] IDENTITY(1,1) NOT NULL,
	[MaSach] [varchar](50) NOT NULL,
	[TenSach] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__Sach__C4AF7AB0BF0FA5A1] PRIMARY KEY CLUSTERED 
(
	[idSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SachChiTiet]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SachChiTiet](
	[idSachChiTiet] [int] IDENTITY(1,1) NOT NULL,
	[idHinhAnh] [int] NULL,
	[idSach] [int] NULL,
	[idNhaCungCap] [int] NULL,
	[idTacGia] [int] NULL,
	[idTheLoai] [int] NULL,
	[idNhaXuatBan] [int] NULL,
	[MaSachChiTiet] [varchar](50) NOT NULL,
	[DonGia] [decimal](10, 2) NULL,
	[SoLuong] [int] NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
	[Mota] [nvarchar](250) NULL,
 CONSTRAINT [PK__SachChiT__5ECF7634603E4F5F] PRIMARY KEY CLUSTERED 
(
	[idSachChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TacGia]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TacGia](
	[idTacGia] [int] IDENTITY(1,1) NOT NULL,
	[MaTacGia] [varchar](50) NOT NULL,
	[TenTacGia] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__TacGia__0A9953D207EBE9B4] PRIMARY KEY CLUSTERED 
(
	[idTacGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhToan]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhToan](
	[idThanhToan] [int] IDENTITY(1,1) NOT NULL,
	[MaThanhToan] [varchar](50) NOT NULL,
	[TenThanhToan] [nvarchar](255) NULL,
	[HinhThucThanhToan] [nvarchar](255) NULL,
	[TongTienThanhToan] [decimal](10, 2) NULL,
	[GhiChu] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__ThanhToa__2DE12A66E0FA0414] PRIMARY KEY CLUSTERED 
(
	[idThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheLoai]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheLoai](
	[idTheLoai] [int] IDENTITY(1,1) NOT NULL,
	[MaTheLoai] [varchar](50) NOT NULL,
	[TenTheLoai] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__TheLoai__890D7EC8E8CE2ACD] PRIMARY KEY CLUSTERED 
(
	[idTheLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[idVoucher] [int] IDENTITY(1,1) NOT NULL,
	[MaVoucher] [varchar](50) NOT NULL,
	[TenVoucher] [nvarchar](255) NULL,
	[PhanTramGiam] [int] NULL,
	[ThoiGianBatDau] [date] NULL,
	[ThoiGianKetThuc] [date] NULL,
	[GiamToiDa] [decimal](10, 2) NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[TrangThai] [nvarchar](255) NULL,
	[NgaySua] [date] NULL,
 CONSTRAINT [PK__Voucher__BD9AA6BEDD2C8B90] PRIMARY KEY CLUSTERED 
(
	[idVoucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([idChucVu], [MaChucVu], [TenChucVu], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'CV001', N'Qu?n lý', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ChucVu] ([idChucVu], [MaChucVu], [TenChucVu], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'CV002', N'Nhân viên bán hàng', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ChucVu] ([idChucVu], [MaChucVu], [TenChucVu], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'CV003', N'K? toán', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ChucVu] ([idChucVu], [MaChucVu], [TenChucVu], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'CV004', N'Nhân viên kho', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ChucVu] ([idChucVu], [MaChucVu], [TenChucVu], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'CV005', N'IT Support', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
SET IDENTITY_INSERT [dbo].[HinhAnh] ON 

INSERT [dbo].[HinhAnh] ([idHinhAnh], [MaHinhAnh], [Ten], [DuongDanAnh], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'HA001', N'Image 1', N'C:\Users\Admin\OneDrive\Documents\Pictures duan1\428611043_1582808305889187_4129582005617578198_n.jpg', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', CAST(N'2024-03-16' AS Date))
INSERT [dbo].[HinhAnh] ([idHinhAnh], [MaHinhAnh], [Ten], [DuongDanAnh], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'HA002', N'Image 2', N'C:\Users\Admin\OneDrive\Documents\Pictures duan1\anhSuuTam1.jpg', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', CAST(N'2024-03-16' AS Date))
INSERT [dbo].[HinhAnh] ([idHinhAnh], [MaHinhAnh], [Ten], [DuongDanAnh], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'HA003', N'Image 3', N'C:\Users\Admin\OneDrive\Documents\Pictures duan1\anhsuutam4.jpg', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', CAST(N'2024-03-16' AS Date))
INSERT [dbo].[HinhAnh] ([idHinhAnh], [MaHinhAnh], [Ten], [DuongDanAnh], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'HA004', N'Image 4', N'C:\Users\Admin\OneDrive\Documents\Pictures duan1\anhsuutam2.jpg', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', CAST(N'2024-03-16' AS Date))
INSERT [dbo].[HinhAnh] ([idHinhAnh], [MaHinhAnh], [Ten], [DuongDanAnh], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'HA005', N'Image 5', N'C:\Users\Admin\OneDrive\Documents\Pictures duan1\428630253_759685815739870_351625499432996870_n.jpg', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', CAST(N'2024-03-16' AS Date))
INSERT [dbo].[HinhAnh] ([idHinhAnh], [MaHinhAnh], [Ten], [DuongDanAnh], [NgayTao], [TrangThai], [NgaySua]) VALUES (6, N'HA2911', N'demo4', N'C:\Users\Admin\OneDrive\Documents\Pictures duan1\anhsuutam5.jpg', CAST(N'2024-03-15' AS Date), NULL, CAST(N'2024-03-16' AS Date))
INSERT [dbo].[HinhAnh] ([idHinhAnh], [MaHinhAnh], [Ten], [DuongDanAnh], [NgayTao], [TrangThai], [NgaySua]) VALUES (7, N'HA3520', N'okkfghj', N'C:\Users\Admin\OneDrive\Documents\Pictures duan1\anhSuuTam1.jpg', CAST(N'2024-03-16' AS Date), NULL, CAST(N'2024-03-16' AS Date))
SET IDENTITY_INSERT [dbo].[HinhAnh] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, 1, 1, 1, 1, N'HD001', CAST(500.00 AS Decimal(10, 2)), N'Ghi chú 1', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, 2, 2, 2, 2, N'HD002', CAST(750.00 AS Decimal(10, 2)), N'Ghi chú 2', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, 3, 3, 3, 3, N'HD003', CAST(1000.00 AS Decimal(10, 2)), N'Ghi chú 3', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, 4, 4, 4, 4, N'HD004', CAST(300.00 AS Decimal(10, 2)), N'Ghi chú 4', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (6, 5, 5, 5, 5, N'HD005', CAST(1200.00 AS Decimal(10, 2)), N'Ghi chú 5', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (7, NULL, NULL, NULL, 27, N'HD75503', CAST(350.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (8, NULL, NULL, NULL, 28, N'HD8056', CAST(195.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (9, NULL, NULL, NULL, 29, N'HD39706', CAST(440.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (10, 7, 1, 1, 30, N'HD28636', CAST(325.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (11, 7, 1, NULL, 31, N'HD42807', CAST(100.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (12, 7, 1, 1, 32, N'HD96902', CAST(75.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (13, 7, 1, 1, 33, N'HD22085', CAST(640.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (14, 7, 1, 3, 34, N'HD83718', CAST(575.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (15, 7, 1, 2, 35, N'HD89979', CAST(120.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (16, NULL, NULL, NULL, 35, N'HD75467', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (17, NULL, NULL, NULL, 35, N'HD72493', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (18, NULL, NULL, NULL, 35, N'HD32008', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (19, NULL, NULL, NULL, 35, N'HD78715', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (20, NULL, NULL, NULL, 35, N'HD29538', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (21, NULL, NULL, NULL, 35, N'HD38150', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (22, NULL, NULL, NULL, 35, N'HD93394', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (23, NULL, NULL, NULL, 35, N'HD20232', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (24, NULL, NULL, NULL, 35, N'HD65808', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (25, NULL, NULL, NULL, 35, N'HD37747', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (26, NULL, NULL, NULL, 35, N'HD29215', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (27, 3, 1, 1, 38, N'HD37943', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (28, 2, 1, NULL, 35, N'HD88926', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (29, 7, 1, NULL, 35, N'HD24706', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (30, 1, 1, NULL, 35, N'HD62035', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Ðã h?y', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (31, 4, 1, 1, 37, N'HD57367', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (32, 7, 1, NULL, 35, N'HD2918', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (33, 7, 1, 1, 39, N'HD52931', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (34, 7, 1, NULL, NULL, N'HD28822', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (35, 7, 1, 1, 40, N'HD74255', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (36, 7, 1, 1, 41, N'HD9191', NULL, NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (37, 1, 1, 1, 42, N'HD23014', NULL, NULL, CAST(N'2024-03-25' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (38, 2, 1, NULL, NULL, N'HD86468', NULL, NULL, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (39, 5, 1, NULL, NULL, N'HD34942', NULL, NULL, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (40, 7, 1, NULL, NULL, N'HD21539', NULL, NULL, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (41, 7, 1, NULL, NULL, N'HD39689', NULL, NULL, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (42, 2, 1, NULL, NULL, N'HD84106', NULL, NULL, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idVoucher], [idThanhToan], [MaHoaDon], [TongTien], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (43, 7, 1, NULL, NULL, N'HD12085', NULL, NULL, CAST(N'2024-03-26' AS Date), N'Chờ thanh toán', NULL)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 

INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, 2, 1, N'HDCT001', CAST(50.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, 3, 2, N'HDCT002', CAST(25.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-11' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, 4, 3, N'HDCT003', CAST(100.00 AS Decimal(10, 2)), 1, CAST(N'2024-03-11' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, 5, 4, N'HDCT004', CAST(20.00 AS Decimal(10, 2)), 5, CAST(N'2024-03-11' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (6, 6, 5, N'HDCT005', CAST(60.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-11' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (7, 7, 1, N'HDCT69540', CAST(30.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (8, 7, 2, N'HDCT26880', CAST(40.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (9, 7, 3, N'HDCT33911', CAST(25.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (10, 8, 1, N'HDCT15270', CAST(30.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (11, 8, 3, N'HDCT18666', CAST(25.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (12, 9, 1, N'HDCT77903', CAST(30.00 AS Decimal(10, 2)), 8, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (13, 9, 2, N'HDCT77651', CAST(40.00 AS Decimal(10, 2)), 5, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (14, 10, 5, N'HDCT9178', CAST(50.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (15, 10, 3, N'HDCT57192', CAST(25.00 AS Decimal(10, 2)), 5, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (16, 11, 3, N'HDCT19765', CAST(25.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (17, 12, 3, N'HDCT25274', CAST(25.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (18, 13, 2, N'HDCT69364', CAST(40.00 AS Decimal(10, 2)), 10, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (19, 13, 1, N'HDCT89297', CAST(30.00 AS Decimal(10, 2)), 8, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (20, 14, 3, N'HDCT45264', CAST(25.00 AS Decimal(10, 2)), 23, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (21, 15, 1, N'HDCT90031', CAST(30.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (58, 30, 1, N'HDCT45825', CAST(30.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (59, 30, 1, N'HDCT99748', CAST(30.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (60, 30, 2, N'HDCT82560', CAST(40.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (61, 30, 1, N'HDCT89296', CAST(30.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (62, 30, 2, N'HDCT39009', CAST(40.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (63, 30, 1, N'HDCT38519', CAST(30.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (64, 29, 2, N'HDCT24438', CAST(40.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (65, 29, 2, N'HDCT16300', CAST(40.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (66, 29, 3, N'HDCT7161', CAST(25.00 AS Decimal(10, 2)), 8, CAST(N'2024-03-24' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (67, 27, 2, N'HDCT64289', CAST(40.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (68, 27, 3, N'HDCT95708', CAST(25.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (69, 31, 5, N'HDCT25825', CAST(50.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (70, 31, 1, N'HDCT14111', CAST(30.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (71, 33, 1, N'HDCT81873', CAST(30.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-24' AS Date), N'Ðã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (72, 33, 2, N'HDCT77093', CAST(40.00 AS Decimal(10, 2)), 7, CAST(N'2024-03-24' AS Date), N'Ðã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (73, 35, 2, N'HDCT77418', CAST(40.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-24' AS Date), N'Chờ thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (74, 36, 2, N'HDCT46616', CAST(40.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (75, 37, 1, N'HDCT24923', CAST(30.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (76, 37, 2, N'HDCT36517', CAST(40.00 AS Decimal(10, 2)), 1, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (77, 37, 6, N'HDCT48930', CAST(3432.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (78, 37, 3, N'HDCT91782', CAST(25.00 AS Decimal(10, 2)), 1, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (79, 37, 5, N'HDCT25742', CAST(50.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (80, 37, 2, N'HDCT68062', CAST(40.00 AS Decimal(10, 2)), 5, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (81, 37, 1, N'HDCT51161', CAST(30.00 AS Decimal(10, 2)), 7, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (82, 37, 1, N'HDCT11782', CAST(30.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (83, 37, 4, N'HDCT64302', CAST(35.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (84, 37, 1, N'HDCT34501', CAST(30.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (85, 37, 4, N'HDCT59873', CAST(35.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (86, 37, 6, N'HDCT3767', CAST(3432.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (87, 37, 2, N'HDCT53379', CAST(40.00 AS Decimal(10, 2)), 7, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (88, 37, 4, N'HDCT79467', CAST(35.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (89, 37, 1, N'HDCT94203', CAST(30.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (90, 37, 1, N'HDCT97439', CAST(30.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (91, 37, 2, N'HDCT76963', CAST(40.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (92, 37, 3, N'HDCT727', CAST(25.00 AS Decimal(10, 2)), 3, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (93, 37, 4, N'HDCT4379', CAST(35.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (94, 37, 6, N'HDCT98220', CAST(3432.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (95, 37, 3, N'HDCT95459', CAST(25.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (96, 42, 2, N'HDCT68555', CAST(40.00 AS Decimal(10, 2)), 1, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (97, 42, 4, N'HDCT97384', CAST(35.00 AS Decimal(10, 2)), 2, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
INSERT [dbo].[HoaDonChiTiet] ([idHoaDonChiTiet], [idHoaDon], [idSachChiTiet], [MaHoaDonChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua]) VALUES (98, 42, 7, N'HDCT73406', CAST(35.00 AS Decimal(10, 2)), 4, CAST(N'2024-03-25' AS Date), N'Đã hủy', NULL)
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([idKhachHang], [MaKhachHang], [TenKhachHang], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'KH001', N'Khách hàng 1', N'Ð?a ch? 1', N'1234567890', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[KhachHang] ([idKhachHang], [MaKhachHang], [TenKhachHang], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'KH002', N'Khách hàng 2', N'Ð?a ch? 2', N'0987654321', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[KhachHang] ([idKhachHang], [MaKhachHang], [TenKhachHang], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'KH003', N'Khách hàng 3', N'Ð?a ch? 3', N'1112233445', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[KhachHang] ([idKhachHang], [MaKhachHang], [TenKhachHang], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'KH004', N'Khách hàng 4', N'Ð?a ch? 4', N'5556667778', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[KhachHang] ([idKhachHang], [MaKhachHang], [TenKhachHang], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'KH005', N'Khách hàng 5', N'Ð?a ch? 5', N'9876543210', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[KhachHang] ([idKhachHang], [MaKhachHang], [TenKhachHang], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (7, N'KH000', N'Khách hàng lẻ', NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[NhaCungCap] ON 

INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [MaNhaCungCap], [TenNhaCungCap], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'NCC001', N'Nhà cung cấp 1', N'Ð?a ch? NCC 1', N'1111111111', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [MaNhaCungCap], [TenNhaCungCap], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'NCC002', N'Nhà cung cấp 2', N'Ð?a ch? NCC 2', N'2222222222', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [MaNhaCungCap], [TenNhaCungCap], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'NCC003', N'Nhà cung cấp 3', N'Ð?a ch? NCC 3', N'3333333333', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [MaNhaCungCap], [TenNhaCungCap], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'NCC004', N'Nhà cung cấp 4', N'Ð?a ch? NCC 4', N'4444444444', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [MaNhaCungCap], [TenNhaCungCap], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'NCC005', N'Nhà cung cấp 5', N'Ð?a ch? NCC 5', N'5555555555', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [MaNhaCungCap], [TenNhaCungCap], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (6, N'NCC3402', N'Nhà cung câp 6', N'Ðịa chỉ NCC 6', N'66666666', CAST(N'2024-03-15' AS Date), NULL, CAST(N'2024-03-15' AS Date))
INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [MaNhaCungCap], [TenNhaCungCap], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (7, N'NCC2449', N'heye', N'fg   kj', N'ghj', CAST(N'2024-03-16' AS Date), NULL, CAST(N'2024-03-16' AS Date))
SET IDENTITY_INSERT [dbo].[NhaCungCap] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([idNhanVien], [MaNhanVien], [TenNhanVien], [TenDangNhap], [MatKhau], [GioiTinh], [Email], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua], [idChucVu]) VALUES (1, N'NV001', N'Nhân viên 1', N'nv1', N'password1', 1, N'nv1@example.com', N'Ð?a ch? NV 1', N'1111111111', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL, 1)
INSERT [dbo].[NhanVien] ([idNhanVien], [MaNhanVien], [TenNhanVien], [TenDangNhap], [MatKhau], [GioiTinh], [Email], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua], [idChucVu]) VALUES (2, N'NV002', N'Nhân viên 2', N'nv2', N'password2', 0, N'nv2@example.com', N'Ð?a ch? NV 2', N'2222222222', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL, 2)
INSERT [dbo].[NhanVien] ([idNhanVien], [MaNhanVien], [TenNhanVien], [TenDangNhap], [MatKhau], [GioiTinh], [Email], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua], [idChucVu]) VALUES (3, N'NV003', N'Nhân viên 3', N'nv3', N'password3', 1, N'nv3@example.com', N'Ð?a ch? NV 3', N'3333333333', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL, 3)
INSERT [dbo].[NhanVien] ([idNhanVien], [MaNhanVien], [TenNhanVien], [TenDangNhap], [MatKhau], [GioiTinh], [Email], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua], [idChucVu]) VALUES (4, N'NV004', N'Nhân viên 4', N'nv4', N'password4', 0, N'nv4@example.com', N'Ð?a ch? NV 4', N'4444444444', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL, 4)
INSERT [dbo].[NhanVien] ([idNhanVien], [MaNhanVien], [TenNhanVien], [TenDangNhap], [MatKhau], [GioiTinh], [Email], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua], [idChucVu]) VALUES (5, N'NV005', N'Nhân viên 5', N'nv5', N'password5', 1, N'nv5@example.com', N'Ð?a ch? NV 5', N'5555555555', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL, 5)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[NhaXuatBan] ON 

INSERT [dbo].[NhaXuatBan] ([idNhaXuatBan], [MaNhaXuatBan], [TenNhaXuatBan], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'NXB001', N'Nhà xuất bản 1', N'Ð?a ch? NXB 1', N'1111111111', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[NhaXuatBan] ([idNhaXuatBan], [MaNhaXuatBan], [TenNhaXuatBan], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'NXB002', N'  dfghjk', N'', N'', CAST(N'2024-03-11' AS Date), NULL, CAST(N'2024-03-16' AS Date))
INSERT [dbo].[NhaXuatBan] ([idNhaXuatBan], [MaNhaXuatBan], [TenNhaXuatBan], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'NXB003', N'Nhà xuất bản 3', N'    ', N'3333333333', CAST(N'2024-03-11' AS Date), NULL, CAST(N'2024-03-16' AS Date))
INSERT [dbo].[NhaXuatBan] ([idNhaXuatBan], [MaNhaXuatBan], [TenNhaXuatBan], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'NXB004', N'Nhà xuất bản 4', N'Ð?a ch? NXB 4', N'4444444444', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[NhaXuatBan] ([idNhaXuatBan], [MaNhaXuatBan], [TenNhaXuatBan], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'NXB005', N'Nhà xuất bản 5', N'Ð?a ch? NXB 5', N'5555555555', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[NhaXuatBan] ([idNhaXuatBan], [MaNhaXuatBan], [TenNhaXuatBan], [DiaChi], [SDT], [NgayTao], [TrangThai], [NgaySua]) VALUES (6, N'NXB9957', N'Nhà xuất bản 6', N'Ðịa chỉ NXB 6', N'66666666', CAST(N'2024-03-15' AS Date), NULL, CAST(N'2024-03-15' AS Date))
SET IDENTITY_INSERT [dbo].[NhaXuatBan] OFF
GO
SET IDENTITY_INSERT [dbo].[Sach] ON 

INSERT [dbo].[Sach] ([idSach], [MaSach], [TenSach], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'S001', N'Sách 1', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[Sach] ([idSach], [MaSach], [TenSach], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'S002', N'Sách 2', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[Sach] ([idSach], [MaSach], [TenSach], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'S003', N'Sách 3', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', CAST(N'2024-03-13' AS Date))
INSERT [dbo].[Sach] ([idSach], [MaSach], [TenSach], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'S004', N'Sách 4', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[Sach] ([idSach], [MaSach], [TenSach], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'S005', N'Sách 5', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[Sach] ([idSach], [MaSach], [TenSach], [NgayTao], [TrangThai], [NgaySua]) VALUES (6, N'S5169', N'Sách 62', CAST(N'2024-03-13' AS Date), N'Đang hoạt động', CAST(N'2024-03-16' AS Date))
INSERT [dbo].[Sach] ([idSach], [MaSach], [TenSach], [NgayTao], [TrangThai], [NgaySua]) VALUES (7, N'S9722', N'heh', CAST(N'2024-03-16' AS Date), N'Đang hoạt động', CAST(N'2024-03-18' AS Date))
INSERT [dbo].[Sach] ([idSach], [MaSach], [TenSach], [NgayTao], [TrangThai], [NgaySua]) VALUES (8, N'S9158', N'Sách 34', CAST(N'2024-03-18' AS Date), N'Đang hoạt động', NULL)
SET IDENTITY_INSERT [dbo].[Sach] OFF
GO
SET IDENTITY_INSERT [dbo].[SachChiTiet] ON 

INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (1, 3, 1, 4, 1, 4, 2, N'SCT001', CAST(30.00 AS Decimal(10, 2)), 547, CAST(N'2024-03-11' AS Date), N'Hoạt động', CAST(N'2024-03-16' AS Date), N'fghdhfg')
INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (2, 2, 2, 2, 2, 2, 2, N'SCT002', CAST(40.00 AS Decimal(10, 2)), 385, CAST(N'2024-03-11' AS Date), N'Hoạt động', CAST(N'2024-03-16' AS Date), N'fghggggggg')
INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (3, 3, 2, 3, 3, 3, 3, N'SCT003', CAST(25.00 AS Decimal(10, 2)), 374, CAST(N'2024-03-11' AS Date), N'Hoạt động', CAST(N'2024-03-16' AS Date), N'cghjkl;''')
INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (4, 4, 4, 4, 4, 4, 4, N'SCT004', CAST(35.00 AS Decimal(10, 2)), 4829, CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL, NULL)
INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (5, 2, 6, 4, 3, 1, 2, N'SCT005', CAST(50.00 AS Decimal(10, 2)), 971, CAST(N'2024-03-11' AS Date), N'Đã Xóa', CAST(N'2024-03-16' AS Date), N'')
INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (6, 5, 6, 2, 4, 3, 2, N'HDCT8430', CAST(3432.00 AS Decimal(10, 2)), 171, CAST(N'2024-03-15' AS Date), N'Hoạt động', CAST(N'2024-03-16' AS Date), N'ứdfdfdfd')
INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (7, 6, 4, 3, 1, 2, 6, N'SCT2996', CAST(35.00 AS Decimal(10, 2)), 593, CAST(N'2024-03-16' AS Date), N'Đã Xóa', CAST(N'2024-03-16' AS Date), N'zxdsadas')
INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (8, 6, 4, 4, 2, 3, 6, N'SCT5082', CAST(35.00 AS Decimal(10, 2)), 2109, CAST(N'2024-03-16' AS Date), N'Hoạt động', CAST(N'2024-03-16' AS Date), N'zxdsadas')
INSERT [dbo].[SachChiTiet] ([idSachChiTiet], [idHinhAnh], [idSach], [idNhaCungCap], [idTacGia], [idTheLoai], [idNhaXuatBan], [MaSachChiTiet], [DonGia], [SoLuong], [NgayTao], [TrangThai], [NgaySua], [Mota]) VALUES (9, 2, 3, 4, 5, 2, 4, N'SCT6060', CAST(90.00 AS Decimal(10, 2)), 213148, CAST(N'2024-03-16' AS Date), N'Hoạt động', CAST(N'2024-03-16' AS Date), N'')
SET IDENTITY_INSERT [dbo].[SachChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[TacGia] ON 

INSERT [dbo].[TacGia] ([idTacGia], [MaTacGia], [TenTacGia], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'TG001', N'Tác giả 1', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[TacGia] ([idTacGia], [MaTacGia], [TenTacGia], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'TG002', N'Tác giả 2', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[TacGia] ([idTacGia], [MaTacGia], [TenTacGia], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'TG003', N'Tác giả 3', CAST(N'2024-03-11' AS Date), N'Hoạt động', CAST(N'2024-03-15' AS Date))
INSERT [dbo].[TacGia] ([idTacGia], [MaTacGia], [TenTacGia], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'TG004', N'Tác giả 4', CAST(N'2024-03-11' AS Date), N'Hoạt động', CAST(N'2024-03-15' AS Date))
INSERT [dbo].[TacGia] ([idTacGia], [MaTacGia], [TenTacGia], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'TG005', N'Tác giả 5', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[TacGia] ([idTacGia], [MaTacGia], [TenTacGia], [NgayTao], [TrangThai], [NgaySua]) VALUES (6, N'TG1945', N'Tác giả 6', CAST(N'2024-03-15' AS Date), NULL, CAST(N'2024-03-15' AS Date))
SET IDENTITY_INSERT [dbo].[TacGia] OFF
GO
SET IDENTITY_INSERT [dbo].[ThanhToan] ON 

INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'TT001', N'Thanh toán 1', N'Chuy?n kho?n', CAST(150.00 AS Decimal(10, 2)), N'Ghi chú thanh toán 1', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'TT002', N'Thanh toán 2', N'Ti?n m?t', CAST(120.00 AS Decimal(10, 2)), N'Ghi chú thanh toán 2', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'TT003', N'Thanh toán 3', N'Th? tín d?ng', CAST(200.00 AS Decimal(10, 2)), N'Ghi chú thanh toán 3', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'TT004', N'Thanh toán 4', N'Chuy?n kho?n', CAST(80.00 AS Decimal(10, 2)), N'Ghi chú thanh toán 4', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'TT005', N'Thanh toán 5', N'Ti?n m?t', CAST(100.00 AS Decimal(10, 2)), N'Ghi chú thanh toán 5', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (27, N'TT4870', NULL, N'Tiền mặt', CAST(315.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (28, N'TT5308', NULL, N'Tiền mặt', CAST(175.50 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (29, N'TT6790', NULL, N'Tiền mặt', CAST(396.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (30, N'TT9406', NULL, N'Tiền mặt', CAST(292.50 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (31, N'TT3938', NULL, N'Chuyển khoản', CAST(100.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (32, N'TT200', NULL, N'Tiền mặt', CAST(67.50 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (33, N'TT9019', NULL, N'Tiền mặt', CAST(576.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (34, N'TT179', NULL, N'Tiền mặt', CAST(460.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (35, N'TT8531', NULL, N'Tiền mặt', CAST(102.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-23' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (36, N'TT4387', NULL, N'Tiền mặt', CAST(153.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (37, N'TT7101', NULL, N'Tiền mặt', CAST(216.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (38, N'TT2833', NULL, N'Tiền mặt', CAST(153.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (39, N'TT4667', NULL, N'Tiền mặt', CAST(333.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (40, N'TT6485', NULL, N'Tiền mặt', CAST(108.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (41, N'TT5696', NULL, N'Tiền mặt', CAST(72.00 AS Decimal(10, 2)), NULL, CAST(N'2024-03-24' AS Date), N'Đã thanh toán', NULL)
INSERT [dbo].[ThanhToan] ([idThanhToan], [MaThanhToan], [TenThanhToan], [HinhThucThanhToan], [TongTienThanhToan], [GhiChu], [NgayTao], [TrangThai], [NgaySua]) VALUES (42, N'TT4861', NULL, N'Tiền mặt', CAST(6222.60 AS Decimal(10, 2)), NULL, CAST(N'2024-03-25' AS Date), N'Đã thanh toán', NULL)
SET IDENTITY_INSERT [dbo].[ThanhToan] OFF
GO
SET IDENTITY_INSERT [dbo].[TheLoai] ON 

INSERT [dbo].[TheLoai] ([idTheLoai], [MaTheLoai], [TenTheLoai], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'TL001', N'Thể loại 1', CAST(N'2024-03-11' AS Date), N'Hoạt động', CAST(N'2024-03-15' AS Date))
INSERT [dbo].[TheLoai] ([idTheLoai], [MaTheLoai], [TenTheLoai], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'TL002', N'Thể loại 2', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[TheLoai] ([idTheLoai], [MaTheLoai], [TenTheLoai], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'TL003', N'Thể loại 3', CAST(N'2024-03-11' AS Date), NULL, CAST(N'2024-03-16' AS Date))
INSERT [dbo].[TheLoai] ([idTheLoai], [MaTheLoai], [TenTheLoai], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'TL004', N'Thể loại 4', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[TheLoai] ([idTheLoai], [MaTheLoai], [TenTheLoai], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'TL005', N'Thể loại 5', CAST(N'2024-03-11' AS Date), N'Ho?t d?ng', NULL)
INSERT [dbo].[TheLoai] ([idTheLoai], [MaTheLoai], [TenTheLoai], [NgayTao], [TrangThai], [NgaySua]) VALUES (6, N'TL1055', N'khh', CAST(N'2024-03-16' AS Date), NULL, CAST(N'2024-03-16' AS Date))
INSERT [dbo].[TheLoai] ([idTheLoai], [MaTheLoai], [TenTheLoai], [NgayTao], [TrangThai], [NgaySua]) VALUES (7, N'TL6213', N'khh', CAST(N'2024-03-16' AS Date), NULL, CAST(N'2024-03-16' AS Date))
SET IDENTITY_INSERT [dbo].[TheLoai] OFF
GO
SET IDENTITY_INSERT [dbo].[Voucher] ON 

INSERT [dbo].[Voucher] ([idVoucher], [MaVoucher], [TenVoucher], [PhanTramGiam], [ThoiGianBatDau], [ThoiGianKetThuc], [GiamToiDa], [MoTa], [NgayTao], [TrangThai], [NgaySua]) VALUES (1, N'V001', N'Voucher 1', 10, CAST(N'2024-03-11' AS Date), CAST(N'2024-03-20' AS Date), CAST(30.00 AS Decimal(10, 2)), N'Mô t? voucher 1', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[Voucher] ([idVoucher], [MaVoucher], [TenVoucher], [PhanTramGiam], [ThoiGianBatDau], [ThoiGianKetThuc], [GiamToiDa], [MoTa], [NgayTao], [TrangThai], [NgaySua]) VALUES (2, N'V002', N'Voucher 2', 15, CAST(N'2024-03-11' AS Date), CAST(N'2024-03-25' AS Date), CAST(40.00 AS Decimal(10, 2)), N'Mô t? voucher 2', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[Voucher] ([idVoucher], [MaVoucher], [TenVoucher], [PhanTramGiam], [ThoiGianBatDau], [ThoiGianKetThuc], [GiamToiDa], [MoTa], [NgayTao], [TrangThai], [NgaySua]) VALUES (3, N'V003', N'Voucher 3', 20, CAST(N'2024-03-11' AS Date), CAST(N'2024-03-30' AS Date), CAST(50.00 AS Decimal(10, 2)), N'Mô t? voucher 3', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[Voucher] ([idVoucher], [MaVoucher], [TenVoucher], [PhanTramGiam], [ThoiGianBatDau], [ThoiGianKetThuc], [GiamToiDa], [MoTa], [NgayTao], [TrangThai], [NgaySua]) VALUES (4, N'V004', N'Voucher 4', 25, CAST(N'2024-03-11' AS Date), CAST(N'2024-04-01' AS Date), CAST(60.00 AS Decimal(10, 2)), N'Mô t? voucher 4', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
INSERT [dbo].[Voucher] ([idVoucher], [MaVoucher], [TenVoucher], [PhanTramGiam], [ThoiGianBatDau], [ThoiGianKetThuc], [GiamToiDa], [MoTa], [NgayTao], [TrangThai], [NgaySua]) VALUES (5, N'V005', N'Voucher 5', 30, CAST(N'2024-03-11' AS Date), CAST(N'2024-04-05' AS Date), CAST(70.00 AS Decimal(10, 2)), N'Mô t? voucher 5', CAST(N'2024-03-11' AS Date), N'Hoạt động', NULL)
SET IDENTITY_INSERT [dbo].[Voucher] OFF
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([idKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_ThanhToan] FOREIGN KEY([idThanhToan])
REFERENCES [dbo].[ThanhToan] ([idThanhToan])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_ThanhToan]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Voucher] FOREIGN KEY([idVoucher])
REFERENCES [dbo].[Voucher] ([idVoucher])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Voucher]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([idHoaDon])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SachChiTiet] FOREIGN KEY([idSachChiTiet])
REFERENCES [dbo].[SachChiTiet] ([idSachChiTiet])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SachChiTiet]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([idChucVu])
REFERENCES [dbo].[ChucVu] ([idChucVu])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
ALTER TABLE [dbo].[SachChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SachChiTiet_HinhAnh] FOREIGN KEY([idHinhAnh])
REFERENCES [dbo].[HinhAnh] ([idHinhAnh])
GO
ALTER TABLE [dbo].[SachChiTiet] CHECK CONSTRAINT [FK_SachChiTiet_HinhAnh]
GO
ALTER TABLE [dbo].[SachChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SachChiTiet_NhaCungCap] FOREIGN KEY([idNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([idNhaCungCap])
GO
ALTER TABLE [dbo].[SachChiTiet] CHECK CONSTRAINT [FK_SachChiTiet_NhaCungCap]
GO
ALTER TABLE [dbo].[SachChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SachChiTiet_NhaXuatBan] FOREIGN KEY([idNhaXuatBan])
REFERENCES [dbo].[NhaXuatBan] ([idNhaXuatBan])
GO
ALTER TABLE [dbo].[SachChiTiet] CHECK CONSTRAINT [FK_SachChiTiet_NhaXuatBan]
GO
ALTER TABLE [dbo].[SachChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SachChiTiet_Sach] FOREIGN KEY([idSach])
REFERENCES [dbo].[Sach] ([idSach])
GO
ALTER TABLE [dbo].[SachChiTiet] CHECK CONSTRAINT [FK_SachChiTiet_Sach]
GO
ALTER TABLE [dbo].[SachChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SachChiTiet_TacGia] FOREIGN KEY([idTacGia])
REFERENCES [dbo].[TacGia] ([idTacGia])
GO
ALTER TABLE [dbo].[SachChiTiet] CHECK CONSTRAINT [FK_SachChiTiet_TacGia]
GO
ALTER TABLE [dbo].[SachChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SachChiTiet_TheLoai] FOREIGN KEY([idTheLoai])
REFERENCES [dbo].[TheLoai] ([idTheLoai])
GO
ALTER TABLE [dbo].[SachChiTiet] CHECK CONSTRAINT [FK_SachChiTiet_TheLoai]
GO
/****** Object:  StoredProcedure [dbo].[demo]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[demo] @TenTheLoai nvarchar(40)
as
select * from TheLoai where TenTheLoai like UNICODE( @TenTheLoai) 
GO
/****** Object:  StoredProcedure [dbo].[getSPCTtheoMaSach]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE proc [dbo].[getSPCTtheoMaSach] @maSach varchar(255)
 as
 select Sach.MaSach,SachChiTiet.MaSachChiTiet,Sach.TenSach,TacGia.TenTacGia,TheLoai.TenTheLoai,NhaCungCap.TenNhaCungCap,HinhAnh.Ten,NhaXuatBan.TenNhaXuatBan,SachChiTiet.DonGia,SachChiTiet.SoLuong,SachChiTiet.NgayTao,SachChiTiet.TrangThai,SachChiTiet.NgaySua,SachChiTiet.MoTa from Sach join SachChiTiet on Sach.idSach=SachChiTiet.idSach join HinhAnh on SachChiTiet.idHinhAnh=HinhAnh.idHinhAnh join NhaCungCap on SachChiTiet.idNhaCungCap=NhaCungCap.idNhaCungCap join NhaXuatBan on SachChiTiet.idNhaXuatBan=NhaXuatBan.idNhaXuatBan join TacGia on SachChiTiet.idTacGia=TacGia.idTacGia join TheLoai on SachChiTiet.idTheLoai=TheLoai.idTheLoai where Sach.MaSach=@maSach
GO
/****** Object:  StoredProcedure [dbo].[getSPCTtheoMaSachCT]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  CREATE proc [dbo].[getSPCTtheoMaSachCT] @maSachCT varchar(255)
 as
 select Sach.MaSach,SachChiTiet.MaSachChiTiet,Sach.TenSach,TacGia.TenTacGia,TheLoai.TenTheLoai,NhaCungCap.TenNhaCungCap,HinhAnh.Ten,NhaXuatBan.TenNhaXuatBan,SachChiTiet.DonGia,SachChiTiet.SoLuong,SachChiTiet.NgayTao,SachChiTiet.TrangThai,SachChiTiet.NgaySua,SachChiTiet.MoTa from Sach join SachChiTiet on Sach.idSach=SachChiTiet.idSach join HinhAnh on SachChiTiet.idHinhAnh=HinhAnh.idHinhAnh join NhaCungCap on SachChiTiet.idNhaCungCap=NhaCungCap.idNhaCungCap join NhaXuatBan on SachChiTiet.idNhaXuatBan=NhaXuatBan.idNhaXuatBan join TacGia on SachChiTiet.idTacGia=TacGia.idTacGia join TheLoai on SachChiTiet.idTheLoai=TheLoai.idTheLoai where SachChiTiet.MaSachChiTiet like @maSachCT
GO
/****** Object:  StoredProcedure [dbo].[LocSanPhamCT]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[LocSanPhamCT] @TenTheLoai nvarchar(255) ,@TenNhaXB nvarchar(255),@TenTacGia nvarchar(255)
 AS


 select Sach.MaSach,SachChiTiet.MaSachChiTiet,Sach.TenSach,TacGia.TenTacGia,TheLoai.TenTheLoai,NhaCungCap.TenNhaCungCap,HinhAnh.Ten,
 NhaXuatBan.TenNhaXuatBan,SachChiTiet.DonGia,SachChiTiet.SoLuong,SachChiTiet.NgayTao,SachChiTiet.TrangThai,SachChiTiet.NgaySua,
 SachChiTiet.MoTa from Sach join SachChiTiet on Sach.idSach=SachChiTiet.idSach join HinhAnh on SachChiTiet.idHinhAnh=HinhAnh.idHinhAnh 
 join NhaCungCap on SachChiTiet.idNhaCungCap=NhaCungCap.idNhaCungCap join NhaXuatBan on SachChiTiet.idNhaXuatBan=NhaXuatBan.idNhaXuatBan
 join TacGia on SachChiTiet.idTacGia=TacGia.idTacGia join TheLoai on SachChiTiet.idTheLoai=TheLoai.idTheLoai 
 where  TheLoai.MaTheLoai LIKE '%'+@TenTheLoai+'%' 
 and NhaXuatBan.MaNhaXuatBan like '%'+@TenNhaXB+'%'
 and TacGia.MaTacGia like '%'+@TenTacGia+'%'   
GO
/****** Object:  StoredProcedure [dbo].[nv]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[nv] @tennv nvarchar(255),@Trangthai nvarchar(255)
as
select * from NhanVien where TenNhanVien=@tennv and TrangThai=@Trangthai
GO
/****** Object:  StoredProcedure [dbo].[SelectAllSachCT]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 create proc [dbo].[SelectAllSachCT]
 as
  select Sach.MaSach,SachChiTiet.MaSachChiTiet,Sach.TenSach,TacGia.TenTacGia,TheLoai.TenTheLoai,NhaCungCap.TenNhaCungCap,HinhAnh.Ten,NhaXuatBan.TenNhaXuatBan,SachChiTiet.DonGia,SachChiTiet.SoLuong,SachChiTiet.NgayTao,SachChiTiet.TrangThai,SachChiTiet.NgaySua,SachChiTiet.MoTa from Sach join SachChiTiet on Sach.idSach=SachChiTiet.idSach join HinhAnh on SachChiTiet.idHinhAnh=HinhAnh.idHinhAnh join NhaCungCap on SachChiTiet.idNhaCungCap=NhaCungCap.idNhaCungCap join NhaXuatBan on SachChiTiet.idNhaXuatBan=NhaXuatBan.idNhaXuatBan join TacGia on SachChiTiet.idTacGia=TacGia.idTacGia join TheLoai on SachChiTiet.idTheLoai=TheLoai.idTheLoai 
GO
/****** Object:  StoredProcedure [dbo].[SuaSanPhamCT]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[SuaSanPhamCT] @tenHinhAnh nvarchar(255),@TenSach nvarchar(255),@TenNhaCungCap nvarchar(255),@TenTacGia nvarchar(255),@TenTheLoai nvarchar(255),
@TenNhaXuatBan nvarchar(255),@MaSachChiTiet nvarchar(255),@DonGia decimal(10, 2),@SoLuong int,@NgayTao date,@TrangThai nvarchar(255),@NgaySua date,@MoTa nvarchar(250)
as
begin
	Declare @idHinhAnh int ,@idSach int ,@idNhaCungCap int ,@idTacGia int ,@idTheLoai int ,@idNhaXuatBan int 
	set @idHinhAnh=(select idHinhAnh from HinhAnh where Ten=@tenHinhAnh)
	set @idSach=(select idSach from Sach where TenSach=@TenSach)
	set @idNhaCungCap=(select idNhaCungCap from NhaCungCap where TenNhaCungCap=@TenNhaCungCap)
	set @idTacGia=(select idTacGia from TacGia where TenTacGia=@TenTacGia)
	set @idTheLoai=(select idTheLoai from TheLoai where TenTheLoai=@TenTheLoai)
	set @idNhaXuatBan=(select idNhaXuatBan from NhaXuatBan where TenNhaXuatBan=@TenNhaXuatBan)
	update SachChiTiet set idHinhAnh=@idHinhAnh,idSach=@idSach,idNhaCungCap=@idNhaCungCap,idTacGia=@idTacGia,idTheLoai=@idTheLoai,idNhaXuatBan=@idNhaXuatBan,DonGia=@DonGia,SoLuong=@SoLuong,TrangThai=@TrangThai,NgaySua=@NgaySua,Mota=@MoTa where MaSachChiTiet=@MaSachChiTiet 
end
GO
/****** Object:  StoredProcedure [dbo].[ThemHoaDon]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[ThemHoaDon] @maHoaDon varchar(255),@maKhachHang varchar(50),@maNhanVien varchar(50),
@maVoucher varchar(50),@TongTien decimal(10,2),@TrangThai nvarchar(255),@NgayTao date
as
begin
Declare @idKhachHang int ,@idNhanVien int ,@idVoucher int ,@idThanhToan int 
set @idKhachHang=(select idKhachHang from KhachHang where MaKhachHang like @maKhachHang)
set @idNhanVien=(select idNhanVien from NhanVien where MaNhanVien like @maNhanVien)
set @idThanhToan=(select top(1)idThanhToan from ThanhToan order by idThanhToan desc)
set @idVoucher=(select idVoucher from Voucher where MaVoucher like @maVoucher)
insert into HoaDon(MaHoaDon,idKhachHang,idNhanVien,idThanhToan,idVoucher,TongTien,TrangThai,NgayTao) values (@maHoaDon,@idKhachHang,@idNhanVien,@idThanhToan,@idVoucher,@TongTien,@TrangThai,@NgayTao)
end
GO
/****** Object:  StoredProcedure [dbo].[ThemHoaDon2]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[ThemHoaDon2] @maHoaDon varchar(255),@maKhachHang varchar(50),@maNhanVien varchar(50),
@maVoucher varchar(50),@TongTien decimal(10,2),@TrangThai nvarchar(255),@NgayTao date
as
begin
Declare @idKhachHang int ,@idNhanVien int ,@idVoucher int ,@idThanhToan int 
set @idKhachHang=(select idKhachHang from KhachHang where MaKhachHang like @maKhachHang)
set @idNhanVien=(select idNhanVien from NhanVien where MaNhanVien like @maNhanVien)
set @idThanhToan=null
set @idVoucher=(select idVoucher from Voucher where MaVoucher like @maVoucher)
insert into HoaDon(MaHoaDon,idKhachHang,idNhanVien,idThanhToan,idVoucher,TongTien,TrangThai,NgayTao) values (@maHoaDon,@idKhachHang,@idNhanVien,@idThanhToan,@idVoucher,@TongTien,@TrangThai,@NgayTao)
end
GO
/****** Object:  StoredProcedure [dbo].[themHoaDonCT]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[themHoaDonCT] @maHoaDon varchar(255),@maSachChiTiet varchar(255),@MaHoaDonChiTiet varchar(255), @DonGia decimal(10,2),@SoLuong int ,@ngayTao date ,@trangThai nvarchar(255)
as
begin 
 declare @idhoadon int ,@idsachchitiet int 
 set @idhoadon=(select idHoaDon from HoaDon where MaHoaDon=@maHoaDon)
 set @idsachchitiet=(select idSachChiTiet from SachChiTiet where MaSachChiTiet=@maSachChiTiet)
 insert into HoaDonChiTiet(idHoaDon,idSachChiTiet,MaHoaDonChiTiet,DonGia,SoLuong,NgayTao,TrangThai) values (@idhoadon,@idsachchitiet,@MaHoaDonChiTiet,@DonGia,@SoLuong,@ngayTao,@trangThai)
 end
GO
/****** Object:  StoredProcedure [dbo].[ThemSanPhamCT]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ThemSanPhamCT] @tenHinhAnh nvarchar(255),@TenSach nvarchar(255),@TenNhaCungCap nvarchar(255),@TenTacGia nvarchar(255),@TenTheLoai nvarchar(255),
@TenNhaXuatBan nvarchar(255),@MaSachChiTiet nvarchar(255),@DonGia decimal(10, 2),@SoLuong int,@NgayTao date,@TrangThai nvarchar(255),@NgaySua date,@MoTa nvarchar(250)
as
begin
	Declare @idHinhAnh int ,@idSach int ,@idNhaCungCap int ,@idTacGia int ,@idTheLoai int ,@idNhaXuatBan int 
	set @idHinhAnh=(select idHinhAnh from HinhAnh where Ten=@tenHinhAnh)
	set @idSach=(select idSach from Sach where TenSach=@TenSach)
	set @idNhaCungCap=(select idNhaCungCap from NhaCungCap where TenNhaCungCap=@TenNhaCungCap)
	set @idTacGia=(select idTacGia from TacGia where TenTacGia=@TenTacGia)
	set @idTheLoai=(select idTheLoai from TheLoai where TenTheLoai=@TenTheLoai)
	set @idNhaXuatBan=(select idNhaXuatBan from NhaXuatBan where TenNhaXuatBan=@TenNhaXuatBan)
	insert into SachChiTiet(idHinhAnh,idSach,idNhaCungCap,idTacGia,idTheLoai,idNhaXuatBan,MaSachChiTiet,DonGia,SoLuong,NgayTao,TrangThai,NgaySua,Mota) values(@idHinhAnh,@idSach,@idNhaCungCap,@idTacGia,@idTheLoai,@idNhaXuatBan,@MaSachChiTiet,@DonGia,@SoLuong,@NgayTao,@TrangThai,@NgaySua,@MoTa)
end
GO
/****** Object:  StoredProcedure [dbo].[TimKiemCTSP]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

   create proc [dbo].[TimKiemCTSP] @ThongTinTimKiem nvarchar(255)
 as
 select Sach.MaSach,SachChiTiet.MaSachChiTiet,Sach.TenSach,TacGia.TenTacGia,TheLoai.TenTheLoai,NhaCungCap.TenNhaCungCap,HinhAnh.Ten,NhaXuatBan.TenNhaXuatBan,SachChiTiet.DonGia,SachChiTiet.SoLuong,SachChiTiet.NgayTao,SachChiTiet.TrangThai,SachChiTiet.NgaySua,SachChiTiet.MoTa from Sach join SachChiTiet on Sach.idSach=SachChiTiet.idSach join HinhAnh on SachChiTiet.idHinhAnh=HinhAnh.idHinhAnh join NhaCungCap on SachChiTiet.idNhaCungCap=NhaCungCap.idNhaCungCap join NhaXuatBan on SachChiTiet.idNhaXuatBan=NhaXuatBan.idNhaXuatBan join TacGia on SachChiTiet.idTacGia=TacGia.idTacGia join TheLoai on SachChiTiet.idTheLoai=TheLoai.idTheLoai where SachChiTiet.MaSachChiTiet like @ThongTinTimKiem or Sach.TenSach like @ThongTinTimKiem or TacGia.TenTacGia=@ThongTinTimKiem
GO
/****** Object:  StoredProcedure [dbo].[TraLaiSPCTchuaThanhToan]    Script Date: 26/03/2024 12:59:15 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[TraLaiSPCTchuaThanhToan] @soLuongSPtra int ,@MaSPCT varchar(50)
as 
begin
 declare @soLuongTon int
 set @soLuongTon=@soLuongSPtra+(select SoLuong from SachChiTiet where MaSachChiTiet=@MaSPCT)
 update SachChiTiet set SoLuong=@soLuongTon where MaSachChiTiet=@MaSPCT
 end
GO
