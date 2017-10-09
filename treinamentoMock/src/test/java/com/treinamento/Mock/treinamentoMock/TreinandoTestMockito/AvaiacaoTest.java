package com.treinamento.Mock.treinamentoMock.TreinandoTestMockito;

import com.treinamento.Mock.treinamentoMock.Aluno;
import com.treinamento.Mock.treinamentoMock.Avaliacao;
import com.treinamento.Mock.treinamentoMock.Estudante;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AvaiacaoTest {

    @Mock
    private  Estudante estudante;

    @InjectMocks
    private Avaliacao avaliacao;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testeAlunoAprovado() {

        when(estudante.getNotaProva()).thenReturn(7.0);
        when(estudante.getNotaTrabalho()).thenReturn(8.0);

        String resultado = avaliacao.avaliar(estudante);

        Assert.assertEquals("Aprovado", resultado);
    }

    @Test
    public void testeAlunoReporNota() {
        Avaliacao avaliacao = new Avaliacao();
        Estudante aluno = new Aluno();
        String resultado = avaliacao.avaliar(aluno);
        Assert.assertEquals("Precisará repor a nota do trabalho", resultado);
    }

    @Test
    public void testeAlunoTeraQueFazerDP() {
        Avaliacao avaliacao = new Avaliacao();
        Estudante aluno = new Aluno();
        String resultado = avaliacao.avaliar(aluno);
        Assert.assertEquals("Terá que fazere DP", resultado);
    }
}

















//    @Test
//    public void testeAlunoAprovado(){
//        Avaliacao avaliacao = new Avaliacao();
//
//        String resultado = avaliacao.avaliar(7,8);
//        Assert.assertEquals("Aprovado",resultado);
//    }
//
//    @Test
//    public void testeAlunoReporNota(){
//        Avaliacao avaliacao = new Avaliacao();
//
//        String resultado = avaliacao.avaliar(7,6);
//
//        Assert.assertEquals("Precisará repor a nota do trabalho",resultado);
//    }
//
//    @Test
//    public void testeAlunoTeraQueFazerDP(){
//        Avaliacao avaliacao = new Avaliacao();
//
//        String resultado = avaliacao.avaliar(5,6);
//        Assert.assertEquals("Terá que fazere DP",resultado);
//    }
//}





//    @Test
//    public void testeAlunoAprovado(){
//        Avaliacao avaliacao = new Avaliacao();
//        Estudante aluno = new Aluno();
//        String resultado = avaliacao.avaliar(aluno);
//        Assert.assertEquals("Aprovado",resultado);
//    }
//
//    @Test
//    public void testeAlunoReporNota(){
//        Avaliacao avaliacao = new Avaliacao();
//        Estudante aluno = new Aluno();
//        String resultado = avaliacao.avaliar(aluno);
//        Assert.assertEquals("Precisará repor a nota do trabalho",resultado);
//    }
//
//    @Test
//    public void testeAlunoTeraQueFazerDP(){
//        Avaliacao avaliacao = new Avaliacao();
//        Estudante aluno = new Aluno();
//        String resultado = avaliacao.avaliar(aluno);
//        Assert.assertEquals("Terá que fazere DP",resultado);
//    }