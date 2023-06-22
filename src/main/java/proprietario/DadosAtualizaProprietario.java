package proprietario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaProprietario(

        @NotNull

        Long id,
        
        String nome,

        String cpf,

        String telefone

) {
}
