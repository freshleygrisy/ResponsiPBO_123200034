/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsi_123200034;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class ViewAslab extends JFrame{
    JLabel lNama = new JLabel("Nama Pelamar");
    JLabel lPorto = new JLabel("Nilai Portofolio (0-100)");
    JLabel lMicro = new JLabel("Nilai Microteaching (0-100)");
    JLabel lWc = new JLabel("Nilai Wawancara (0-100)");
    
    public JTextField tfNama = new JTextField();
    public JTextField tfPorto = new JTextField();
    public JTextField tfMicro = new JTextField();
    public JTextField tfWc=  new JTextField();
    
    public JButton butTambah = new JButton("Tambah");
    public JButton butUpdate = new JButton("Update");
    public JButton butDelete = new JButton("Delete");
    public JButton butReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Nama Pelamar", "Portofolio", "Microteaching", "Wawancara", "Nilai Akhir"};

    public ViewAslab() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Pelamar Aslab");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lNama);
        lNama.setBounds(510, 20, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 40, 120, 20);
        
        add(lPorto);
        lPorto.setBounds(510, 60, 90, 20);
        add(tfPorto);
        tfPorto.setBounds(510, 80, 120, 20);
        
        add(lMicro);
        lMicro.setBounds(510, 100, 90, 20);
        add(tfMicro);
        tfMicro.setBounds(510, 120, 120, 20);
        
        add(lWc);
        lWc.setBounds(510, 140, 90, 20);
        add(tfWc);
        tfWc.setBounds(510, 160, 120, 20);
        
        add(butTambah);
        butTambah.setBounds(510, 190, 90, 20);
        
        add(butUpdate);
        butUpdate.setBounds(510, 220, 90, 20);
        
        add(butDelete);
        butDelete.setBounds(510, 250, 90, 20);
        
        add(butReset);
        butReset.setBounds(510, 280, 90, 20);
    }
    
    public String getNama(){
        return tfNama.getText();
    }
    
    public String getPortofolio(){
        return tfPorto.getText();
    }
    
    public String getMicroteaching(){
        return tfMicro.getText();
    }
    
    public String getWawancara(){
        return tfWc.getText();
    }
}
