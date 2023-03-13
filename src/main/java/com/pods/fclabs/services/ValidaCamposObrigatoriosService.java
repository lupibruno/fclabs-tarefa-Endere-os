package com.pods.fclabs.services;

import java.util.UUID;

import com.pods.fclabs.models.Endereco;
import org.springframework.stereotype.Service;

import com.pods.fclabs.exception.CampoObrigatorioException;
import com.pods.fclabs.models.Usuario;

@Service
public class ValidaCamposObrigatoriosService {

  
    public void validaCamposObrigatoriosUsuario(Usuario usuario) {
    
    
        validaCampo(usuario.getNome(), "Campo nome é obrigatório para cadastro de Usuario!");
        validaCampo(usuario.getNomeMae(), "Campo Nome Mãe é obrigatório para cadastro de Usuario!");
		validaCampo(usuario.getEndereco(), "Campo endereço é obrigatório para cadastro de Usuario!");
        validaCampo(usuario.getEndereco().getLogradouro(), "Campo logradouro é obrigatório para Endereco!");
        validaCampo(usuario.getEndereco().getNumero(), "Campo numero é obrigatório para Endereco!");
        validaCampo(usuario.getEndereco().getBairro(), "Campo bairro é obrigatório para Endereco!");
        validaCampo(usuario.getEndereco().getCidade(), "Campo cidade é obrigatório para Endereco!");
        validaCampo(usuario.getEndereco().getCep(), "Campo CEP é obrigatório para Endereco!");

    }
    private static void validaCampo(String campo, String mensagemException) {
        if (java.util.Objects.isNull(campo) || campo.isEmpty()) {
            throw new CampoObrigatorioException(mensagemException);
        }
    }

    private static void validaCampo(Endereco endereco, String mensagemException) {
        if (java.util.Objects.isNull(endereco)) {
            throw new CampoObrigatorioException(mensagemException);
        }
    }

    private static void validaCampo(Integer campo, String mensagemException) {
        if (java.util.Objects.isNull(campo) || campo == 0) {
            throw new CampoObrigatorioException(mensagemException);
        }
    }

 

    public void validaIdUsuario(UUID id) {
        validaCampo(id.toString(), "Informar o ID do Usuario");
    }

  

}