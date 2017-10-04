package com.treinamento.Mock.treinamentoMock;

public class Avaliacao {

    public String avaliar(Estudante aluno){
        if(aluno.getNotaProva()>=7)
            if (aluno.getNotaTrabalho() >= 7)
                return "Aprovado";
        else
            return "Precisará repor a nota do trabalho";
        else
            return "Terá que fazere DP";
    }
}

//    public String avaliar(Estudante aluno){
//        if(aluno.getNotaProva()>=7)
//            if (aluno.getNotaProva() >= 7)
//                return "Aprovado";
//            else
//                return "Precisará repor a nota do trabalho";
//        else
//            return "Terá que fazere DP";
//    }