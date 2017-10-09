package com.treinamento.Mock.treinamentoMock.TreinandoTestMockito;


import com.treinamento.Mock.treinamentoMock.controller.DomainBuyController;
import com.treinamento.Mock.treinamentoMock.domain.DomainBuy;
import com.treinamento.Mock.treinamentoMock.service.DomainBuyServer;
import com.treinamento.Mock.treinamentoMock.utils.ResulterHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(MockitoJUnitRunner.class)//Iniciar a Classe testada
public class TestandoControllerTest {


    private MockMvc mockMvc;
    //	MockMvc é o ponto de entrada principal para suporte de teste Spring MVC do lado do servidor.
    // Execute um pedido e devolva um tipo que permita encadear mais ações, como afirmar expectativas, sobre o resultado.

    @Mock//cria uma simulação
    private DomainBuyServer domainBuyServer;
    //	@Mock criando uma simulação. Isso também pode ser alcançado usando o org.mockito.mock(..)método.

    @InjectMocks
//cria uma instância da classe e injeta as moedas que são criadas com as @Mock(ou @Spy) anotações nesta instância
    private DomainBuyController domainBuyController;// Indica qual classe ele ira testar
    //	@InjectMocks injeta campos simulados ou espiões em objetos testados automaticamente.

    private DomainBuy domainBuy;
    private List<DomainBuy> domainBuys;

    @Before // Inicia primeiro que todos os teste
    public void init() {
        MockitoAnnotations.initMocks(this);
        //	MockitoAnnotations.initMocks (este) inicializa campos anotados com anotações Mockito.
        mockMvc = MockMvcBuilders
                .standaloneSetup(domainBuyController)
                .build();
        //	MockMvcBuilders.standaloneSetup (..). Build () cria uma MockMvc instância registrando uma
        // ou mais @Controllerinstâncias e configurando a infraestrutura Spring MVC de forma programática.

        domainBuy = new DomainBuy().id(1).insert("Testando").num(15444);
        domainBuys = new ArrayList<>();
        domainBuys.add(domainBuy);

    }

    @Test
    public void testGetAllSuccess() throws Exception {
//        DomainBuy domainBuy = new DomainBuy().id(1).insert("Testando").num(15444);
//
//        List<DomainBuy> domainBuys = new ArrayList<>();
//        domainBuys.add(domainBuy);

        when(domainBuyServer.findAllDomainBuy()).thenReturn(domainBuys);

        mockMvc.perform(get("/buy"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].insert", is("Testando")))
                .andExpect(jsonPath("$[0].num", is(15444)));

        verify(domainBuyServer, times(1)).findAllDomainBuy();
        verifyNoMoreInteractions(domainBuyServer);
    }

    @Test
    public void testGetFindOneDomainBuySuccess() throws Exception {
        when(domainBuyServer.findOneDomainBuy(domainBuy.getId())).thenReturn(domainBuy);

        mockMvc.perform(get("/buy/{id}", domainBuy.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)));
        verify(domainBuyServer, times(1)).findOneDomainBuy(domainBuy.getId());
        verifyNoMoreInteractions(domainBuyServer);
    }

    @Test
    public void testGetFindOneDomainBuyError404() throws Exception {
        when(domainBuyServer.findOneDomainBuy(domainBuy.getId())).thenReturn(null);

        mockMvc.perform(get("/buy/{id}", 1)
                .content(ResulterHandler.asJsonString(1))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotFound());
        verify(domainBuyServer, times(1)).findOneDomainBuy(domainBuy.getId());
        verifyNoMoreInteractions(domainBuyServer);
    }

    @Test
    public void testGetFindOneDomainBuyError500() throws Exception {
        when(domainBuyServer.findOneDomainBuy(domainBuy.getId())).thenThrow(new IllegalArgumentException("Erro serve"));

        mockMvc.perform(get("/buy/{id}", 1)
                .content(ResulterHandler.asJsonString(1))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isInternalServerError());
        verify(domainBuyServer, times(1)).findOneDomainBuy(domainBuy.getId());
        verifyNoMoreInteractions(domainBuyServer);
    }

    @Test
    public void testPostSaveDomainBuySuccess() throws Exception {
        when(domainBuyServer.findOneDomainBuy(domainBuy.getId())).thenReturn(domainBuy);
        doNothing().when(domainBuyServer).saveDomainBuy(domainBuy);

        mockMvc.perform(post("/buy")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(ResulterHandler.asJsonString(domainBuy)))
                .andExpect(status().isOk());
        verify(domainBuyServer, times(1)).saveDomainBuy(domainBuy);
        verifyNoMoreInteractions(domainBuyServer);
    }

    @Test
    public void testPostSaveDomainBuyError500() throws Exception {
        doThrow(new IllegalArgumentException("Error no Serve")).when(domainBuyServer).saveDomainBuy(domainBuy);

        mockMvc.perform(post("/buy")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(ResulterHandler.asJsonString(domainBuy)))
                .andExpect(status().isInternalServerError());
        verify(domainBuyServer, times(1)).saveDomainBuy(domainBuy);
        verifyNoMoreInteractions(domainBuyServer);
    }

    @Test
    public void testDeleteDomainBuySuccess() throws Exception {
        when(domainBuyServer.findOneDomainBuy(domainBuy.getId())).thenReturn(domainBuy);
        doNothing().when(domainBuyServer).deleteDomainBuy(domainBuy.getId());


        mockMvc.perform(delete("/buy/{id}", domainBuy.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(ResulterHandler.asJsonString(domainBuy)))
                .andExpect(status().isOk());

        verify(domainBuyServer, times(1)).findOneDomainBuy(domainBuy.getId());
        verify(domainBuyServer, times(1)).deleteDomainBuy(domainBuy.getId());
        verifyNoMoreInteractions(domainBuyServer);

    }

    @Test
    public void testDeleteDomainBuyError404() throws Exception {
        when(domainBuyServer.findOneDomainBuy(2)).thenReturn(null);

        mockMvc.perform(delete("/buy/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(ResulterHandler.asJsonString(domainBuy)))
                .andExpect(status().isNotFound());

        verify(domainBuyServer, times(1)).findOneDomainBuy(2);
        verifyNoMoreInteractions(domainBuyServer);
    }

    @Test
    public void testDeleteDomainBuyError500() throws Exception {
        when(domainBuyServer.findOneDomainBuy(domainBuy.getId())).thenThrow(new IllegalArgumentException("Error"));

        mockMvc.perform(delete("/buy/{id}", domainBuy.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(ResulterHandler.asJsonString(domainBuy)))
                .andExpect(status().isInternalServerError());

        verify(domainBuyServer, times(1)).findOneDomainBuy(domainBuy.getId());
        verifyNoMoreInteractions(domainBuyServer);
    }

}
