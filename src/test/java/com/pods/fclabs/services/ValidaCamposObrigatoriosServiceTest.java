package com.pods.fclabs.services;

import com.pods.fclabs.exception.CampoObrigatorioException;
import com.pods.fclabs.models.Usuario;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class ValidaCamposObrigatoriosServiceTest {
    ValidaCamposObrigatoriosService validador = new ValidaCamposObrigatoriosService();
    @Test
    public void deveriaDarThrowQuandoUsuarioNaoTiverEndereco() {

        //[GIVEN]Dado usuario sem endereço
        Usuario usuario = new Usuario();
        usuario.setNome("Test");
        usuario.setNomeMae("maeTest");


        try {
            //[WHEN]Quando o usuario for validado
            validador.validaCamposObrigatoriosUsuario(usuario);
        } catch (Exception e) {
            //[THEN]Então deveria jogar exceção com mensagem "Campo endereço é obrigatório para cadastro de Usuario!"
            Assertions.assertEquals("Campo endereço é obrigatório para cadastro de Usuario!", e.getMessage());
        }

        /*   OU---

            Assertions.assertThrows(CampoObrigatorioException.class, () -> {
            validador.validaCamposObrigatoriosUsuario(usuario);
        });*/
    }

}