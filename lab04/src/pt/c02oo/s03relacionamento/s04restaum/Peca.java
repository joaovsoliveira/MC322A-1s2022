package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
    private int x, y; // x é a linha da peça e y a coluna;
    private char valor; // o tabuleiro é composto de espaços vazios (' '), peças (P), e peças removidas
                        // (-);
    private Tabuleiro tabuleiro; // ponteiro para o tabuleiro, para que a peça faça as perguntas necessarias ao
                                 // tabuleiro

    Peca(int x, int y, char valor) {
        this.x = x;
        this.y = y;
        this.valor = valor;
    }

    // funçao para conectar a peça ao tabuleiro
    public void conectar(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    // a peça é responsavel por checar se pode ou não se mover
    public void move(String destino){
        int x_destino = Character.getNumericValue(destino.charAt(1))-1;
        int y_destino = destino.charAt(0)-'a';

        //checa se realmente é uma peça
        if(valor == 'P'){

            //pergunta ao tabuleiro se o destino é um espaço livre (peça removida)
            if(tabuleiro.temEspaco(x_destino, y_destino)){
                
                //checa se o movimento nao é na diagonal
                if(this.x == x_destino || this.y == y_destino){
                    
                    //checa se a distancia que o tabuleiro esta pedindo para mover é maior que a permitida
                    if(Math.sqrt(Math.pow((this.x - x_destino),2) + Math.pow((this.y - y_destino), 2)) <= 2){
                        
                        //checa se não há um espaço vazio entre a peça e a posição de destino
                        if(!tabuleiro.temEspaco((x+x_destino)/2, (y+y_destino)/2)){
                            
                            //muda o valor do destino para P
                            tabuleiro.setValor(Character.getNumericValue(destino.charAt(1))-1, destino.charAt(0)-'a', 'P');
                            
                            //muda a peça que estava entre a origem e o destino para '-'
                            tabuleiro.setValor((x+x_destino)/2, (y+y_destino)/2, '-');
                            
                            //muda o valor da peça atual para '-', pois agora ela é um espaço vazio
                            setValorPeca('-');
                        }
                    }
                }
            }
        }
    }

    // responsavel por informar ao tabuleiro qual é o seu valor
    public char getValorPeca() {
        return valor;
    }

    // responsavel por receber do tabuleiro o comando de alterar o valor, e o
    // proprio objeto altera
    public void setValorPeca(char novo_valor) {
        this.valor = novo_valor;
    }
}
