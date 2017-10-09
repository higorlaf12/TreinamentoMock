package com.treinamento.Mock.treinamentoMock.TreinandoTestMockito;

import com.treinamento.Mock.treinamentoMock.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class ClassCalculadoraTest {


    private int x;
    private int y;

    @Before
    public void init(){
        x = 1;
        y = 6;
    }

    @Test
    public void testCalculadoraSomarSuccesso(){
        Calculadora  calculadora = new Calculadora();
        calculadora.setY(y);
        calculadora.setX(x);

        assertEquals(7,calculadora.somar());

    }


}
