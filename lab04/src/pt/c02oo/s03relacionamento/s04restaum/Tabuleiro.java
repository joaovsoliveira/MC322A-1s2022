package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
    private Peca tabuleiro[][] = new Peca[7][7];

    Tabuleiro(){
        //cria um tabuleiro inicial, que é uma matriz de peças
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                //adiciona as peças primeiro nas linhas em que há espaços vazios
                if(i<=1 || i>=5){
                    if(j>=2 && j<=4){
                        tabuleiro[i][j] = new Peca(i,j,'P');
                    }
                    else{
                        tabuleiro[i][j]= new Peca(i,j,' ');;
                    }
                }
                else{
                    //adiciona as peças no resto do tabuleiro
                    tabuleiro[i][j]= new Peca(i,j,'P');;
                }
            }
        }
        //remove a peça do centro
        tabuleiro[3][3] = new Peca(3,3,'-');
    }
    //retorna o ponteiro para a peça
    /* public Peca getPeca(int x, int y){
        return tabuleiro[x][y];
    } */

    //retorna o valor da peça desejada
    public char getValor(int x, int y){
        return tabuleiro[x][y].getValorPeca();
    }

    //como o tabuleiro é responsavel por alterar o valor da peça, é necessario criar um metodo set
    public void setValor(int x, int y, char valor){
        tabuleiro[x][y].setValorPeca(valor);
    }

    //retorna o ponteiro para a peça, para que a peça possa de conectar ao tabuleiro
    public Peca getPeca(int x, int y){
        return tabuleiro[x][y];
    }

    //função responsavel por pedir para que a peça se mova
    public void movePeca(String movimento){
        tabuleiro[Character.getNumericValue(movimento.charAt(1))-1][movimento.charAt(0)-'a'].move(movimento.substring(3, 5));
    }

    //retorna veradeiro caso haja espaço livre para mover a peça (destino há peça removida), e falso caso contrario
    public boolean temEspaco(int x, int y){
        if(tabuleiro[x][y].getValorPeca()=='-'){
            return true;
        }
        else{
            return false;
        }
    }
}
