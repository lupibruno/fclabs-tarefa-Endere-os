package com.pods.fclabs.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@ApiModel(value = "Objeto Endereco",subTypes = {Endereco.class})
@Data
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    @ApiModelProperty(dataType = "String", example = "Rua José João Pedro", required = true, position = 1)
    private String logradouro;

    @ApiModelProperty(dataType = "Integer", example = "123", required = true, position = 2)
    private Integer numero;

    @ApiModelProperty(dataType = "String", example = "Balneário Flórida", required = true, position = 3)
    private String bairro;

    @ApiModelProperty(dataType = "String", example = "Praia Grande", required = true, position = 4)
    private String cidade;

    @ApiModelProperty(dataType = "String", example = "11700-140", required = true, position = 5)
    private String cep;
    @ApiModelProperty(dataType = "String", example = "Ap134", required = false, position = 6)
    private String complemento;

    @ApiModelProperty(hidden = true)
    private Date dtCriacao;
    @ApiModelProperty(hidden = true)
    private Date dtUltAlteracao;

}
