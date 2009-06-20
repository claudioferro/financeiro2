package Financeiro.bo;

import Financeiro.dao.ContasPagarReceberDao;
import Financeiro.dao.MovimentacaoFinanceiraDao;
import Financeiro.to.ContaCorrenteTo;
import Financeiro.to.ContasPagarReceberTo;
import Financeiro.to.MovimentacaoFinanceiraTo;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RelatoriosBo {

    public ContaCorrenteTo contaCorrente;
    public String statusRelatorio;
    public Date dataInicial;
    public Date dataFinal;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    String object = (String) session.getAttribute("codEmpresa");
    int codEmpresa = Integer.parseInt(object);
    public String mensagem = "";

    public String imprimirMovimentacaoFinanceira() {
        MovimentacaoFinanceiraDao movimentacaoFinanceiraDao = new MovimentacaoFinanceiraDao();
        Integer codContaCorrente = contaCorrente.getCodContaCorrente();
        //valida data
        List<MovimentacaoFinanceiraTo> movimentacaoFinanceiraTo = movimentacaoFinanceiraDao.consultarRelatorioAtivo(codEmpresa,codContaCorrente,dataInicial,dataFinal);
        //valida retorno

        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String pathRelatorio = servletContext.getRealPath("/core/report");
            Map<String, Object> parametros = new HashMap<String, Object>();


            JasperPrint relFornecedor = JasperFillManager.fillReport(pathRelatorio + "\\movimentacaoFinanceira.jasper", null, new JRBeanCollectionDataSource(movimentacaoFinanceiraTo));
            byte[] bytes = JasperExportManager.exportReportToPdf(relFornecedor);
            facesContext.getExternalContext().getSessionMap().put("RELATORIO", bytes);
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            response.setHeader("Content-Disposition", "inline; filename=\"fornecedor.pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);
            facesContext.responseComplete();
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e);
        }
        return "ok";

    }

    public String imprimir() {
        ContasPagarReceberDao contasPagarReceberDao = new ContasPagarReceberDao();
        //valida data
        List<ContasPagarReceberTo> contasPagarReceberTo1 = null;
        //valida retorno
        if (statusRelatorio.equals("A")) {
            contasPagarReceberTo1 = contasPagarReceberDao.consultarRelatorioAtivo(statusRelatorio, dataInicial, dataFinal, codEmpresa);
        } else {
            if (statusRelatorio.equals("L")) {
                contasPagarReceberTo1 = contasPagarReceberDao.consultarRelatorioLiquidado(statusRelatorio, dataInicial, dataFinal, codEmpresa);
            } else {
                if (statusRelatorio.equals("T")) {

                    contasPagarReceberTo1 = contasPagarReceberDao.consultarRelatorioTodos(dataInicial, dataFinal, codEmpresa);
                } else {
                    contasPagarReceberTo1 = null;
                }
            }
        }





        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String pathRelatorio = servletContext.getRealPath("/core/report");
            Map<String, Object> parametros = new HashMap<String, Object>();


            JasperPrint relFornecedor = JasperFillManager.fillReport(pathRelatorio + "\\teste.jasper", null, new JRBeanCollectionDataSource(contasPagarReceberTo1));
            byte[] bytes = JasperExportManager.exportReportToPdf(relFornecedor);
            facesContext.getExternalContext().getSessionMap().put("RELATORIO", bytes);
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            response.setHeader("Content-Disposition", "inline; filename=\"fornecedor.pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);
            facesContext.responseComplete();
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e);
        }
        return "ok";
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getStatusRelatorio() {
        return statusRelatorio;
    }

    public void setStatusRelatorio(String statusRelatorio) {
        this.statusRelatorio = statusRelatorio;
    }

    public ContaCorrenteTo getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrenteTo contaCorrente) {
        this.contaCorrente = contaCorrente;
    }


   public String limparCons() {
      contaCorrente = null;
      return "ok";
   }
  
    
}
