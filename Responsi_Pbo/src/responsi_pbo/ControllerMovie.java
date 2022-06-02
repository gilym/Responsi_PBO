/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi_pbo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author gilym
 */
public class ControllerMovie {
    ModelMovie mm;
    ViewMovie vm;

    public ControllerMovie(ModelMovie mm, ViewMovie vm) {
        this.mm = mm;
        this.vm = vm;
        
        
                  if (mm.getBanyakData()!=0) {
            String dataKontak[][] = mm.readMovie();
            vm.tabel.setModel((new JTable(dataKontak, vm.namaKolom)).getModel());
            
    }
                  
                               vm.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 double alur=0,tokoh=0,akting=0;
                    try{
                        alur=Double.parseDouble(vm.tfAlur.getText());
                 tokoh=Double.parseDouble(vm.tfPenokohan.getText());
                  akting=Double.parseDouble(vm.tfAkting.getText());
                  }
                  catch (Exception ex){
                      System.out.println(" ");
                  }
               
                if(vm.tfAkting.getText().equals("") || vm.tfAlur.getText().equals("")|| vm.tfJudul.getText().equals("")|| vm.tfPenokohan.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
               
                }
               
                else if(alur<0 || alur>5 ||tokoh<0 || tokoh>5  ||akting<0 || akting>5){
                  JOptionPane.showMessageDialog(null,"Range (0-5)");
                }
                else{
                String judul1 = vm.getJudul();
                String alur1 = vm.getAlur();
                String penokohan1 = vm.getPenokohan();
                String akting1 = vm.getAkting();
                
                mm.insertData(judul1, alur1, penokohan1, akting1);

                String dataperpus[][] = mm.readMovie();
                vm.tabel.setModel((new JTable(dataperpus, vm.namaKolom)).getModel());
                vm.tfJudul.setText(null);
                vm.tfAlur.setText(null);
                vm.tfPenokohan.setText(null);
                vm.tfAkting.setText(null);
                }
             
            }
        });
                               
               vm.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               double alur=0,tokoh=0,akting=0;
                    try{
                        alur=Double.parseDouble(vm.tfAlur.getText());
                 tokoh=Double.parseDouble(vm.tfPenokohan.getText());
                  akting=Double.parseDouble(vm.tfAkting.getText());
                  }
                  catch (Exception ex){
                      System.out.println(" ");
                  }
                if(vm.tfAkting.getText().equals("") || vm.tfAlur.getText().equals("")|| vm.tfJudul.getText().equals("")|| vm.tfPenokohan.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
                }
                  if(vm.tfAkting.getText().equals("") || vm.tfAlur.getText().equals("")|| vm.tfJudul.getText().equals("")|| vm.tfPenokohan.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
               
                }
                else{
                String judul1 = vm.getJudul();
                String alur1 = vm.getAlur();
                String penokohan1 = vm.getPenokohan();
                String akting1 = vm.getAkting();
                mm.updateMovie(judul1, alur1, penokohan1, akting1);

                String dataperpus[][] = mm.readMovie();
                vm.tabel.setModel((new JTable(dataperpus, vm.namaKolom)).getModel());
                vm.tfJudul.setText(null);
                vm.tfAlur.setText(null);
                vm.tfPenokohan.setText(null);
                vm.tfAkting.setText(null);
                }
               
            }
        });
               
                vm.tabel.addMouseListener(new MouseAdapter() {
                                              @Override
     public void mouseClicked(MouseEvent e) {
          super.mousePressed(e);
          int baris = vm.tabel.getSelectedRow();
          int kolom = vm.tabel.getSelectedColumn(); // ga kepake sekarang

          String judul = vm.tabel.getValueAt(baris, 0).toString();
          String alur= vm.tabel.getValueAt(baris,1 ).toString();
          String penokohan = vm.tabel.getValueAt(baris,2 ).toString();
           String akting = vm.tabel.getValueAt(baris,3 ).toString();
          

        

      
        
       
               vm.tfJudul.setText(judul);
              vm.tfAlur.setText(alur);
              vm.tfPenokohan.setText(penokohan);
              vm.tfAkting.setText(akting);
              
        
          
      }
  }
      );
                                       
          vm.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vm.tfJudul.setText(null);
                vm.tfAlur.setText(null);
                vm.tfPenokohan.setText(null);
                vm.tfAkting.setText(null);
                
             
               
               
            }
        });
        vm.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(vm.tfAkting.getText().equals("") || vm.tfAlur.getText().equals("")|| vm.tfJudul.getText().equals("")|| vm.tfPenokohan.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
                }
                else{
                String judul = vm.getJudul();
                           mm.deleteMovie(judul);
                           vm.tfJudul.setText(null);
                vm.tfAlur.setText(null);
                vm.tfPenokohan.setText(null);
                vm.tfAkting.setText(null);

                String dataperpus[][] = mm.readMovie();
                vm.tabel.setModel((new JTable(dataperpus, vm.namaKolom)).getModel());
                }
             
               
               
            }
        });
    
}
}
