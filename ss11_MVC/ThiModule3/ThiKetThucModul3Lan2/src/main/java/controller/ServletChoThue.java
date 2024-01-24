package controller;

import model.ChoThue;
import model.MatBang;
import model.TrangThai;
import repository.IChoThueRepository;
import repository.IMatBangRepository;
import repository.ITrangThaiRepoditory;
import repository.impl.ChoThueRepository;
import repository.impl.MatBangRepository;
import repository.impl.TrangThaiRepoditory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/ServletChoThue", value = "/choThues")
public class ServletChoThue extends HttpServlet {
    IChoThueRepository choThueRepository = new ChoThueRepository();
    ITrangThaiRepoditory trangThaiRepoditory = new TrangThaiRepoditory();
    IMatBangRepository matBangRepository = new MatBangRepository();

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
            case "delete":
                showDelete(request, response);
                break;
            case "search1":
                searchMatBang(request, response);
                break;
            case "search2":
                searchTang(request, response);
                break;
            case "search3":
                searchGia(request, response);
                break;
            default:
                showlist(request, response);
                break;

        }
    }

    private void searchGia(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchTang(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchMatBang(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showlist(HttpServletRequest request, HttpServletResponse response) {
        List<ChoThue> choThueList = choThueRepository.finalAllChoThue();
        List<MatBang> matBangList = matBangRepository.finalAllMatBang();
        List<TrangThai> trangThaiList = trangThaiRepoditory.finalAllTrangThai();

        request.getSession().setAttribute("choThueList", choThueList);
        request.getSession().setAttribute("matBangList", matBangList);
        request.getSession().setAttribute("trangThaiList", trangThaiList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/choThues/list.jsp");
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
        choThueRepository.delete(id);
        request.setAttribute("messageDelete", "Xóa thành công");
        try {
            response.sendRedirect("/choThues");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> matBangs = matBangRepository.finalAllMatBang();
        List<TrangThai> trangThais = trangThaiRepoditory.finalAllTrangThai();
        request.setAttribute("matBangs", matBangs);
        request.setAttribute("trangThais", trangThais);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/choThues/create.jsp");
        try {
            requestDispatcher.forward(request, response);
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
            case "create":
                create(request, response);
                break;
//            case "search":
//                search(request, response);
//                break;

        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 1000);
        int dienTich = Integer.parseInt(request.getParameter("a"));
        int tang = Integer.parseInt(request.getParameter("c"));
        double giaChoThue = Double.parseDouble(request.getParameter("e"));
        String ngayBatDau = request.getParameter("f");
        String ngayKetThuc = request.getParameter("g");

        ChoThue choThue = new ChoThue(id, dienTich, tang, giaChoThue, ngayBatDau, ngayKetThuc);


        int idTT = Integer.parseInt(request.getParameter("b"));
        TrangThai trangThai = trangThaiRepoditory.finalById(idTT);
        choThue.setNameTrangThai(trangThai);

        int idMB = Integer.parseInt(request.getParameter("d"));
        MatBang matBang = matBangRepository.finalById(idMB);
        choThue.setNameMatBang(matBang);
        choThueRepository.create(choThue);

        request.setAttribute("message", "Thêm mới thành công");

        try {
            request.getRequestDispatcher("/choThues/create.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}