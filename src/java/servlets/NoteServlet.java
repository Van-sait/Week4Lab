package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import models.Note;

/**
 *
 * @author 798382
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            try {

                try ( //read-file
                        BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {

                    String line;

                    String title = "";
                    String content = "";
                    int counter = 0;
                    while ((line = br.readLine()) != null) {

                        counter++;
                        if (counter == 1) {
                            title = line;
                        } else {
                            content = line;
                        }

                    }

                    Note note = new Note(title, content);
                    request.setAttribute("note", note);
                    br.close();
                }
            } catch (IOException e) {

            }

            String parameter1 = request.getParameter("edit");

            if (parameter1.equals("")) {

                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);

            }
        } finally {

            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        try {

            try ( //Write to file
                    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)))) {
                String title = request.getParameter("title");
                String content = request.getParameter("content");

                if ((!"".equals(title)) || (!"".equals(content))) {
                    pw.println(title);
                    pw.println(content);
                    Note note = new Note(title, content);
                    request.setAttribute("note", note);

                    pw.close();
                }
            }
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

        } catch (IOException e) {

        } finally {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }

    }

}
