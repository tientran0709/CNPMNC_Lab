# CNPMNC_Lab

## 👤 Thông tin sinh viên
- **Họ và tên:** TRẦN ĐỨC TIẾN
- **MSSV:** 2014732

## 🌐 Link Sản Phẩm (Lab 5)
- **Public URL:** https://cnpmnc-lab.onrender.com/students
- **Database:** PostgreSQL (Neon.tech)


## 📝 Hướng dẫn chạy local
1. Clone repo: `git clone https://github.com/tientran0709/CNPMNC_Lab.git`
2. Chạy: `./mvnw spring-boot:run`

## Câu trả lời các câu hỏi lý thuyết

### 1. Ràng buộc Khóa Chính (Primary Key) - Lab 1
* **Câu hỏi:** Cố tình Insert một sinh viên có ID trùng với một người đã có sẵn. Quan sát thông báo lỗi: `UNIQUE constraint failed`. Tại sao Database lại chặn thao tác này?
* **Trả lời:** - **Tính duy nhất (Uniqueness):** Khóa chính được dùng để định danh duy nhất mỗi bản ghi. Nếu cho phép trùng ID, Database sẽ không thể phân biệt hoặc truy xuất chính xác một thực thể cụ thể (giống như việc hai sinh viên không thể có cùng một MSSV).
    - **Toàn vẹn thực thể:** Việc chặn trùng lặp giúp đảm bảo cấu trúc dữ liệu luôn chính xác và nhất quán, phục vụ việc tạo Index để tối ưu tốc độ tìm kiếm.



### 2. Toàn vẹn dữ liệu (Constraints) - Lab 1
* **Câu hỏi:** Thử Insert một sinh viên nhưng bỏ trống cột name (để NULL). Database có báo lỗi không? Từ đó suy nghĩ xem sự thiếu chặt chẽ này ảnh hưởng gì khi code Java đọc dữ liệu lên?
* **Trả lời:** - **Về phía Database:** Nếu cột `name` không được cấu hình ràng buộc `NOT NULL`, Database sẽ chấp nhận giá trị NULL mà không báo lỗi.
    - **Ảnh hưởng đến Java:** Khi ứng dụng Java truy vấn dữ liệu, nếu gặp giá trị NULL mà code không kiểm tra trước khi thực hiện các thao tác (ví dụ: `student.getName().toUpperCase()`), hệ thống sẽ ném ra lỗi `NullPointerException` và khiến ứng dụng bị dừng đột ngột (crash). Ngoài ra, dữ liệu thiếu tên sẽ trở thành dữ liệu "rác", không có giá trị sử dụng trên giao diện.

### 3. Cấu hình Hibernate (ddl-auto) - Lab 1
* **Câu hỏi:** Tại sao mỗi lần tắt ứng dụng và chạy lại, dữ liệu cũ trong Database lại bị mất hết?
* **Trả lời:** - **Nguyên nhân:** Do thuộc tính `spring.jpa.hibernate.ddl-auto` đang để giá trị là `create` hoặc `create-drop`. 
    - **Cơ chế:** Các chế độ này sẽ tự động thực hiện lệnh `DROP TABLE` (xóa bảng cũ) và `CREATE TABLE` (tạo bảng mới) mỗi khi ứng dụng khởi động.
    - **Giải pháp:** Cần đổi giá trị thành `update`. Khi đó Hibernate sẽ kiểm tra cấu trúc hiện tại, chỉ cập nhật những thay đổi mới mà không xóa đi dữ liệu cũ đang có trong bảng.

## Ảnh chụp màn hình các module trong Lab 4

### Trang Danh Sách (Home Page)

![Trang Danh Sách](https://i.ibb.co/d0xrZqLV/Home-Page.png)

### Trang Chi Tiết (Detail Page)

![Trang Chi Tiết](https://i.ibb.co/KxdVMjjb/Detail-Page.png)

### Chức Năng Thêm & Sửa

* **Chức năng thêm**

![Chức năng thêm](https://i.ibb.co/p607wKFR/Add.png)

* **Chức năng sửa**

![Chức năng sửa](https://i.ibb.co/B5jhPXQR/Edit.png)