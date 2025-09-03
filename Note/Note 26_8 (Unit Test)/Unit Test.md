# Unit Test

## Giải đoạn test

- UAT: Test từng item/xử lý
- IT: Test từng luồng nghiệp vụ
- UAT: Test theo điều kiện done của US theo quan điểm của người dùng
- Regression Test: Test luồng nghiệp vụ chính của hệ thống đảm bảo không ảnh hưởng trước khi release.

## Các bước viết UT UI

- Xác định đơn vị: form, bảng, modal, popup
- TÌm behavior cần kiểm tra
  - Input nòa?
  - Output mong muốn?
  - Hành vi tương tác?
- Viết test case chi tiết theo từng behavior
- Ghi rõ dữ liệu test, bước thực hiện, kết quả mong đợi

## Kiểm tra từng item trên màn hình chức năng hoặc từng API => Đảm bảo hệ thống hoạt động chính xác theo tiết kế/spec

- Người thực hiện: Dev/Tester
- Thời điểm test: Sau khi hoàn thiện chức năng/xử lý/màn hình
- Mục tiêu:
  - UI: Đầy đu , không xô lệch, chuẩn chỉnh, đúng thiết kế
  - UX: Đồng bộ với hệ thống, dễ dùng, dễ hiểu
  - Dữ liệu get ra đúng, dữ liệu lưu DB đúng
  - Đảm bảo các xử lý chạy đúng
  - Đảm bảo đã cover đủ các trường hợp lỗi

## Các nhóm testcase cơ bản

- Đi đến màn cần test
- Xác nhận layout
- Xác nhận giá trị khởi tạo
- Kiểm tra các trường hợp lỗi Validate (Lỗi FE)
- KIểm tra các trường hợp lỗi Nghiệp vụ (Lỗi BE)
- Kiểm tra Case thành công
  - Xác nhận DB thay đổi
  - Xác nhận điều hướng
- Kiểm tra hoạt động của các button trên màn hình
- Check performance
- Check Security
- Check các case khác (Check các case đồng thời, các case đặc biệt ..)

### Nhóm testcase Layout, khởi tạo

require -> max length -> format -> kiểu ký tự -> 
đăng ký thành công -> đăng ký với email tồn tại -> 