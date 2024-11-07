
<%@page import="java.util.ArrayList"%>
<%@page import="model.Hoa"%>
<%-- 
    Document   : list_product
    Created on : Oct 22, 2024, 2:11:45 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../shared/header.jsp" />
             
<jsp:include page="../shared/nav.jsp" />

<%
    if(request.getAttribute("success") !=null){
%>
<script>
    swal.fire({
        title:"Good iobi",
        text:"<%=request.getAttribute("success")%>",
        icon:"success"
    })
</script>
<% }%>
<%
    if(request.getAttribute("error") !=null){
%>
<script>
    swal.fire({
        title:"Good iobi",
        text:"<%=request.getAttribute("error")%>",
        icon:"success"
    })
</script>
<div class="container">
    <h2> Danh sách sản phẩm</h2>
    <div class="mb-2 text-end">
        <a href="#" class="btn btn-success"> <i class="bi bi-plus-circle"></i> Thêm mới</a>
    </div>
    
    <table class="table table-bordered table-striped">
        <tr>
            <th>Tên hoa</th>
            <th>Giá</th>
            <th>Hình ảnh</th>
            <th>Loại</th>
            <th>Action</th>
        </tr>
        <%
            ArrayList<Hoa> dsHoa = (ArrayList<Hoa>) request.getAttribute("dsHoa");
            for (Hoa x : dsHoa) {
        %>
        <td><%= x.getTenhoa()%></td>
        <td><%= x.getGia()%></td>
        <td><img src="../assets/images/products/<%= x.getHinh()%>" style="width: 100px"></td>
        <td><%= x.getMaloai()%></td>
        <td>
            <a href="#" class="btn btn-secondary"> <i class="bi bi-pencil-square"></i> Sửa</a>
            <a href="#" class="btn btn-danger"> <i class="bi bi-trash"></i> Xoá</a>
        </td>

        <%
            }
        %>
    </table>
</div>


<jsp:include page="../shared/footer.jsp" />