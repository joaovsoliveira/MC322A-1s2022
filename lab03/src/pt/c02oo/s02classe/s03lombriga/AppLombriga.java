
public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++){
         System.out.println(lombrigas[l]);
         Animacao lombriga = new Animacao(lombrigas[l]);
         tk.gravaPasso("=====");
         tk.gravaPasso(lombriga.apresenta());
         for(int i=0; i<lombrigas[l].length()-6; i++){
            lombriga.passo();
            tk.gravaPasso(lombriga.apresenta());
         }
      }
      tk.stop();
   }

}
