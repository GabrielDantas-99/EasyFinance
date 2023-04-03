import { FormasPagamento } from "../models/FormasPagamento.model";

export class ConvertUtil {

    formasPagamento = new FormasPagamento().formasPagamento;

    getName(code: number) {
        let name = '';
        this.formasPagamento.forEach(fp => {
            if (fp.id == code) {
                name = fp.denominacao;
            }
        });
        return name;
    }
}