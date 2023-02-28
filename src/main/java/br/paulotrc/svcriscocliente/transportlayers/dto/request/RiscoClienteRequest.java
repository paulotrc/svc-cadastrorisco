package br.paulotrc.svcriscocliente.transportlayers.dto.request;

import br.paulotrc.svcriscocliente.entites.enumerados.TipoRiscoCliente;
import br.paulotrc.svcriscocliente.entites.enumerados.TipoRestricaoRiscoCliente;
import br.paulotrc.svcriscocliente.entites.validators.TipoRiscoClienteValidator;
import br.paulotrc.svcriscocliente.entites.validators.TipoRestricaoRiscoClienteValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RiscoClienteRequest {

    private UUID id = UUID.randomUUID();
    @NotBlank(message = "CPF é obrigatório")
    private String cpf; //Documento de identificação do dono do imóvel
    @PastOrPresent(message = "DataInclusao é obrigatório e não pode ser inclusão futura.")
    private LocalDate dataInclusao;
    @Positive(message = "Validade do risco em meses é obrigatório e deve ser maior que zero.")
    private Integer validadeEmMeses;
    @TipoRiscoClienteValidator(regexp = "ALTO|MEDIO|BAIXO")
    private TipoRiscoCliente tipoRiscoCliente;
    @TipoRestricaoRiscoClienteValidator(regexp = "SPC|SERASA|BACEN|INFO_IMOVEL_IRREGULAR|INFO_AUTOMOVEL_IRREGULAR|SUSPEITA_FRAUDE")
    private TipoRestricaoRiscoCliente restricaoCadastrorisco;
    @NotBlank(message = "Informação de Risco Ativo é obrigatório")
    private Boolean riscoAtivo;


}

