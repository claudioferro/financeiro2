package Financeiro.bo;

import Financeiro.dao.FilialDao;
import Financeiro.dao.UsuarioDao;
import Financeiro.to.FilialTo;
import Financeiro.to.UsuarioTo;
import java.util.LinkedList;
import java.util.List;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class UsuarioBo {

    private UsuarioDao usuarioDao = new UsuarioDao();
    private List<UsuarioTo> usuarios;
    private UsuarioTo selectusuario;
    private String valConsulta = "";
    private String status;
    private String mensagem = "";
    private boolean disabled = true;
    private String user;
    private String senha;
    private FilialDao filialDao = new FilialDao();
    private String codEmpresa;
    private String nomeEmpresa;
    private HtmlSelectOneMenu selectEmpresa;
    
    public UsuarioBo() {
    }

    public String doLogin() {
        boolean validated = usuarioDao.isValidLoginAndPassword(user, senha);
        if (validated) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userlogged", validated);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", getUser());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("codEmpresa", getCodEmpresa());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresa", selectEmpresa.getLang());
            nomeEmpresa = selectEmpresa.getLang();
            setMensagem("Usuário ok");
            return "gotoMain";
        } else {
            setCodEmpresa("");
            setUser("");
            setMensagem("Usuário ou senha incorreto!");
            return "reload";
        }
    }

    public String doLogoff() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userlogged", false);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", "");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("codEmpresa", "");
        setUser("");
        setSenha("");
        setMensagem("");
        setCodEmpresa("");
        return "gotoLogin";
    }

    public String limparLogin() {
        setUser("");
        setSenha("");
        setMensagem("");
        setCodEmpresa("");
        return "reload";
    }

    public String limpar() {
        setSelectusuario(new UsuarioTo());
        selectusuario.setCodUsuario(0);
        selectusuario.setCpf("");
        selectusuario.setDepartamento("");
        selectusuario.setLogin("");
        selectusuario.setNome("");
        selectusuario.setSenha("");

        setStatus("s");
        usuarios = null;

        return "gotoCadUsuario";
    }

    public String addUsuario() {
        usuarios = null;
        selectusuario = new UsuarioTo();
        setStatus("s");
        setMensagem("");
        return "gotoCadUsuario";
    }

    public String salvar() {
        try {
            if (getStatus().equals("s")) {
                if (selectusuario.getNome().equals("")) {
                    setMensagem("Campo Nome obrigatório!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getCpf().equals("")) {
                    setMensagem("Campo CPF obrigatório!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getCpf().length() != 11) {
                    setMensagem("CPF inválido!");
                    return "gotoCadUsuario";
                }
                if (ValidaCpf.validacpf(selectusuario.getCpf()) == false) {
                    setMensagem("CPF inválido!");
                    return "gotoCadUsuario";
                }
                if (usuarioDao.consultar_CPF(selectusuario.getCpf()).size() > 0) {
                    setMensagem("Usuário já cadastrado!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getLogin().equals("")) {
                    setMensagem("Campo Login obrigatório!");
                    return "gotoCadUsuario";
                }
                if (usuarioDao.consultar_Login(selectusuario.getLogin()).size() > 0) {
                    setMensagem("Login indisponível!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getSenha().equals("")) {
                    setMensagem("Campo Senha obrigatório!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getDepartamento().equals("")) {
                    setMensagem("Campo Departamento obrigatório!");
                    return "gotoCadUsuario";
                }
                usuarioDao.salvar(getSelectusuario());
                setStatus("a");
                setMensagem("Registro incluido com sucesso!");
            } else {
                if (selectusuario.getNome().equals("")) {
                    setMensagem("Campo Nome obrigatório!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getCpf().equals("")) {
                    setMensagem("Campo CPF obrigatório!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getCpf().length() != 11) {
                    setMensagem("CPF inválido!");
                    return "gotoCadUsuario";
                }
                if (ValidaCpf.validacpf(selectusuario.getCpf()) == false) {
                    setMensagem("CPF inválido!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getLogin().equals("")) {
                    setMensagem("Campo Login obrigatório!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getSenha().equals("")) {
                    setMensagem("Campo Senha obrigatório!");
                    return "gotoCadUsuario";
                }
                if (selectusuario.getDepartamento().equals("")) {
                    setMensagem("Campo Departamento obrigatório!");
                    return "gotoCadUsuario";
                }
                usuarioDao.alterar(getSelectusuario());
                setStatus("a");
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            usuarios = null;
            return "gotoCadUsuario";
        } catch (Exception e) {
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadUsuario";
        }
    }

    public List<UsuarioTo> getUsuario() {
        return usuarios;
    }

    public UsuarioTo consultar(UsuarioTo usuario) {
        return null;
    }

    public String excluir() {
        usuarioDao.excluir(getSelectusuario());

        setMensagem("Registro excluido com sucesso!");
        //Limpar cache
        usuarios = null;
        limpar();
        return "gotoCadUsuario";
    }

    public String fechar() {
        usuarios = null;
        return "gotoMain";
    }

    public String limparCons() {
        usuarios = null;
        valConsulta = null;
        return "cons_usuario";
    }

    public String consult_Usuario() {
        usuarios = null;
        selectusuario = new UsuarioTo();
        usuarios = usuarioDao.consultar_p(valConsulta.toUpperCase() + "%");

        return "cons_usuario";
    }

    public List<UsuarioTo> getUsuarioTos() {
        if (usuarios == null) {
            usuarios = usuarioDao.consultar();
        }
        return usuarios;
    }

    public List<UsuarioTo> getUsuarioTo() {
        return usuarios;

    }

    public String consultar() {
        usuarios = null;
        return "cons_usuario";
    }

    public String iniciaEditUsuario() {
        setStatus("a");
        setMensagem("");
        return "gotoCadUsuario";
    }

    public List<SelectItem> getFiliaisSystem() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();

        for (FilialTo filialTo : filialDao.consultar()) {
            toReturn.add(new SelectItem(filialTo, filialTo.getRazaoSocial()));
        }
        return toReturn;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public UsuarioTo getSelectusuario() {
        return selectusuario;
    }

    public void setSelectusuario(UsuarioTo selectusuario) {

        this.selectusuario = selectusuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsuarioDao getUauarioDao() {
        return usuarioDao;
    }

    public void setUauarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<UsuarioTo> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioTo> usuarios) {
        this.usuarios = usuarios;
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = UsuarioTo.encripta(senha);
    // this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public HtmlSelectOneMenu getSelectEmpresa() {
        return selectEmpresa;
    }

    public void setSelectEmpresa(HtmlSelectOneMenu selectEmpresa) {
        this.selectEmpresa = selectEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    
}