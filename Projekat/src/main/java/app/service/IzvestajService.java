/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.domain.Sportista;
import app.domain.SportistaVezba;
import app.repository.SportistaRepository;
import app.repository.SportistaVezbaRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class IzvestajService {
    private final SportistaRepository sportistaRepository;
    private final SportistaVezbaRepository sportistaVezbaRepository;

    @Autowired
    public IzvestajService(
            SportistaRepository sportistaRepository,
            SportistaVezbaRepository sportistaVezbaRepository) {

        this.sportistaRepository = sportistaRepository;
        this.sportistaVezbaRepository = sportistaVezbaRepository;
    }
    
    public byte[] generisiIzvestaj(String id) {

        Sportista sportista =
            sportistaRepository.findById(id);


        List<SportistaVezba> vezbe =
            sportistaVezbaRepository.findBySportistaId(id);


        int prosao = 0;

        for(SportistaVezba sv : vezbe){
            System.out.println(
                sv.getVezba().getNaziv() 
                + " norma = "
                + sv.getVezba().getNorma()
            );
            if(sv.getBrojPonavljanja() >= 
               sv.getVezba().getNorma()){

                prosao++;

            }
        }


        double procenat =
            prosao * 100.0 / vezbe.size();


        boolean polozen =
            procenat >= 70;
        
        
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();


        Document document = new Document();

        PdfWriter.getInstance(document, baos);


        document.open();


        document.add(new Paragraph("IZVESTAJ SPORTISTE"));
        document.add(new Paragraph(" "));


        document.add(new Paragraph(
            "Ime: " + sportista.getIme()
        ));

        document.add(new Paragraph(
            "Prezime: " + sportista.getPrezime()
        ));

        document.add(new Paragraph(
            "Korisnicko ime: " + sportista.getKorisnickoIme()
        ));


        document.add(new Paragraph(" "));
        document.add(new Paragraph("VEZBE:"));


        for(SportistaVezba sv : vezbe){

            document.add(new Paragraph(
                sv.getVezba().getNaziv()
                + " - "
                + sv.getBrojPonavljanja()
                + "/"
                + sv.getVezba().getNorma()
            ));

        }


        document.add(new Paragraph(" "));
        document.add(new Paragraph(
            "Rezultat: " + procenat + "%"
        ));


        document.add(new Paragraph(
            polozen ? 
            "TEST POLOZEN" :
            "TEST NIJE POLOZEN"
        ));


        document.close();


        return baos.toByteArray();
    }
    
    

}
    
    

