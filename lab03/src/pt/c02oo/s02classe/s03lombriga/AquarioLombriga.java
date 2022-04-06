
public class AquarioLombriga {
    // define os atributos do objeto, considerando a lombriga e o aquario o mesmo
    // objeto
    int tamLombriga;
    int tamAquario;
    int posInicio;
    int orientacao; // se for 1, a lombriga cresce para a direita (cabeça para esquerda),
                    // se for -1, a lombriga cresce para a esquerda (cabeça para a direita)

    AquarioLombriga(int tamAquario, int tamLombriga, int posInicio) {
        this.orientacao = 1;
        // caso a lombriga seja maior que o aquario, limita o tamanho da lombriga;
        if (tamAquario < tamLombriga) {
            this.tamLombriga = tamAquario;
            this.tamAquario = tamAquario;
        } else {
            this.tamAquario = tamAquario;
            this.tamLombriga = tamLombriga;
        }
        // caso a lombriga esteja em uma posição inicial invalida, insere ela na posição
        // 1
        if (posInicio > tamAquario || (tamLombriga - 1) > (tamAquario - posInicio)) {
            this.posInicio = 1;
        } else {
            this.posInicio = posInicio;
        }

    }

    void crescer() {
        // checa qual a orientação da lombriga, para ver para qual lado deve crescer
        if (orientacao == 1) {
            if (((tamAquario - posInicio + 1) - tamLombriga) > 0) {
                tamLombriga++;
            }
        } else {
            if ((posInicio - tamLombriga) > 0) {
                tamLombriga++;
            }
        }
    }

    void mover() {
        // checa se a lombriga esta para esquerda ou para direita
        if (orientacao == 1) {
            if (posInicio != 1) {
                posInicio--;
            } else {
                // se a operação mover estiver no limite, vira de lado
                this.virar();

            }
        } else {
            if ((posInicio) < tamAquario) {
                posInicio++;
            } else {
                this.virar();
            }
        }

    }

    void virar() {
        if(orientacao == 1){
            posInicio = posInicio + tamLombriga - 1;
        }
        else{
            posInicio = posInicio-tamLombriga+1;
        }
        orientacao = orientacao * -1;
    }

    String apresenta() {
        String aux = "";
        if (orientacao == 1) {
            // "varre" o comprimento do aquario, para valores menores que a posicao da
            // cabeça ou maiores
            // que o tamanho da lombriga + a posicao da cabeça, imprime "#". Na posição da
            // cabeça, imprime "O". No tamanho da lombriga
            // imprime "@"
            for (int i = 1; i < tamAquario + 1; i++) {
                if (i < posInicio || i > (posInicio + tamLombriga - 1)) {
                    aux = aux.concat("#");
                }
                if (i > posInicio && i < (posInicio + tamLombriga)) {
                    aux = aux.concat("@");
                }
                if (i == posInicio) {
                    aux = aux.concat("O");
                }
            }
            System.out.print("\n");
        } else {
            for (int i = 1; i < tamAquario + 1; i++) {
                if (i < (posInicio - tamLombriga + 1) || i > posInicio) {
                    aux = aux.concat("#");
                }
                if ((posInicio - tamLombriga + 1) <= i && i < posInicio) {
                    aux = aux.concat("@");
                }
                if (i == posInicio) {
                    aux = aux.concat("O");
                }
            }
            System.out.print("\n");
        }
        return aux;
    }
}
