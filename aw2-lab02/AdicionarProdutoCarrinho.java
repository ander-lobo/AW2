package br.com.globalcode.aw.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.globalcode.aw.dao.ProdutoDB;
import br.com.globalcode.model.Produto;
import br.com.globalcode.util.GlobalcodeException;

@WebServlet("/adicionarProdutoCarrinho")
public class AdicionarProdutoCarrinho extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // Obtencao do canal de envio de dados para o cliente
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Carrinho de compras</title>");
        out.println("<meta charset='utf-8'>");
        out.println("<link href= 'css/aw.css' rel='stylesheet'></link>");
        out.println("</head>");
        out.println("<body>");
        out.println("<H3>Adicionando produtos no carrinho de compras</H3>");
        
        // -------------------------------------------------------------------
        // Insira a partir daqui o codigo pedido no laboratorio:
        // -------------------------------------------------------------------
        String produto = request.getParameter("idProduto");
        Produto p;
        request.setAttribute("idProduto", produto);
        try {
			p = new ProdutoDB().getProdutoById(Integer.parseInt("idProduto"));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p = null;
		} catch (GlobalcodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p = null;
		}
        
        
        
        
        
        // Impressao dos dados do produto
        out.println("<br/>id: <strong>" + p.getId() + "</strong>");
        out.println("<br/>nome: <strong>" + p.getNome() + "</strong>");
        out.println("<br/>marca: <strong>" + p.getMarca() + "</strong>");
        out.println("<br/>pre&ccedil;o: <strong>" + p.getPreco() + "</strong>");
        out.println("</body>");
        out.println("</html>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
