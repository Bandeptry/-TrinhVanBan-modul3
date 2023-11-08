CREATE DATABASE chuyenDoiERSangMoHinhQuanHea;
USE chuyenDoiERSangMoHinhQuanHea;
CREATE TABLE phieuXuat (
	soPX int primary key,
	ngayPX DATE 
);

CREATE TABLE vatTu(
	maVTu int primary key auto_increment,
	tenVTu varchar(50)
);

CREATE TABLE chiTietPhieuXuat(
	DGXuat int not null,
    SLXuat int not null,
    soPX int,
    maVTu int,
    primary key(maVTu, soPX),
    FOREIGN KEY (maVTu) REFERENCES vatTu(maVTu),
    FOREIGN KEY (soPX) REFERENCES phieuXuat(soPX)
);

CREATE TABLE phieuNhap(
	soPhieuNhap int primary key auto_increment,
    ngayNhap DATE 
);

CREATE TABLE chiTietPhieuNhap(
    idpn int,
    DGNhap int not null, 
    SLNhap varchar(50), 
    maVTu int,
    soPhieuNhap int,
    PRIMARY KEY (maVTu, soPhieuNhap),
    FOREIGN KEY (maVTu) REFERENCES vatTu(maVTu),
    FOREIGN KEY (soPhieuNhap) REFERENCES phieuNhap(soPhieuNhap)
);

CREATE TABLE nhacC(
	maNhacC int primary key, 
    tenNCC varchar(50) not null,
    diaChi varchar(50)
) ;
 
CREATE TABLE donDH(
	soDH int not null primary key auto_increment, 
    ngayDonHang DATE,
    FOREIGN KEY (soDH) REFERENCES nhacC(maNhacC)
);

CREATE TABLE chiTietDatHang(
	idDH int,
	maVTu int not null,
	soDH int not null,
    primary key(maVTu, soDH),
	FOREIGN KEY (maVTu) REFERENCES vatTu(maVTu),
    FOREIGN KEY (soDH) REFERENCES donDH(soDH)
); 

CREATE TABLE nhacC_SDT(
	sdtID int primary key,
	soDienThoai varchar(50),
    maNhacC int unique,
    foreign key(maNhacC) references nhacC(maNhacC)
);

