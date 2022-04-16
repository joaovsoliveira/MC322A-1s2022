package pt.c02oo.s03relacionamento.s04restaum;


public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);

      Tabuleiro tabuleiro = new Tabuleiro();
      //conecta cada peça ao tabuleiro
      for(int i=0; i<7; i++){
         for(int j=0; j<7;j++){
            tabuleiro.getPeca(i, j).conectar(tabuleiro);
         }
      }

      char board[][] = new char[7][7];
      for(int i=0; i<7; i++){
         for(int j=0; j<7;j++){
            board[i][j] = tabuleiro.getValor(i, j);
         }
      }

      tk.writeBoard("Tabuleiro inicial", board);

      String commands[] = tk.retrieveCommands();
      
      //realiza os comandos da lista
      for (int l = 0; l < commands.length; l++){
         System.out.println(commands[l]);
         tabuleiro.movePeca(commands[l]);

         //atualiza a matriz de impressao
         for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
               board[i][j] = tabuleiro.getValor(i, j);
            }
         }
         
         String aux = "source: " + commands[l].substring(0,2) + "; target: " + commands[l].substring(3,5);
         tk.writeBoard(aux, board);
      }

      tk.stop();
   }

}