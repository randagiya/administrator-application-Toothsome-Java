package Toothsome;

import Controller.Produk_c;
import Models.produk_m;
import View.produk;
import View.produk_menu;

/**
 * View = class
 * View2 = class_menu
 * Model = class_m(model)
 * @author RANDA
 */
public class ToothsomeDatabase {

    public static void main(String[] args) {

          produk_m model = new produk_m();
          produk_menu view2 = new produk_menu();
          produk view = new produk();
          Produk_c pro_c = new Produk_c(view2, model, view);
          
          pro_c.tampil_data();
          view2.setVisible(true);
        
    }

}
