# Những nội dung công việc (Sprint 0) 
## Chốt quy trình công cụ để quản lý dự á
- Xây dựng quy trình Srum của team và triển kahi cho tất cả các nhóm dự án
- Các US được ghi nhận và quản lý trong công cụ (Techkan)
- Ghi rõ ràng các bước của quy trình: Sprint planning, Daily meeting, Sprint Review và Retro (Chốt thời gian địa điểm, chốt thời gian thông báo và gửi cho ai, trong ghi âm)
- Đảm bảo công cụ quản lý có thể đo lường tiến độ và hiện thị trạng thái của từng US
- Các thành viện trong nhóm có thẻ theo dõi tiếng dộ của dự án và dễ dàng nhận tháy những vấn đề còn tồn đọng
- Chốt kênh trao đổi để cập nhật tiến độ và giải quyết vấn đề kịp thời
- Chốt quy trình code, gửi review, merge và deploy
- Rule log task
- Chốt các nội dung cần thực hiện trước khi ra về
## Đã xây dựng môi trường phát triển chưa?
- Môi trường local, staging, production đã được thiết lập đầy đủ và kiểm tra hoạt động bình thường
- Công cụ CI/CD (Jenkins, Github Actions) đã được cài đặt và cấu hình đúng, với các bước tự động build, test, deploy hoạt động ổn đỉnh
- Quy trình CI/CD đã được tích hợp với kho mã nguồn (GitHub, GitLab) để tự động hóa các bước kiểm tra và triển khai 
- Quyền truy cạp và phân quyền cho các thành viên đã được thiết lập và kiểm tra
- Tất cả các môi trường đều có tài liệu hướng dẫn để người dùng có thể dễ dàng cấu hình khi cần thiết
## Đã xác định phạm vi và mục tiêu ban đầu của dự án chưa?
- Mục tiêu và yêu cầu dự án được xác định rõ
- Sản phẩm đàu tiền (MVP) được chọn
- Hoàn thiện Product Backlog ban đầu 
- Xây dựng Roadmap và Release Plan sơ bộ
## Đã thiết lập đội nhóm và phân công vai trò chưa?
- Các thành viên trong Scrum Team đã được phân công vai trò rõ ràng
- Các quy trình giao tiếp được lên lịch với thời gian cũ thể
- Các côgn cụ giao tiếp đã được cấu hình với các nhóm phù hợp và các thành viên đã tham gia vào kênh giao tiếp
- Mỗi thành viên tron gnhos đã được xác nhận hiểu rõ trách nhiện của mình trong Scrum Team
- Các thành viện trong nhóm dã được huấn luyện về các vai trò
## Đã chuẩn bị tài liệu định nghĩa chưa?
- Định nghĩa hoàn thành (DOD) cho mỗi US và Sprint
- Các chỉ số do đo lường (velocity, burn-down chart, cycle time, v.v) được xác định và áp dụng 
- Tài liệu kỹ thuật cơ bản hoặc high-level architecture được xây dựng và chia sẻ nhóm với nhau 
- Xác định được point tiêu chuẩn cho dự án
## Đã Nghiên cứ và phân tích kỹ thuật chưa?
- Công nghệ, framework và công cụ cần thiết cho dự án đã được nghiên cứu, phân tích và chọn lựa
- TÍnh khả thi của các yêu cầu kỹ thuật đã được xác minh qua các cuộc họp hoặc spike
- PoC hoặc nguyên mẫu cho các tính năng phức tập đã được xây dựng và hoàn thành
- Tất cả các lựa chọn công nghệ đều được đánh giá dựa trên tiêu chí
## Đã xây dựng backlog Sprint 1 chưa
- Backlog Sprint 1 được xây dựng và các US được ưu tiên
- Các US được chia nhỏ thành các task củ thể
- Tất cả các US trong Sprint 1 đạt tiêu chí DoR
## Đã quản lý rủi ro và kỳ vọng của stakeholders chưa?
- Xác định stakeholders và khách hàng, đưa ra quy trình liên lạc (Khi nào, làm gì)
- Các rủi ro tiềm năng đã được xac định và có kế hoạch giảm thiểu 
- Các kỳ vọng của các stakeholders về timeline, phạm vi và chất lượng đã được thống nhất
- Kế hoạch quản lý rủi ro đã được phê duyệt và chia sẻ với các bên liên quan
- Buổi họp kickoff đã được tổ chức và tất cả các bên liên quan đã được thông báo về kế hoạc và các rủi ro
## Đã chốt template, rule và nơi lưu trữ tài liệu DB và API, testcase chưa?
- Yêu cầu có template và các lưu trữ quản lý tài liệu DB & API
- DB cần thiết kế theo từng giai đoạn và đi theo chức năng. Không được tiết kế DB tổng quan cho cả hệ thống trước
- Tài liệu cần để ở vị trí mà bất kỳ thành viên nào trong Team cũng có thể truy cập được
- Cần lên một tiêu chuẩn chung cho thiết kế API gồm 
    - Req, Res
    - Thông tin trả về trong các trường hợp lỗi
    - Dữ liệu sample để có thể sử dụng được 
    - Có thể tách hẫn task ráp API và UI ra một task riêng. Giai đoạn phất triển FE sẽ dùng dữ liệu sample trong định nghĩa API để phát triển. Sau khi xong API thì thay dữ liệu sample thành dữ liệu trả về của APT
- Chốt template và nơi lưu trữ quản lý testcase
## Đã chốt các rule chung về code chưa?
- Quy tắc đặt tên biến lớp, func, table
- Cấu trúc thư mục cho dự án
- Tiêu chuẩn coding
- Quy định các tools cần cài đặt ở môi trường local và vị trí tải các tools đó để đảm bảo cả team đều cùng version
- Đã quy định về chuẩn tự động định dạng code java, html, js hay chưa?
- Hướng dẫn về cách cài đặt môi trường và setting các plugins cần thiết
## Đã chốt các item common của hệ thống chưa?
- CHốt danh sách màu của hê thống
- Chốt các item common
- CHốt các tính năng bắt buộc
## Đã thiết lập file quản lý lỗi của hệ thống 
- Chốt template và quy trình ghi nhận lỗi của hệ thống và phân tích để sử udngj cho buổi retro