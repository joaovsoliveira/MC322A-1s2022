
public class Animacao {
    String acoes;
    int passoAtual;
    int tamAquario, tamLombriga, posInicio;
    AquarioLombriga lombriga;

    Animacao(String acoes){
        this.acoes = acoes;
        this.passoAtual = 5;
        tamAquario = Integer.parseInt(acoes.substring(0,2));
        tamLombriga = Integer.parseInt(acoes.substring(2,4));
        posInicio = Integer.parseInt(acoes.substring(4,6));
        lombriga = new AquarioLombriga(tamAquario, tamLombriga, posInicio);
    }
    //cria a lombriga pertencente a classe AquarioLombriga
    

    String apresenta(){
        //como lombriga é da classe AquarioLombriga, usar o metodo apresenta se refere ao metodo definido na classe AquarioLombriga
        String aux = lombriga.apresenta();
        return aux;
    }

    public void passo(){
        if(acoes.length()>6){
            passoAtual++;
            if(acoes.charAt(passoAtual) == 'C'){
                lombriga.crescer();
            }
            if(acoes.charAt(passoAtual) == 'M'){
                lombriga.mover();
            }
            if(acoes.charAt(passoAtual) == 'V'){
                lombriga.virar();
            }
        }
    }
}
