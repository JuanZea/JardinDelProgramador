/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Institucion;
import Modelo.Personas.Niño;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 * Esta clase gestiona de manera eficaz la informacion y la distribuye en un
 * archivo pdf.
 *
 * @author JuanZea
 * @version 1.0.1
 * @since Jardin 1.0.4
 */
public class GeneradorPdf {

    private Font fuenteBold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuenteItalic = new Font(Font.FontFamily.COURIER, 6, Font.ITALIC);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER, 8, Font.NORMAL);
    static Font stockyTitle;
    static Font stockyBlack;
    static Font stockyGreen;
    static Font stockyRed;
    static Image imagen;

    public void GenerarPdf(Niño niño, Institucion institucion, int imagen, String nombre, String ruta) {

        try {
            generarFormato(imagen);
            Document doc = new Document(PageSize.A6, 29, 29, 10, 10);
            if (ruta == null) {
                PdfWriter.getInstance(doc, new FileOutputStream("Pdf's/" + nombre + ".pdf"));
            } else {
                PdfWriter.getInstance(doc, new FileOutputStream(ruta + ".pdf"));
            }

            doc.open();

            doc.add(getTitulo(niño.getNombre()));
            doc.add(getInfo(niño));
            doc.add(getInfo(institucion));

            doc.close();

        } catch (Exception e) {
        }
    }

    public static void generarFormato(int f) {
        try {
            BaseFont bStocky = BaseFont.createFont("src/Vista/font/stocky.ttf", BaseFont.WINANSI, true);
            stockyTitle = new Font(bStocky, 25, Font.NORMAL, BaseColor.BLACK);
            stockyBlack = new Font(bStocky, 8, Font.NORMAL, BaseColor.BLACK);
            stockyGreen = new Font(bStocky, 8, Font.NORMAL, BaseColor.GREEN);
            stockyRed = new Font(bStocky, 8, Font.NORMAL, BaseColor.RED);
            String ruta;
            switch (f) {
                default:
                    ruta = "src/Vista/img/LogoJ.png";
                    break;
                case 1:
                    ruta = "src/Vista/img/Logo1.png";
                    break;
                case 2:
                    ruta = "src/Vista/img/Logo2.png";
                    break;
                case 3:
                    ruta = "src/Vista/img/Logo3.png";
                    break;
            }
            imagen = Image.getInstance(ruta);
            imagen.scaleAbsolute(100, 100);
            imagen.setAlignment(Element.ALIGN_CENTER);
        } catch (Exception e) {
        }
    }

    public Paragraph getTitulo(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto.toUpperCase());
        c.setFont(stockyTitle);
        p.add(c);
        return p;
    }

    public Paragraph getInfo(Niño niño) {
        Paragraph p = new Paragraph();
        p.add(imagen);
        Chunk c0 = new Chunk();
        c0.append("Dirigido a: ");
        p.add(c0);
        Chunk c1 = new Chunk();
        for (int i = 0; i < niño.getAcudientes().size(); i++) {

            c1.append(niño.getAcudientes().get(i).getNombre() + " (" + niño.getAcudientes().get(i).getParentesco() + ")" + "\n");
        }
        p.add(c1);
        Chunk c2 = new Chunk();
        c2.append("El avance de " + niño.getNombre() + " representado en bimestres fue el siguiente:\n");
        c2.setFont(fuenteNormal);
        p.add(c2);

        for (int i = 0; i < niño.getLogros().size(); i++) {
            Chunk c3 = new Chunk();
            c3.append("Logro#" + (i + 1) + ": ");
            c3.setFont(stockyBlack);
            p.add(c3);
            Chunk c4 = new Chunk();
            if (niño.getLogros().get(i).isObjetivo()) {
                c4.append("Cumplido\n");
                c4.setFont(stockyGreen);
            } else {
                c4.append("No Cumplido\n");
                c4.setFont(stockyRed);
            }
            p.add(c4);
            Chunk c5 = new Chunk();
            c5.append(niño.getLogros().get(i).getNombre() + "\n");
            c5.setFont(fuenteNormal);
            p.add(c5);
        }
        return p;
    }

    public Paragraph getInfo(Institucion institucion) {
        Paragraph p = new Paragraph();
        p.setAlignment(Element.ALIGN_RIGHT);
        Chunk c = new Chunk();
        c.append(institucion.getNombre() + "\n");
        c.append("Institucion de cáracter " + institucion.getCaracter() + "\n");
        c.append("Fundada en : " + institucion.getAñoFundacion() + "\n");
        c.append("Ubicada en: " + institucion.getDireccion() + "\n");
        c.append("NIT: " + institucion.getNit() + "\n");
        c.append("Con " + institucion.getMatriculados() + " niños matriculados");
        c.setFont(fuenteItalic);
        p.add(c);
        return p;
    }

    public Paragraph getFooter(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);
        c.append(texto);
        c.setFont(fuenteItalic);
        p.add(c);
        return p;
    }

}
