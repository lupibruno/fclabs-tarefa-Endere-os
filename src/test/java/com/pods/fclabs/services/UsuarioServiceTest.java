package com.pods.fclabs.services;

import com.pods.fclabs.models.Endereco;
import com.pods.fclabs.models.Usuario;
import com.pods.fclabs.repositories.UsuarioRepository;
import com.pods.fclabs.util.Util;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private Util util;
    @Mock
    private ValidaCamposObrigatoriosService validaCamposObrigatorios;
    @InjectMocks
    private UsuarioService usuarioService;
    @Test
    public void deveriaSalvarUsuarioComDataDeCriacao() {

        //[GIVEN] Um usuario valido
        Usuario usuario = new Usuario();
        usuario.setNome("Test");
        usuario.setNomeMae("Testona");
        usuario.setEndereco(new Endereco());

        //[WHEN] Quando o usuario for salvo
        usuarioService.salva(usuario);

        //[THEN] O usuario salvo deve ter data de criação
        ArgumentCaptor<Usuario> usuarioCaptor = ArgumentCaptor.forClass(Usuario.class);
        Mockito.verify(usuarioRepository, Mockito.times(1)).save(usuarioCaptor.capture());
        Assertions.assertNotNull(usuarioCaptor.getValue().getDtCriacao());
        Assertions.assertNotNull(usuarioCaptor.getValue().getEndereco().getDtCriacao());


    }

}