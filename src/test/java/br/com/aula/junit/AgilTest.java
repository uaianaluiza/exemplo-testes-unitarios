package br.com.aula.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgilTest {

    private Agil agil;

    @Before
    public void setup(){
        this.agil = new Agil();
    }

    @Test
    public void testarOCalculoCorretoDePiert(){
        double horasDificeis = 3, horasFaceis = 3, horasNormais = 3;
        double esperado = (horasDificeis+horasFaceis+horasNormais)/6;

        //Resultado esperado 1,5
        double resultado = agil.calcularPert(3,3,3);

        Assert.assertEquals(esperado,resultado,0.004);
    }

    @Test
    public void testarValidacaoDeNumeroNegativosParaHorasNoCalculoDePert(){

       Exception erro = Assert.assertThrows(RuntimeException.class, () -> {
            agil.calcularPert(4,-3,1);
        } );
       Assert.assertEquals("Horas negativas não são aceitas",erro.getMessage());
    }

    @Test
    public void testarValidacaoDeNumeroPositivoCasoPositivo(){
        Assert.assertTrue(agil.validarNumerosPositivos(10));
    }

    @Test
    public void testarValidacaoDeNumeroPositivoCasoNegativo(){
        Assert.assertFalse(agil.validarNumerosPositivos(-2));
    }
}
