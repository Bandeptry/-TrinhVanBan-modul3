package controller;

import model.Category;
import model.Product;
import service.ICategoryService;
import service.IProductService;
import service.impl.CategoryService;
import service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "/ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showlist(request, response);

        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categories = categoryService.finalAllCategory();
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/products/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
//        List<Product> productList = productService.finalAllProduct();
        List<Category> categories = categoryService.finalAllCategory();
//        request.setAttribute("productList", productList);
        request.setAttribute("categories", categories);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.finalById(id);
        request.setAttribute("productList", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        request.setAttribute("messageDelete", "Xóa thành công");
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showlist(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.finalAllProduct();
        List<Category> categoryList = categoryService.finalAllCategory();
        request.getSession().setAttribute("productList", productList);
        request.getSession().setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "edit":
                edit(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "search":
                search(request, response);
                break;

        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenSP = request.getParameter("ten");
        double gia = Double.parseDouble(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String mauSac = request.getParameter("mauSac");
        String moTa = request.getParameter("moTa");

        Product product = productService.finalById(id);
        product.setTenSanPham(tenSP);
        product.setGia(gia);
        product.setSoLuong(soLuong);
        product.setMauSac(mauSac);
        product.setMauSac(moTa);

        int idCate = Integer.parseInt(request.getParameter("danhMuc"));
        Category category = categoryService.finalById(idCate);

        product.setCategory(category);
        productService.update(id, product);

        request.getSession().setAttribute("messageEdit", "Sửa thành công");
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 1000);
        String tenSanPham = request.getParameter("ten");
        Double gia = Double.parseDouble(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String mauSac = request.getParameter("mauSac");
        String moTa = request.getParameter("moTa");

        Product product = new Product(id, tenSanPham, gia, soLuong, mauSac, moTa);

        int idCate = Integer.parseInt(request.getParameter("danhMuc"));
        Category category = categoryService.finalById(idCate);

        product.setCategory(category);
        productService.create(product);

        request.setAttribute("message", "Thêm mới thành công");

        try {
            request.getRequestDispatcher("/products/create.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Product> products = productService.seach(search);

        request.setAttribute("products",products);

//        List<Product> productList = productService.finalAllProduct();
        List<Category> categoryList = categoryService.finalAllCategory();
//        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("messageSearch","Đây rồi!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/products/search.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }