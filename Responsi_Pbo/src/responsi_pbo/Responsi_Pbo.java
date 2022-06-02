/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package responsi_pbo;

/**
 *
 * @author gilym
 */
public class Responsi_Pbo {

    
    public static void main(String[] args) {
       ViewMovie vm = new ViewMovie();
       ModelMovie mm= new ModelMovie();
       new ControllerMovie(mm,vm);
    }
    
}
