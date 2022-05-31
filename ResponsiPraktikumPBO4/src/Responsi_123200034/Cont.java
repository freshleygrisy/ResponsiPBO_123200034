/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsi_123200034;

import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author ASUS
 */
public class Cont {
    ModAslab modelContact;
    ViewAslab aslabView;
    public String data;
    public Cont(ModAslab modelContact, ViewAslab aslabView){
        this.modelContact = modelContact;
        this.aslabView = aslabView;
        
        if (modelContact.getBanyakData()!=0) {
            String dataAslab[][] = modelContact.readContact();
            aslabView.tabel.setModel((new JTable(dataAslab, aslabView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         aslabView.butTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = aslabView.getNama();
                double Portofolio = Double.parseDouble(aslabView.getPortofolio());
                double Microteaching = Double.parseDouble(aslabView.getMicroteaching());
                double Wawancara = Double.parseDouble(aslabView.getWawancara());
                double Nilai = (Portofolio+Microteaching+Wawancara)/3;
                modelContact.insertData(Nama, Portofolio, Microteaching, Wawancara, Nilai);
         
                String dataAslab[][] = modelContact.readContact();
                aslabView.tabel.setModel((new JTable(dataAslab, aslabView.namaKolom)).getModel());
            }
        });
         
          aslabView.butUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String nama = aslabView.getNama();
                double porto = Double.parseDouble(aslabView.getPortofolio());
                double micro = Double.parseDouble(aslabView.getMicroteaching());
                double wawancara = Double.parseDouble(aslabView.getWawancara());
                double hasil = (porto+micro+wawancara)/3;
                modelContact.updateData(nama, porto, micro, wawancara, hasil);

                String dataAslab[][] = modelContact.readContact();
                aslabView.tabel.setModel((new JTable(dataAslab, aslabView.namaKolom)).getModel());
            }
        });
         
          aslabView.butReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                aslabView.tfNama.setText("");
                aslabView.tfPorto.setText("");
                aslabView.tfMicro.setText("");
                aslabView.tfWc.setText("");
            }
        });
        
    
          aslabView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = aslabView.tabel.getSelectedRow();
                data = aslabView.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = aslabView.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = aslabView.tabel.getValueAt(baris, 1).toString();
                System.out.println(data);
            }
           });
                  
          aslabView.butDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus Nama " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelContact.deleteContact(data);
                String dataAslab[][] = modelContact.readContact();
                aslabView.tabel.setModel((new JTable(dataAslab, aslabView.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });

    }
    
}
