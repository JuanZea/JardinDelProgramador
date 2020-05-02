/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 * Esta clase gestiona de manera eficaz la informacion y la distribuye en un
 * archivo pdf.
 *
 * @author JuanZea
 * @version 1.0.0
 * @since Jardin 1.0.4
 */
public class GeneradorPdf {

    private Font fuenteBold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuenteItalic = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER, 6, Font.NORMAL);

    public void GenerarPdf(String header, String info, String footer, String rutaImagen, String salida) {

        try {
            Document doc = new Document(PageSize.A7, 36, 36, 10, 10);
            PdfWriter.getInstance(doc, new FileOutputStream(salida));
            doc.open();
            doc.add(getHeader(header));
            Image img = Image.getInstance(rutaImagen);
            img.scaleAbsolute(200, 100);
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);
            doc.add(getInfo(info));
            doc.add(getFooter(footer));
            doc.close();

        } catch (Exception e) {
        }
    }

    public Paragraph getHeader(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteBold);
        p.add(c);
        return p;
    }

    public Paragraph getInfo(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_LEFT);
        c.append(texto);
        c.setFont(fuenteNormal);
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
