package src.pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
    //define os atributos do objeto, considerando a lombriga e o aquario o mesmo objeto
    int tam_lombriga;
    int tam_aquario;
    int pos_inicio;
    int orientacao; //se for 1, a lombriga cresce para a direita (cabeça para esquerda), 
                    //se for -1, a lombriga cresce para a esquerda (cabeça para a direita)

    public AquarioLombriga(int tam_aquario, int tam_lombriga, int pos_inicio){
        this.orientacao = 1;
        //caso a lombriga seja maior que o aquario, limita o tamanho da lombriga; 
        if(tam_aquario<tam_lombriga){
            this.tam_lombriga = tam_aquario;
            this.tam_aquario = tam_aquario;
        }
        else{
            this.tam_aquario = tam_aquario;
            this.tam_lombriga = tam_lombriga;
        }
        //caso a lombriga esteja em uma posição inicial invalida, insere ela na posição 1
        if(pos_inicio>tam_aquario || (tam_lombriga-1)>(tam_aquario-pos_inicio)){
            this.pos_inicio = 1;
        }
        else{
            this.pos_inicio = pos_inicio;
        }
        
    }

    public void crescer(){
        //checa qual a orientação da lombriga, para ver para qual lado deve crescer
        if(orientacao==1){
            if(((tam_aquario-pos_inicio+1)-tam_lombriga)>0){
                tam_lombriga++;
            }
        }
        else{
            if((pos_inicio-tam_lombriga)>0){
                tam_lombriga++;
            }
        }
    }

    public void mover(){
        //checa se a lombriga esta para esquerda ou para direita
        if(orientacao==1){
            if(pos_inicio!=1){
                pos_inicio--;
            }
            else{
                //se a operação mover estiver no limite, vira de lado
                this.virar();
                pos_inicio = tam_lombriga;
            }
        }
        else{
            if((pos_inicio+1)<tam_aquario){
                pos_inicio++;
            }
            else{
                this.virar();
                pos_inicio = tam_aquario - tam_lombriga;
            }
        }
            
    }

    public void virar(){
        orientacao = orientacao*-1;
    }

    public void apresenta(){
        //só existem 2 casos para a lombriga, ou ela é menor que o aquario ou tem exatamente o tamanho do aquario

        //começando pelo caso que tem exatamente o tamanho do aquario
        if(tam_aquario==tam_lombriga){
            if(orientacao==1){
                System.out.print("O");
                for(int i=1; i<tam_lombriga; i++){
                    System.out.print("@");
                }
            }
            else{
                for(int i=1; i<tam_lombriga; i++){
                    System.out.print("@");
                }
                System.out.print("O");
            }
        }

        //caso em que a lombriga é menor que o aquario
        if(orientacao == 1){
            //"varre" o comprimento do aquario, para valores menores que a posicao da cabeça ou maiores
            //que o tamanho da lombriga + a posicao da cabeça, imprime "#". Na posição da cabeça, imprime "O". No tamanho da lombriga
            //imprime "@"
            for(int i=1; i<tam_aquario+1; i++){
                if(i<pos_inicio || i>(pos_inicio+tam_lombriga-1)){
                    System.out.print("#");
                }
                if(i>pos_inicio && i<(pos_inicio+tam_lombriga)){
                    System.out.print("@");
                }
                if(i==pos_inicio){
                    System.out.print("O");
                }
            }
            System.out.print("\n");
        }
        else{
            for(int i=1; i<tam_aquario+1; i++){
                if(i<(pos_inicio-tam_lombriga+1) || i>pos_inicio){
                    System.out.print("#");
                }
                if((pos_inicio-tam_lombriga+1)<=i && i<pos_inicio){
                    System.out.print("@"); 
                }
                if(i==pos_inicio){
                    System.out.print("O");
                }
            }
            System.out.print("\n"); 
        }
    }
}

