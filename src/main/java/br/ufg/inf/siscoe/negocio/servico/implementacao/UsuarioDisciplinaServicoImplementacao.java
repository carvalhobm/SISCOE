package br.ufg.inf.siscoe.negocio.servico.implementacao;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufg.inf.siscoe.comum.calculo.AvaliadorExpressao;
import br.ufg.inf.siscoe.integracao.dao.UsuarioDisciplinaDAO;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;
import br.ufg.inf.siscoe.negocio.servico.UsuarioDisciplinaServico;

/**
 * <p>
 * UsuarioDisciplinaServicoImplementacao.
 * </p>
 * <p>
 * Descrição: Implementacao da interface {@link UsuarioDisciplinaServico}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class UsuarioDisciplinaServicoImplementacao extends ServicoAbstratoImpl<UsuarioDisciplina, UsuarioDisciplinaDAO>
        implements UsuarioDisciplinaServico {

    private static final long serialVersionUID = -8859117560887268394L;

    @Inject
    private UsuarioDisciplinaDAO dao;

    @Override
    public UsuarioDisciplinaDAO getDao() {
        return this.dao;
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioDisciplinaServico
     *      #registrarFaltaUsuarioDisciplina(br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina)
     */
    @Override
    public void registrarFaltaUsuarioDisciplina(UsuarioDisciplina usuarioDisciplina) {
        usuarioDisciplina.setQtFaltas(usuarioDisciplina.getQtFaltas() + usuarioDisciplina.getDisciplina().getNuHoraAula());

        this.getDao().alterar(usuarioDisciplina);
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioDisciplinaServico#salvarNotas(br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina)
     */
    @Override
    public void salvarNotas(UsuarioDisciplina usuarioDisciplina) {

        final AvaliadorExpressao avaliador = new AvaliadorExpressao();

        usuarioDisciplina.setVrMediaFinal(avaliador.simularFormula(usuarioDisciplina, usuarioDisciplina.getDisciplina().getFmMediaFinal()));

        this.getDao().alterar(usuarioDisciplina);
    }
}
